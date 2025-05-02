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
import vmj.auth.annotations.Restricted;
//add other required packages

public class ConsultationServiceImpl extends ConsultationServiceComponent{

    public List<HashMap<String,Object>> saveConsultation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		Consultation consultation = createConsultation(requestBody);
		Repository.saveObject(consultation);
		return getAllConsultation(requestBody);
	}

    public Consultation createConsultation(Map<String, Object> requestBody){
		String consultationSubject = (String) requestBody.get("consultationSubject");
		String consultationDescription = (String) requestBody.get("consultationDescription");
		boolean consultationStatus = (boolean) requestBody.get("consultationStatus");
		
		//to do: fix association attributes
		Consultation Consultation = ConsultationFactory.createConsultation(
			"healthcare.consultation.core.ConsultationImpl",
		UUID.randomUUID()
		, consultationSubject
		, consultationDescription
		, consultationStatus
		);
		Repository.saveObject(Consultation);
		return Consultation;
	}

    public Consultation createConsultation(Map<String, Object> requestBody, Map<String, Object> responses){
		String consultationSubject = (String) requestBody.get("consultationSubject");
		String consultationDescription = (String) requestBody.get("consultationDescription");
		boolean consultationStatus = (boolean) requestBody.get("consultationStatus");
		
		//to do: fix association attributes
		
		Consultation consultation = ConsultationFactory.createConsultation("healthcare.consultation.core.ConsultationImpl", UUID.randomUUID(), consultationSubject, consultationDescription, consultationStatus);
		return consultation;
	}

    public HashMap<String, Object> updateConsultation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("consultationId");
		int id = Integer.parseInt(idStr);
		Consultation consultation = Repository.getObject(id);
		
		consultation.setConsultationSubject((String) requestBody.get("consultationSubject"));
		consultation.setConsultationDescription((String) requestBody.get("consultationDescription"));
		consultation.setConsultationStatus((Boolean) requestBody.get("consultationStatus"));
		
		Repository.updateObject(consultation);
		
		//to do: fix association attributes
		
		return consultation.toHashMap();
		
	}

    public HashMap<String, Object> getConsultation(Map<String, Object> requestBody){
    	int id = ((Double) requestBody.get("record_id")).intValue();
		List<HashMap<String, Object>> consultationList = getAllConsultation(requestBody);
		for (HashMap<String, Object> consultation : consultationList){
			int record_id = ((Double) consultation.get("record_id")).intValue();
			if (record_id == id){
				return consultation;
			}
		}
		return null;
	}

	public HashMap<String, Object> getConsultationById(int id){
		Consultation consultation = Repository.getObject(id);
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
}
