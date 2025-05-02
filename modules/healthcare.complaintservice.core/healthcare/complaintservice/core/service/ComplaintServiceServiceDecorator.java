package healthcare.complaintservice.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ComplaintServiceServiceDecorator extends ComplaintServiceServiceComponent{
	protected ComplaintServiceServiceComponent record;

    public ComplaintServiceServiceDecorator(ComplaintServiceServiceComponent record) {
        this.record = record;
    }

	public ComplaintServiceImpl createComplaintService(Map<String, Object> requestBody){
		return record.createComplaintService(requestBody);
	}

    public ComplaintService createComplaintService(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createComplaintService(requestBody, response);
	}

	public HashMap<String, Object> getComplaintService(Map<String, Object> requestBody){
		return record.getComplaintService(requestBody);
	}

	public List<HashMap<String,Object>> getAllComplaintService(Map<String, Object> requestBody){
		return record.getAllComplaintService(requestBody);
	}

    public List<HashMap<String,Object>> saveComplaintService(VMJExchange vmjExchange){
		return record.saveComplaintService(vmjExchange);
	}

    public HashMap<String, Object> updateComplaintService(Map<String, Object> requestBody){
		return record.updateComplaintService(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<ComplaintService> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteComplaintService(Map<String, Object> requestBody){
		return record.deleteComplaintService(requestBody);
	}

	public HashMap<String, Object> getComplaintServiceById(int id){
        return record.getComplaintServiceById(id);
    }

	public boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage) {
		return record.submitComplaint(userId, complaintSubject, complaintMessage);
	}
}
