package healthcare.sercore.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class UserDecorator extends UserComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected UserComponent record;

	public UserDecorator () {
		super();
		this.record = record;
		this. =  .randomUUID();
		
	public UserDecorator (UserComponent record) {
		this. =  .randomUUID();
		this.record = record;
	}

	public UserDecorator (, UserComponent record) {
		this. =  ;
		this.record = record;
	}
	
	public UserDecorator (UserComponent record, String objectName) {
		this. =  .randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public UserDecorator() { }



	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
