package healthcare.consultation.chatconsultation;

import java.util.*;
import healthcare.consultation.chatconsultation.ChatMessage;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "consultation_id")
    public List<ChatMessage> listChatMessages;
    
    public ConsultationImpl() {
        super();
        this.objectName = ConsultationImpl.class.getName();
        this.listChatMessages = new ArrayList<>();
    }
    
    public ConsultationImpl(List<ChatMessage> listChatMessages) {
        super();
        this.listChatMessages = listChatMessages;
        this.objectName = ConsultationImpl.class.getName();
    }
    
    public ConsultationImpl(ConsultationComponent record, List<ChatMessage> listChatMessages) {
        super(record);
        this.listChatMessages = listChatMessages;
        this.objectName = ConsultationImpl.class.getName();
    }
    
    @Override
    public UUID getConsultationId() {
        return record.getConsultationId();
    }

    @Override
    public void setConsultationId(UUID consultationId) {
        record.setConsultationId(consultationId);
    }

    @Override
    public String getConsultationSubject() {
        return record.getConsultationSubject();
    }

    @Override
    public void setConsultationSubject(String consultationSubject) {
        record.setConsultationSubject(consultationSubject);
    }

    @Override
    public String getConsultationDescription() {
        return record.getConsultationDescription();
    }

    @Override
    public void setConsultationDescription(String consultationDescription) {
        record.setConsultationDescription(consultationDescription);
    }

    @Override
    public boolean getConsultationStatus() {
        return record.getConsultationStatus();
    }

    @Override
    public void setConsultationStatus(boolean consultationStatus) {
        record.setConsultationStatus(consultationStatus);
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = super.toHashMap();
        List<HashMap<String, Object>> messagesList = new ArrayList<>();
        
        for (ChatMessage message : listChatMessages) {
            messagesList.add(message.toHashMap());
        }
        
        map.put("chatMessages", messagesList);
        return map;
    }
}