package healthcare.consultation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="consultation_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ConsultationComponent implements Consultation{
	@Id
	public UUID consultationId; 
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  consultationId;
	public String consultationSubject;
	public String consultationDescription;
	public boolean consultationStatus;
	protected String objectName = ConsultationComponent.class.getName();

	public ConsultationComponent() {

	} 

	public ConsultationComponent(
        UUID consultationId, String consultationSubject, String consultationDescription, boolean consultationStatus
    ) {
        this.consultationId = consultationId;
        this.consultationSubject = consultationSubject;
        this.consultationDescription = consultationDescription;
        this.consultationStatus = consultationStatus;
    }

	public abstract UUID getConsultationId();
	public abstract void setConsultationId(UUID consultationId);
	
	public abstract String getConsultationSubject();
	public abstract void setConsultationSubject(String consultationSubject);
	
	public abstract String getConsultationDescription();
	public abstract void setConsultationDescription(String consultationDescription);
	
	public abstract boolean getConsultationStatus();
	public abstract void setConsultationStatus(boolean consultationStatus);
	
 
	public abstract boolean consultationUpdate(String subject, String description);

	@Override
    public String toString() {
        return "{" +
            " consultationId='" + getConsultationId() + "'" +
            " consultationSubject='" + getConsultationSubject() + "'" +
            " consultationDescription='" + getConsultationDescription() + "'" +
            " consultationStatus='" + getConsultationStatus() + "'" +
            "}";
    }
	
}
