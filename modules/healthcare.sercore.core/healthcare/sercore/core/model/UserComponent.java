package healthcare.sercore.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="user_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserComponent implements User{
	@Id
	
	protected String objectName = UserComponent.class.getName();

	public UserComponent() {

	} 

	public UserComponent(
        
    ) {
    }

 

	@Override
    public String toString() {
        return "{" +
            "}";
    }
	
}
