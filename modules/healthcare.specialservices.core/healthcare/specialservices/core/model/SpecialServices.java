package healthcare.specialservices.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface SpecialServices {
	public UUID getSpecialServicesId();
	public void setSpecialServicesId(UUID specialServicesId);
	public int getPrice();
	public void setPrice(int price);
	public int getDistance();
	public void setDistance(int distance);
	public boolean getAvailable();
	public void setAvailable(boolean available);
	public String getDetails();
	public void setDetails(String details);
	public UUID getSpecialServicesUser();
	public void setSpecialServicesUser(UUID specialServicesUser);
	public boolean callService(UUID id);
	public boolean isAvailable();
	public boolean cancelService(UUID id);
	public String getDetails(UUID id);
	public int calculatePrice();
	HashMap<String, Object> toHashMap();
}
