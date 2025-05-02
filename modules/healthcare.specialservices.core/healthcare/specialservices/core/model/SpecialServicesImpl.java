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
		this.specialServicesId =  specialServicesId.randomUUID();
		this.price = price;
		this.distance = distance;
		this.available = available;
		this.details = details;
		this.specialServicesUser = specialServicesUser;
	}

	public SpecialServicesImpl() { }


	public int calculatePrice() {
		// TODO: implement this method
		return 0;
	}

	public boolean isAvailable() {
		// TODO: implement this method
		return false;
	}

	public boolean callService(UUID id) {
		// TODO: implement this method
		return false;
	}

	public String getDetails(UUID id) {
		// TODO: implement this method
		return "";
	}

	public boolean cancelService(UUID id) {
		// TODO: implement this method
		return false;
	}

	public void setSpecialServicesUser(UUID specialServicesUser) {
		this.specialServicesUser = specialServicesUser;
	}

	public UUID getSpecialServicesUser() {
		return this.specialServicesUser;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return this.details;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean getAvailable() {
		return this.available;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}

	public void setSpecialServicesId(UUID specialServicesId) {
		this.specialServicesId = specialServicesId;
	}

	public UUID getSpecialServicesId() {
		return this.specialServicesId;
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
