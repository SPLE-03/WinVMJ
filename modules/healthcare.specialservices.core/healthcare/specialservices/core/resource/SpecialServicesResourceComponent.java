package healthcare.specialservices.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SpecialServicesResourceComponent implements SpecialServicesResource{
	
	public SpecialServicesResourceComponent() { }
 
    public abstract SpecialServices createSpecialServices(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateSpecialServices(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getSpecialServices(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllSpecialServices(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteSpecialServices(VMJExchange vmjExchange);

	public abstract int calculatePrice();

	public abstract boolean isAvailable();

	public abstract boolean callService(UUID id);

	public abstract String getDetails(UUID id);

	public abstract boolean cancelService(UUID id);
}
