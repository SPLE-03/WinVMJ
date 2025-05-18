package healthcare.information.vaccineinfo;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.information.core.InformationDecorator;
import healthcare.information.core.Information;
import healthcare.information.core.InformationComponent;

@Entity(name="information_vaccineinfo")
@Table(name="information_vaccineinfo")
public class InformationImpl extends InformationDecorator {

	@Column(name="vaccinationLocation", columnDefinition="TEXT")
	public String vaccinationLocation;

	@Column(name="type", columnDefinition="TEXT")
	public String type;

	@Column(name="schedule", columnDefinition="TEXT")
	public String schedule;

	public InformationImpl() {
        super();
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(String vaccinationLocation, String type, String schedule) {
    	super();
		this.vaccinationLocation = vaccinationLocation;
		this.type = type;
		this.schedule = schedule;
		this.objectName = InformationImpl.class.getName();
    }
	
	public InformationImpl(InformationComponent record, String vaccinationLocation, String type, String schedule) {
		super(record);
		this.vaccinationLocation = vaccinationLocation;
		this.type = type;
		this.schedule = schedule;
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

    public String getVaccinationLocation() {
        return this.vaccinationLocation;
    }

    public void setVaccinationLocation(String vaccinationLocation) {
        this.vaccinationLocation = vaccinationLocation;
    }
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getSchedule() {
        return this.schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    // @Override
    // public HashMap<String, Object> toHashMap() {
    //     HashMap<String, Object> map = record.toHashMap();
    //     map.put("content", content);
    //     return map;
    // }
}
