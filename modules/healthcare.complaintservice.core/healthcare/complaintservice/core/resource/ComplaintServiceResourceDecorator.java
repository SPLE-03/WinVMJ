package healthcare.complaintservice.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ComplaintServiceResourceDecorator extends ComplaintServiceResourceComponent{
	protected ComplaintServiceResourceComponent record;

    public ComplaintServiceResourceDecorator(ComplaintServiceResourceComponent record) {
        this.record = record;
    }

    public ComplaintService createComplaintService(VMJExchange vmjExchange){
		return record.createComplaintService(vmjExchange);
	}

    public HashMap<String, Object> updateComplaintService(VMJExchange vmjExchange){
		return record.updateComplaintService(vmjExchange);
	}

    public HashMap<String, Object> getComplaintService(VMJExchange vmjExchange){
		return record.getComplaintService(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllComplaintService(VMJExchange vmjExchange){
		return record.getAllComplaintService(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteComplaintService(VMJExchange vmjExchange){
		return record.deleteComplaintService(vmjExchange);
	}

	public boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage) {
		return record.submitComplaint(userId, complaintSubject, complaintMessage);
	}
}
