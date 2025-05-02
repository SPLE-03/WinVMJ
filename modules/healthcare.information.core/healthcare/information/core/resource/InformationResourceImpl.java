package healthcare.information.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.information.InformationFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InformationResourceImpl extends InformationResourceComponent{
	
	private InformationServiceImpl informationServiceImpl = new InformationServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/information")
    public HashMap<String,Object> createInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Information result = informationServiceImpl.createInformation(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/information/update")
    public HashMap<String, Object> updateInformation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return informationServiceImpl.updateInformation(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/information/detail")
    public HashMap<String, Object> getInformation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return informationServiceImpl.getInformation(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/information/list")
    public List<HashMap<String,Object>> getAllInformation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return informationServiceImpl.getAllInformation(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/information/delete")
    public List<HashMap<String,Object>> deleteInformation(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return informationServiceImpl.deleteInformation(requestBody);
	}

}
