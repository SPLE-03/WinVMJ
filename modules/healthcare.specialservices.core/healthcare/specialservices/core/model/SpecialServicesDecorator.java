package healthcare.specialservices.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class SpecialServicesDecorator extends SpecialServicesComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected SpecialServicesComponent record;

	public SpecialServicesDecorator () {
		super();
		this.record = record;
		this.specialServicesId =  specialServicesId.randomUUID();
		
	public SpecialServicesDecorator (SpecialServicesComponent record) {
		this.specialServicesId =  specialServicesId.randomUUID();
		this.record = record;
	}

	public SpecialServicesDecorator (UUID specialServicesId, SpecialServicesComponent record) {
		this.specialServicesId =  specialServicesId;
		this.record = record;
	}
	
	public SpecialServicesDecorator (SpecialServicesComponent record, String objectName) {
		this.specialServicesId =  specialServicesId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public SpecialServicesDecorator() { }


	public int calculatePrice() {
		return record.calculatePrice();
	}

	public boolean isAvailable() {
		return record.isAvailable();
	}

	public boolean callService(UUID id) {
		return record.callService(id);
	}

	public String getDetails(UUID id) {
		return record.getDetails(id);
	}

	public boolean cancelService(UUID id) {
		return record.cancelService(id);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
