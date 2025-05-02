package healthcare.information.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Information {
	public UUID getInformationId();
	public void setInformationId(UUID informationId);
	public String getInformationTitle();
	public void setInformationTitle(String informationTitle);
	public String getInformationDescription();
	public void setInformationDescription(String informationDescription);
	HashMap<String, Object> toHashMap();
}
