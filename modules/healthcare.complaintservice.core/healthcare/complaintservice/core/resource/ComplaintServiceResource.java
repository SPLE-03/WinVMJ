package healthcare.complaintservice.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ComplaintServiceResource {
    List<HashMap<String,Object>> saveComplaintService(VMJExchange vmjExchange);
    HashMap<String, Object> updateComplaintService(VMJExchange vmjExchange);
    HashMap<String, Object> getComplaintService(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllComplaintService(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteComplaintService(VMJExchange vmjExchange);
	HashMap<String, Object> createComplaintService(VMJExchange vmjExhange);
}
