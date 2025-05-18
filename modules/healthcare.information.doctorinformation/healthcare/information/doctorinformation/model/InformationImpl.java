package healthcare.information.doctorinformation;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.information.core.InformationDecorator;
import healthcare.information.core.Information;
import healthcare.information.core.InformationComponent;

@Entity(name="information_doctorinformation")
@Table(name="information_doctorinformation")
public class InformationImpl extends InformationDecorator {

	public String specialist;
	public InformationImpl(
        super();
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(String specialist) {
    	super();
		this.specialist = specialist;
		this.objectName = InformationImpl.class.getName();
    }
	
	public InformationImpl(InformationComponent record, String specialist) {
		super(record);
		this.specialist = specialist;
		this.objectName = InformationImpl.class.getName();
	}



}
