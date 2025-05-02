package healthcare.specialservices.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="specialservices_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SpecialServicesComponent implements SpecialServices{
	@Id
	public UUID specialServicesId; 
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  specialServicesId;
	public int price;
	public int distance;
	public boolean available;
	public String details;
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  specialServicesUser;
	protected String objectName = SpecialServicesComponent.class.getName();

	public SpecialServicesComponent() {

	} 

	public SpecialServicesComponent(
        UUID specialServicesId, int price, int distance, boolean available, String details, UUID specialServicesUser
    ) {
        this.specialServicesId = specialServicesId;
        this.price = price;
        this.distance = distance;
        this.available = available;
        this.details = details;
        this.specialServicesUser = specialServicesUser;
    }

	public abstract UUID getSpecialServicesId();
	public abstract void setSpecialServicesId(UUID specialServicesId);
	
	public abstract int getPrice();
	public abstract void setPrice(int price);
	
	public abstract int getDistance();
	public abstract void setDistance(int distance);
	
	public abstract boolean getAvailable();
	public abstract void setAvailable(boolean available);
	
	public abstract String getDetails();
	public abstract void setDetails(String details);
	
	public abstract UUID getSpecialServicesUser();
	public abstract void setSpecialServicesUser(UUID specialServicesUser);
	
 
	public abstract int calculatePrice();

	public abstract boolean isAvailable();

	public abstract boolean callService(UUID id);

	public abstract String getDetails(UUID id);

	public abstract boolean cancelService(UUID id);

	@Override
    public String toString() {
        return "{" +
            " specialServicesId='" + getSpecialServicesId() + "'" +
            " price='" + getPrice() + "'" +
            " distance='" + getDistance() + "'" +
            " available='" + getAvailable() + "'" +
            " details='" + getDetails() + "'" +
            " specialServicesUser='" + getSpecialServicesUser() + "'" +
            "}";
    }
	
}
