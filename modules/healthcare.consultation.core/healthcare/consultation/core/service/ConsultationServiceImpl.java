package healthcare.consultation.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.consultation.ConsultationFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ConsultationServiceImpl extends ConsultationServiceComponent{

    public List<HashMap<String,Object>> saveConsultation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Consultation consultation = createConsultation(vmjExchange);
		consultationRepository.saveObject(consultation);
		return getAllConsultation(vmjExchange);
	}

    public Consultation createConsultation(Map<String, Object> requestBody){
		String consultationSubject = (String) requestBody.get("consultationSubject");
		String consultationDescription = (String) requestBody.get("consultationDescription");
		boolean consultationStatus = (boolean) requestBody.get("consultationStatus");
		
		//to do: fix association attributes
		Consultation Consultation = ConsultationFactory.createConsultation(
			"healthcare.consultation.core.ConsultationImpl",
		consultationId
		, consultationSubject
		, consultationDescription
		, consultationStatus
		);
		Repository.saveObject(consultation);
		return consultation;
	}

    public Consultation createConsultation(Map<String, Object> requestBody, int id){
		String consultationSubject = (String) vmjExchange.getRequestBodyForm("consultationSubject");
		String consultationDescription = (String) vmjExchange.getRequestBodyForm("consultationDescription");
		boolean consultationStatus = (boolean) vmjExchange.getRequestBodyForm("consultationStatus");
		
		//to do: fix association attributes
		
		Consultation consultation = ConsultationFactory.createConsultation("healthcare.consultation.core.ConsultationImpl", consultationId, consultationSubject, consultationDescription, consultationStatus);
		return consultation;
	}

    public HashMap<String, Object> updateConsultation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("consultationId");
		int id = Integer.parseInt(idStr);
		Consultation consultation = Repository.getObject(id);
		
		consultation.setConsultationSubject((String) requestBody.get("consultationSubject"));
		consultation.setConsultationDescription((String) requestBody.get("consultationDescription"));
		consultation.setConsultationStatus((String) requestBody.get("consultationStatus"));
		
		Repository.updateObject(consultation);
		
		//to do: fix association attributes
		
		return consultation.toHashMap();
		
	}

    public HashMap<String, Object> getConsultation(Map<String, Object> requestBody){
		List<HashMap<String, Object>> consultationList = getAllConsultation("consultation_impl");
		for (HashMap<String, Object> consultation : consultationList){
			int record_id = ((Double) consultation.get("record_id")).intValue();
			if (record_id == id){
				return consultation;
			}
		}
		return null;
	}

	public HashMap<String, Object> getConsultationById(int id){
		String idStr = vmjExchange.getGETParam("consultationId"); 
		int id = Integer.parseInt(idStr);
		Consultation consultation = consultationRepository.getObject(id);
		return consultation.toHashMap();
	}

    public List<HashMap<String,Object>> getAllConsultation(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Consultation> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Consultation> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteConsultation(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllConsultation(requestBody);
	}

	public boolean consultationUpdate(String subject, String description) {
		// TODO: implement this method
	}
}
