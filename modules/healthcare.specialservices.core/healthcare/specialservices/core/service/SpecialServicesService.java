package healthcare.specialservices.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SpecialServicesService {
	SpecialServices createSpecialServices(Map<String, Object> requestBody);
	HashMap<String, Object> getSpecialServices(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveSpecialServices(VMJExchange vmjExchange);
    HashMap<String, Object> updateSpecialServices(Map<String, Object> requestBody);
    HashMap<String, Object> getSpecialServicesById(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSpecialServices(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteSpecialServices(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<SpecialServices> List);
}
