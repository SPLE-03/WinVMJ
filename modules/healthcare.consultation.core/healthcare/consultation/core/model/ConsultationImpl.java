package healthcare.consultation.core;

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


@Entity(name="consultation_impl")
@Table(name="consultation_impl")
public class ConsultationImpl extends ConsultationComponent {

	public ConsultationImpl(UUID consultationId, String consultationSubject, String consultationDescription, boolean consultationStatus) {
		this.consultationId = consultationId;
		this.consultationSubject = consultationSubject;
		this.consultationDescription = consultationDescription;
		this.consultationStatus = consultationStatus;
	}

	public ConsultationImpl() { }

	public UUID getConsultationId() {
		return this.consultationId;
	}
	public void setConsultationId(UUID consultationId) {
		this.consultationId = consultationId;
	}
	public String getConsultationSubject() {
		return this.consultationSubject;
	}
	public void setConsultationSubject(String consultationSubject) {
		this.consultationSubject = consultationSubject;
	}
	public String getConsultationDescription() {
		return this.consultationDescription;
	}
	public void setConsultationDescription(String consultationDescription) {
		this.consultationDescription = consultationDescription;
	}
	public boolean getConsultationStatus() {
		return this.consultationStatus;
	}
	public void setConsultationStatus(boolean consultationStatus) {
		this.consultationStatus = consultationStatus;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> consultationMap = new HashMap<String,Object>();
		consultationMap.put("consultationId",getConsultationId());
		consultationMap.put("consultationSubject",getConsultationSubject());
		consultationMap.put("consultationDescription",getConsultationDescription());
		consultationMap.put("consultationStatus",getConsultationStatus());

        return consultationMap;
    }

}
