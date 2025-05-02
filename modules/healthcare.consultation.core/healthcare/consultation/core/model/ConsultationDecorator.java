package healthcare.consultation.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ConsultationDecorator extends ConsultationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ConsultationComponent record;

	public ConsultationDecorator () {
		super();
		this.record = record;
		this.consultationId =  consultationId.randomUUID();
		
	public ConsultationDecorator (ConsultationComponent record) {
		this.consultationId =  consultationId.randomUUID();
		this.record = record;
	}

	public ConsultationDecorator (UUID consultationId, ConsultationComponent record) {
		this.consultationId =  consultationId;
		this.record = record;
	}
	
	public ConsultationDecorator (ConsultationComponent record, String objectName) {
		this.consultationId =  consultationId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ConsultationDecorator() { }


	public boolean consultationUpdate(String subject, String description) {
		return record.consultationUpdate(subject, description);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
