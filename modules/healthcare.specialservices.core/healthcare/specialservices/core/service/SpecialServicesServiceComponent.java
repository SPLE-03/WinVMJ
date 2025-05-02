package healthcare.specialservices.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class SpecialServicesServiceComponent implements SpecialServicesService{
	protected RepositoryUtil<SpecialServices> Repository;

    public SpecialServicesServiceComponent(){
        this.Repository = new RepositoryUtil<SpecialServices>(healthcare.specialservices.core.SpecialServicesComponent.class);
    }	

    public abstract SpecialServices createSpecialServices(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getSpecialServices(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> saveSpecialServices(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> updateSpecialServices(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getSpecialServicesById(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllSpecialServices(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> deleteSpecialServices(Map<String, Object> requestBody);
	public abstract List<HashMap<String, Object>> transformListToHashMap(List<SpecialServices> List);

	public abstract int calculatePrice();

	public abstract boolean isAvailable();

	public abstract boolean callService(UUID id);

	public abstract String getDetails(UUID id);

	public abstract boolean cancelService(UUID id);
}
