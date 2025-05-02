package healthcare.information.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InformationService {
	Information createInformation(Map<String, Object> requestBody);
	Information createInformation(Map<String, Object> requestBody, Map<String, Object> response);
    List<HashMap<String,Object>> saveInformation(VMJExchange vmjExchange);
    HashMap<String, Object> updateInformation(Map<String, Object> requestBody);
    HashMap<String, Object> getInformationById(int id);
    List<HashMap<String,Object>> getAllInformation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteInformation(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Information> List);
}
