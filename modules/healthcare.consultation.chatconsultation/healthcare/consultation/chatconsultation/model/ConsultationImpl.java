package healthcare.consultation.chatconsultation;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.consultation.core.ConsultationDecorator;
import healthcare.consultation.core.Consultation;
import healthcare.consultation.core.ConsultationComponent;

@Entity(name="consultation_chatconsultation")
@Table(name="consultation_chatconsultation")
public class ConsultationImpl extends ConsultationDecorator {

	public EEList ListChatMessages;
	public ConsultationImpl(
        super();
        this.objectName = ConsultationImpl.class.getName();
    }
    
    public ConsultationImpl(EEList ListChatMessages) {
    	super();
		this.ListChatMessages = ListChatMessages;
		this.objectName = ConsultationImpl.class.getName();
    }
	
	public ConsultationImpl(ConsultationComponent record, EEList ListChatMessages) {
		super(record);
		this.ListChatMessages = ListChatMessages;
		this.objectName = ConsultationImpl.class.getName();
	}



}
