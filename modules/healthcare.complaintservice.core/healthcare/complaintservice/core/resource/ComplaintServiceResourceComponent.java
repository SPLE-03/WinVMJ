package healthcare.complaintservice.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ComplaintServiceResourceComponent implements ComplaintServiceResource{
	
	public ComplaintServiceResourceComponent() { }
 
    public abstract ComplaintService createComplaintService(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateComplaintService(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getComplaintService(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllComplaintService(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteComplaintService(VMJExchange vmjExchange);

	public abstract boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage);
}
