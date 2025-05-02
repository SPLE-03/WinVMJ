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

	public ConsultationImpl(UUID consultationId, String consultationSubject, String consultationDescription, boolean consultationStatus) {
		this.consultationId =  consultationId.randomUUID();;
		this.consultationId = consultationId;
		this.consultationSubject = consultationSubject;
		this.consultationDescription = consultationDescription;
		this.consultationStatus = consultationStatus;
	}

	public ConsultationImpl() { }


	public boolean consultationUpdate(String subject, String description) {
		// TODO: implement this method
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
