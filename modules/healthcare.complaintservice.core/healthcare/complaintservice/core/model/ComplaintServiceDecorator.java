package healthcare.complaintservice.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ComplaintServiceDecorator extends ComplaintServiceComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ComplaintServiceComponent record;

	public ComplaintServiceDecorator () {
		super();
		this.record = record;
		this.complaintServiceId =  complaintServiceId.randomUUID();
		
	public ComplaintServiceDecorator (ComplaintServiceComponent record) {
		this.complaintServiceId =  complaintServiceId.randomUUID();
		this.record = record;
	}

	public ComplaintServiceDecorator (UUID complaintServiceId, ComplaintServiceComponent record) {
		this.complaintServiceId =  complaintServiceId;
		this.record = record;
	}
	
	public ComplaintServiceDecorator (ComplaintServiceComponent record, String objectName) {
		this.complaintServiceId =  complaintServiceId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ComplaintServiceDecorator() { }


	public boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage) {
		return record.submitComplaint(userId, complaintSubject, complaintMessage);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
