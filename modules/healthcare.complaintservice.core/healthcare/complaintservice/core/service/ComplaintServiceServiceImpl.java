package healthcare.complaintservice.core;
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
import healthcare.complaintservice.ComplaintServiceFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ComplaintServiceServiceImpl extends ComplaintServiceServiceComponent{

    public List<HashMap<String,Object>> saveComplaintService(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		ComplaintService complaintservice = createComplaintService(vmjExchange);
		complaintserviceRepository.saveObject(complaintservice);
		return getAllComplaintService(vmjExchange);
	}

    public ComplaintService createComplaintService(Map<String, Object> requestBody){
		String complaintSubject = (String) requestBody.get("complaintSubject");
		String complaintMessage = (String) requestBody.get("complaintMessage");
		
		//to do: fix association attributes
		ComplaintService ComplaintService = ComplaintServiceFactory.createComplaintService(
			"healthcare.complaintservice.core.ComplaintServiceImpl",
		complaintServiceId
		, complaintServiceUser
		, complaintSubject
		, complaintMessage
		);
		Repository.saveObject(complaintservice);
		return complaintservice;
	}

    public ComplaintService createComplaintService(Map<String, Object> requestBody, int id){
		String complaintSubject = (String) vmjExchange.getRequestBodyForm("complaintSubject");
		String complaintMessage = (String) vmjExchange.getRequestBodyForm("complaintMessage");
		
		//to do: fix association attributes
		
		ComplaintService complaintservice = ComplaintServiceFactory.createComplaintService("healthcare.complaintservice.core.ComplaintServiceImpl", complaintServiceId, complaintServiceUser, complaintSubject, complaintMessage);
		return complaintservice;
	}

    public HashMap<String, Object> updateComplaintService(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("complaintServiceId");
		int id = Integer.parseInt(idStr);
		ComplaintService complaintservice = Repository.getObject(id);
		
		complaintservice.setComplaintSubject((String) requestBody.get("complaintSubject"));
		complaintservice.setComplaintMessage((String) requestBody.get("complaintMessage"));
		
		Repository.updateObject(complaintservice);
		
		//to do: fix association attributes
		
		return complaintservice.toHashMap();
		
	}

    public HashMap<String, Object> getComplaintService(Map<String, Object> requestBody){
		List<HashMap<String, Object>> complaintserviceList = getAllComplaintService("complaintservice_impl");
		for (HashMap<String, Object> complaintservice : complaintserviceList){
			int record_id = ((Double) complaintservice.get("record_id")).intValue();
			if (record_id == id){
				return complaintservice;
			}
		}
		return null;
	}

	public HashMap<String, Object> getComplaintServiceById(int id){
		String idStr = vmjExchange.getGETParam("complaintServiceId"); 
		int id = Integer.parseInt(idStr);
		ComplaintService complaintservice = complaintserviceRepository.getObject(id);
		return complaintservice.toHashMap();
	}

    public List<HashMap<String,Object>> getAllComplaintService(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<ComplaintService> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ComplaintService> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteComplaintService(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllComplaintService(requestBody);
	}

	public boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage) {
		// TODO: implement this method
	}
}
