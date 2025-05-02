package healthcare.information.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InformationServiceComponent implements InformationService{
	protected RepositoryUtil<Information> Repository;

    public InformationServiceComponent(){
        this.Repository = new RepositoryUtil<Information>(healthcare.information.core.InformationComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveInformation(VMJExchange vmjExchange);
    public abstract Information createInformation(Map<String, Object> requestBodye);
	public abstract Information createInformation(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateInformation(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getInformation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllInformation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Information> List);
    public abstract List<HashMap<String,Object>> deleteInformation(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getInformationById(int id);

}
