package healthcare.sercore.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.sercore.UserFactory;
//import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class UserResourceImpl extends UserResourceComponent{
	
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	// @Restriced(permission = "")
    @Route(url="call/sercore")
    public HashMap<String,Object> createuser(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			User result = userServiceImpl.createUser(requestBody);
			return result.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // @Restriced(permission = "")
    @Route(url="call/sercore/update")
    public HashMap<String, Object> updateUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return userServiceImpl.updateUser(requestBody);
		
	}

	// @Restriced(permission = "")
    @Route(url="call/sercore/detail")
    public HashMap<String, Object> getUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return userServiceImpl.getUser(requestBody);
	}

	// @Restriced(permission = "")
    @Route(url="call/sercore/list")
    public List<HashMap<String,Object>> getAllUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return userServiceImpl.getAllUser(requestBody);
	}

    
	// @Restriced(permission = "")
    @Route(url="call/sercore/delete")
    public List<HashMap<String,Object>> deleteUser(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return userServiceImpl.deleteUser(requestBody);
	}

}
