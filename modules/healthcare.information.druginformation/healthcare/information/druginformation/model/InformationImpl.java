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

	public String dosage;
	public InformationImpl(
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



}
