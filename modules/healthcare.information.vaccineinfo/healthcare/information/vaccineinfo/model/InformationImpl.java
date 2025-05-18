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

	public String vaccinationLocation;
	public String type;
	public String schedule;
	public InformationImpl(
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



}
