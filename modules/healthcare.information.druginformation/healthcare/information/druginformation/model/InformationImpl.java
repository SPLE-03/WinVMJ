package healthcare.information.druginformation;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.information.core.InformationDecorator;
import healthcare.information.core.Information;
import healthcare.information.core.InformationComponent;

@Entity(name="information_druginformation")
@Table(name="information_druginformation")
public class InformationImpl extends InformationDecorator {

	@Column(name="dosage", columnDefinition="TEXT")
	public String dosage;

	public InformationImpl(){
        super();
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(String dosage) {
    	super();
		this.dosage = dosage;
		this.objectName = InformationImpl.class.getName();
    }
	
	public InformationImpl(InformationComponent record, String dosage) {
		super(record);
		this.dosage = dosage;
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

    public String getDosage() {
        return this.dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("dosage", dosage);
        return map;
    }

}
