package healthcare.specialservices.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SpecialServicesService {
	SpecialServices createSpecialServices(Map<String, Object> requestBody);
	SpecialServices createSpecialServices(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getSpecialServices(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveSpecialServices(Map<String, Object> requestBody);
    HashMap<String, Object> updateSpecialServices(Map<String, Object> requestBody);
    HashMap<String, Object> getSpecialServicesById(int id);
    List<HashMap<String,Object>> getAllSpecialServices(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteSpecialServices(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
