package healthcare.information.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class InformationDecorator extends InformationComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected InformationComponent record;

	public InformationDecorator () {
		super();
		this.record = record;
		this.informationId =  informationId.randomUUID();
	}
		
	public InformationDecorator (InformationComponent record) {
		this.informationId =  informationId.randomUUID();
		this.record = record;
	}

	public InformationDecorator (UUID informationId, InformationComponent record) {
		this.informationId =  informationId;
		this.record = record;
	}
	
	public InformationDecorator (InformationComponent record, String objectName) {
		this.informationId =  informationId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
