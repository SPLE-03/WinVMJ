package healthcare.complaintservice.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="complaintservice_impl")
@Table(name="complaintservice_impl")
public class ComplaintServiceImpl extends ComplaintServiceComponent {

	public ComplaintServiceImpl(UUID complaintServiceId, UUID complaintServiceUser, String complaintSubject, String complaintMessage) {
		this.complaintServiceId = complaintServiceId;
		this.complaintServiceUser = complaintServiceUser;
		this.complaintSubject = complaintSubject;
		this.complaintMessage = complaintMessage;
	}

	public ComplaintServiceImpl(UUID complaintServiceId, UUID complaintServiceUser, String complaintSubject, String complaintMessage) {
		this.complaintServiceId =  complaintServiceId.randomUUID();;
		this.complaintServiceId = complaintServiceId;
		this.complaintServiceUser = complaintServiceUser;
		this.complaintSubject = complaintSubject;
		this.complaintMessage = complaintMessage;
	}

	public ComplaintServiceImpl() { }


	public boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage) {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> complaintserviceMap = new HashMap<String,Object>();
		complaintserviceMap.put("complaintServiceId",getComplaintServiceId());
		complaintserviceMap.put("complaintServiceUser",getComplaintServiceUser());
		complaintserviceMap.put("complaintSubject",getComplaintSubject());
		complaintserviceMap.put("complaintMessage",getComplaintMessage());

        return complaintserviceMap;
    }

}
