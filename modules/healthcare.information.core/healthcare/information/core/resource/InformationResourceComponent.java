package healthcare.information.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class InformationResourceComponent implements InformationResource{
	
	public InformationResourceComponent() { }
 
    public abstract HashMap<String, Object> createInformation(VMJExchange vmjExhange);    
	public abstract HashMap<String, Object> updateInformation(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getInformation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllInformation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteInformation(VMJExchange vmjExchange);

}
