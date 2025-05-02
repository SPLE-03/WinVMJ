package healthcare.consultation.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.consultation.ConsultationFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ConsultationResourceImpl extends ConsultationResourceComponent{
	
	private ConsultationServiceImpl consultationServiceImpl = new ConsultationServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/consultation")
    public HashMap<String,Object> createconsultation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Consultation result = consultationServiceImpl.createConsultation(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/consultation/update")
    public HashMap<String, Object> updateConsultation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return consultationServiceImpl.updateConsultation(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/consultation/detail")
    public HashMap<String, Object> getConsultation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return consultationServiceImpl.getConsultation(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/consultation/list")
    public List<HashMap<String,Object>> getAllConsultation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return consultationServiceImpl.getAllConsultation(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/consultation/delete")
    public List<HashMap<String,Object>> deleteConsultation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return consultationServiceImpl.deleteConsultation(requestBody);
	}

	public boolean consultationUpdate(String subject, String description) {
		// TODO: implement this method
	}
}
