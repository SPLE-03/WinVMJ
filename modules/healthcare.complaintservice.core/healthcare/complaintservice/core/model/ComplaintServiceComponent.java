package healthcare.complaintservice.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="complaintservice_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ComplaintServiceComponent implements ComplaintService{
	@Id
	public UUID complaintServiceId; 
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  complaintServiceId;
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  complaintServiceUser;
	public String complaintSubject;
	public String complaintMessage;
	protected String objectName = ComplaintServiceComponent.class.getName();

	public ComplaintServiceComponent() {

	} 

	public ComplaintServiceComponent(
        UUID complaintServiceId, UUID complaintServiceUser, String complaintSubject, String complaintMessage
    ) {
        this.complaintServiceId = complaintServiceId;
        this.complaintServiceUser = complaintServiceUser;
        this.complaintSubject = complaintSubject;
        this.complaintMessage = complaintMessage;
    }

	public abstract UUID getComplaintServiceId();
	public abstract void setComplaintServiceId(UUID complaintServiceId);
	
	public abstract UUID getComplaintServiceUser();
	public abstract void setComplaintServiceUser(UUID complaintServiceUser);
	
	public abstract String getComplaintSubject();
	public abstract void setComplaintSubject(String complaintSubject);
	
	public abstract String getComplaintMessage();
	public abstract void setComplaintMessage(String complaintMessage);
	
 
	public abstract boolean submitComplaint(UUID userId, String complaintSubject, String complaintMessage);

	@Override
    public String toString() {
        return "{" +
            " complaintServiceId='" + getComplaintServiceId() + "'" +
            " complaintServiceUser='" + getComplaintServiceUser() + "'" +
            " complaintSubject='" + getComplaintSubject() + "'" +
            " complaintMessage='" + getComplaintMessage() + "'" +
            "}";
    }
	
}
