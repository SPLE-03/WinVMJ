package healthcare.information.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class InformationServiceDecorator extends InformationServiceComponent{
	protected InformationServiceComponent record;

    public InformationServiceDecorator(InformationServiceComponent record) {
        this.record = record;
    }

	public InformationImpl createInformation(Map<String, Object> requestBody){
		return (InformationImpl) record.createInformation(requestBody);
	}

    public Information createInformation(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createInformation(requestBody, response);
	}

	public List<HashMap<String,Object>> getAllInformation(Map<String, Object> requestBody){
		return record.getAllInformation(requestBody);
	}

    public List<HashMap<String,Object>> saveInformation(VMJExchange vmjExchange){
		return record.saveInformation(vmjExchange);
	}

    public HashMap<String, Object> updateInformation(Map<String, Object> requestBody){
		return record.updateInformation(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Information> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteInformation(Map<String, Object> requestBody){
		return record.deleteInformation(requestBody);
	}

	public HashMap<String, Object> getInformationById(int id){
        return record.getInformationById(id);
    }

}
