package healthcare.complaintservice.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface ComplaintService {
	public UUID getComplaintServiceId();
	public void setComplaintServiceId(UUID complaintServiceId);
	public UUID getComplaintServiceUser();
	public void setComplaintServiceUser(UUID complaintServiceUser);
	public String getComplaintSubject();
	public void setComplaintSubject(String complaintSubject);
	public String getComplaintMessage();
	public void setComplaintMessage(String complaintMessage);
	public boolean submitComplaint(String complaintSubject, String complaintMessage);
	HashMap<String, Object> toHashMap();
}
