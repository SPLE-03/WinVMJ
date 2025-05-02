package healthcare.specialservices.core;

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


@Entity(name="specialservices_impl")
@Table(name="specialservices_impl")
public class SpecialServicesImpl extends SpecialServicesComponent {

	public SpecialServicesImpl(UUID specialServicesId, int price, int distance, boolean available, String details, UUID specialServicesUser) {
		this.specialServicesId = specialServicesId;
		this.price = price;
		this.distance = distance;
		this.available = available;
		this.details = details;
		this.specialServicesUser = specialServicesUser;
	}

	public SpecialServicesImpl(UUID specialServicesId, int price, int distance, boolean available, String details, UUID specialServicesUser) {
		this.specialServicesId =  specialServicesId.randomUUID();;
		this.specialServicesId = specialServicesId;
		this.price = price;
		this.distance = distance;
		this.available = available;
		this.details = details;
		this.specialServicesUser = specialServicesUser;
	}

	public SpecialServicesImpl() { }


	public int calculatePrice() {
		// TODO: implement this method
	}

	public boolean isAvailable() {
		// TODO: implement this method
	}

	public boolean callService(UUID id) {
		// TODO: implement this method
	}

	public String getDetails(UUID id) {
		// TODO: implement this method
	}

	public boolean cancelService(UUID id) {
		// TODO: implement this method
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> specialservicesMap = new HashMap<String,Object>();
		specialservicesMap.put("specialServicesId",getSpecialServicesId());
		specialservicesMap.put("price",getPrice());
		specialservicesMap.put("distance",getDistance());
		specialservicesMap.put("available",getAvailable());
		specialservicesMap.put("details",getDetails());
		specialservicesMap.put("specialServicesUser",getSpecialServicesUser());

        return specialservicesMap;
    }

}
