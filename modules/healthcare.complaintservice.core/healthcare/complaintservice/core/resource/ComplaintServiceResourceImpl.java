package healthcare.complaintservice.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.complaintservice.ComplaintServiceFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ComplaintServiceResourceImpl extends ComplaintServiceResourceComponent{
	
	private ComplaintServiceServiceImpl complaintserviceServiceImpl = new ComplaintServiceServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/complaintservice")
    public HashMap<String,Object> createcomplaintservice(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			ComplaintService result = complaintserviceServiceImpl.createComplaintService(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/complaintservice/update")
    public HashMap<String, Object> updateComplaintService(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return complaintserviceServiceImpl.updateComplaintService(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/complaintservice/detail")
    public HashMap<String, Object> getComplaintService(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return complaintserviceServiceImpl.getComplaintService(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/complaintservice/list")
    public List<HashMap<String,Object>> getAllComplaintService(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return complaintserviceServiceImpl.getAllComplaintService(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/complaintservice/delete")
    public List<HashMap<String,Object>> deleteComplaintService(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return complaintserviceServiceImpl.deleteComplaintService(requestBody);
	}

	public boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage) {
		// TODO: implement this method
	}
}
