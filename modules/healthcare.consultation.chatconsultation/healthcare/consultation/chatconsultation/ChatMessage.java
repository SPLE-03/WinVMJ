package healthcare.consultation.chatconsultation;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

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
    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public UUID getSenderId() {
        return senderId;
    }
    
    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }
    
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("messageContent", messageContent);
        map.put("timestamp", timestamp);
        map.put("senderId", senderId);
        return map;
    }
}