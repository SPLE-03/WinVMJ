package healthcare.information.healthfacilities;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.information.core.InformationDecorator;
import healthcare.information.core.Information;
import healthcare.information.core.InformationComponent;

@Entity(name="information_healthfacilities")
@Table(name="information_healthfacilities")
public class InformationImpl extends InformationDecorator {

    @Column(name="location", columnDefinition="TEXT")
    public String location;
    
    public InformationImpl() {
        super();
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(String location) {
        super();
        this.location = location;
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(InformationComponent record, String location) {
        super(record);
        this.location = location;
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

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("location", location);
        return map;
    }
}