package healthcare.consultation.chatconsultation;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="chat_message")
public class ChatMessage {
    @Id
    private UUID id;
    
    @Column(name="message_content")
    private String messageContent;
    
    @Column(name="timestamp")
    private Date timestamp;
    
    @Column(name="sender_id")
    private UUID senderId;
    
    @Column(name="consultation_id", insertable = false, updatable = false)
    private UUID consultationId;
    
    // Constructors
    public ChatMessage() {
        this.id = UUID.randomUUID();
        this.timestamp = new Date();
    }
    
    public ChatMessage(String messageContent, UUID senderId) {
        this.id = UUID.randomUUID();
        this.messageContent = messageContent;
        this.timestamp = new Date();
        this.senderId = senderId;
    }
    
    // Getters and Setters
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getMessageContent() {
        return messageContent;
    }
    
    // ... other getters and setters
    
    public UUID getConsultationId() {
        return consultationId;
    }
    
    public void setConsultationId(UUID consultationId) {
        this.consultationId = consultationId;
    }
    
    // Other methods
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("messageContent", messageContent);
        map.put("timestamp", timestamp);
        map.put("senderId", senderId);
        map.put("consultationId", consultationId);
        return map;
    }
}