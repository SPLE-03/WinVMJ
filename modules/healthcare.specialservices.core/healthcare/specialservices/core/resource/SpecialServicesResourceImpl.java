package healthcare.specialservices.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.specialservices.SpecialServicesFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SpecialServicesResourceImpl extends SpecialServicesResourceComponent{
	
	private SpecialServicesServiceImpl specialservicesServiceImpl = new SpecialServicesServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/specialservices")
    public HashMap<String,Object> createspecialservices(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			SpecialServices result = specialservicesServiceImpl.createSpecialServices(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/specialservices/update")
    public HashMap<String, Object> updateSpecialServices(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return specialservicesServiceImpl.updateSpecialServices(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/specialservices/detail")
    public HashMap<String, Object> getSpecialServices(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return specialservicesServiceImpl.getSpecialServices(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/specialservices/list")
    public List<HashMap<String,Object>> getAllSpecialServices(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return specialservicesServiceImpl.getAllSpecialServices(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/specialservices/delete")
    public List<HashMap<String,Object>> deleteSpecialServices(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return specialservicesServiceImpl.deleteSpecialServices(requestBody);
	}

	public int calculatePrice() {
		// TODO: implement this method
	}

	public boolean isAvailable() {
		// TODO: implement this method
	}

	public boolean callService(UUID id) {
		// TODO: implement this method
	}

	public String getDetails(UUID id) {
		// TODO: implement this method
	}

	public boolean cancelService(UUID id) {
		// TODO: implement this method
	}
}
