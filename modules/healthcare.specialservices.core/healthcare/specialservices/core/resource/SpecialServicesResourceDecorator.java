package healthcare.specialservices.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class SpecialServicesResourceDecorator extends SpecialServicesResourceComponent{
	protected SpecialServicesResourceComponent record;

    public SpecialServicesResourceDecorator(SpecialServicesResourceComponent record) {
        this.record = record;
    }

    public SpecialServices createSpecialServices(VMJExchange vmjExchange){
		return record.createSpecialServices(vmjExchange);
	}

    public HashMap<String, Object> updateSpecialServices(VMJExchange vmjExchange){
		return record.updateSpecialServices(vmjExchange);
	}

    public HashMap<String, Object> getSpecialServices(VMJExchange vmjExchange){
		return record.getSpecialServices(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllSpecialServices(VMJExchange vmjExchange){
		return record.getAllSpecialServices(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteSpecialServices(VMJExchange vmjExchange){
		return record.deleteSpecialServices(vmjExchange);
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
