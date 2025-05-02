package healthcare.specialservices.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class SpecialServicesServiceDecorator extends SpecialServicesServiceComponent{
	protected SpecialServicesServiceComponent record;

    public SpecialServicesServiceDecorator(SpecialServicesServiceComponent record) {
        this.record = record;
    }

	public SpecialServicesImpl createSpecialServices(Map<String, Object> requestBody){
		return record.createSpecialServices(requestBody);
	}

    public SpecialServices createSpecialServices(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createSpecialServices(requestBody, response);
	}

	public HashMap<String, Object> getSpecialServices(Map<String, Object> requestBody){
		return record.getSpecialServices(requestBody);
	}

	public List<HashMap<String,Object>> getAllSpecialServices(Map<String, Object> requestBody){
		return record.getAllSpecialServices(requestBody);
	}

    public List<HashMap<String,Object>> saveSpecialServices(VMJExchange vmjExchange){
		return record.saveSpecialServices(vmjExchange);
	}

    public HashMap<String, Object> updateSpecialServices(Map<String, Object> requestBody){
		return record.updateSpecialServices(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<SpecialServices> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteSpecialServices(Map<String, Object> requestBody){
		return record.deleteSpecialServices(requestBody);
	}

	public HashMap<String, Object> getSpecialServicesById(int id){
        return record.getSpecialServicesById(id);
    }

	public int calculatePrice() {
		return record.calculatePrice();
	}

	public boolean isAvailable() {
		return record.isAvailable();
	}

	public boolean callService(UUID id) {
		return record.callService(id);
	}

	public String getDetails(UUID id) {
		return record.getDetails(id);
	}

	public boolean cancelService(UUID id) {
		return record.cancelService(id);
	}
}
