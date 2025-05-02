package healthcare.complaintservice.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ComplaintServiceService {
	ComplaintService createComplaintService(Map<String, Object> requestBody);
	ComplaintService createComplaintService(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getComplaintService(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveComplaintService(Map<String, Object> requestBody);
    HashMap<String, Object> updateComplaintService(Map<String, Object> requestBody);
    HashMap<String, Object> getComplaintServiceById(int id);
    List<HashMap<String,Object>> getAllComplaintService(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteComplaintService(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
