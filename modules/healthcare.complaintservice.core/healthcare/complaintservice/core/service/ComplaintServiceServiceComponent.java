package healthcare.complaintservice.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ComplaintServiceServiceComponent implements ComplaintServiceService{
	protected RepositoryUtil<ComplaintService> Repository;

    public ComplaintServiceServiceComponent(){
        this.Repository = new RepositoryUtil<ComplaintService>(healthcare.complaintservice.core.ComplaintServiceComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveComplaintService(VMJExchange vmjExchange);
    public abstract ComplaintService createComplaintService(Map<String, Object> requestBodye);
	public abstract ComplaintService createComplaintService(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateComplaintService(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getComplaintService(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllComplaintService(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<ComplaintService> List);
    public abstract List<HashMap<String,Object>> deleteComplaintService(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getComplaintServiceById(int id);

	public abstract boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage);
}
