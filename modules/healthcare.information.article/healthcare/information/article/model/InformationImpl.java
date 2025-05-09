package healthcare.information.article;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.information.core.InformationDecorator;
import healthcare.information.core.Information;
import healthcare.information.core.InformationComponent;

@Entity(name="information_article")
@Table(name="information_article")
public class InformationImpl extends InformationDecorator {

    @Column(name="content", columnDefinition="TEXT")
    public String content;
    
    public InformationImpl() {
        super();
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(String content) {
        super();
        this.content = content;
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(InformationComponent record, String content) {
        super(record);
        this.content = content;
        this.objectName = InformationImpl.class.getName();
    }
    
    @Override
    public UUID getInformationId() {
        return record.getInformationId();
    }

    @Override
    public void setInformationId(UUID informationId) {
        record.setInformationId(informationId);
    }

    @Override
    public String getInformationTitle() {
        return record.getInformationTitle();
    }

    @Override
    public void setInformationTitle(String informationTitle) {
        record.setInformationTitle(informationTitle);
    }

    @Override
    public String getInformationDescription() {
        return record.getInformationDescription();
    }

    @Override
    public void setInformationDescription(String informationDescription) {
        record.setInformationDescription(informationDescription);
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("content", content);
        return map;
    }
}