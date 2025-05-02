package healthcare.sercore.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="user_impl")
@Table(name="user_impl")
public class UserImpl extends UserComponent {

	public UserImpl() {
	}

	public UserImpl() {
		this. =  .randomUUID();;
	}

	public UserImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> userMap = new HashMap<String,Object>();

        return userMap;
    }

}
