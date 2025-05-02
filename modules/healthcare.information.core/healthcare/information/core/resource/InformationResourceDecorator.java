package healthcare.information.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class InformationResourceDecorator extends InformationResourceComponent{
	protected InformationResourceComponent record;

    public InformationResourceDecorator(InformationResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveInformation(VMJExchange vmjExchange){
		return record.saveInformation(vmjExchange);
	}

    public Information createInformation(VMJExchange vmjExchange){
		return record.createInformation(vmjExchange);
	}

    public Information createInformation(VMJExchange vmjExchange, int id){
		return record.createInformation(vmjExchange, id);
	}

    public HashMap<String, Object> updateInformation(VMJExchange vmjExchange){
		return record.updateInformation(vmjExchange);
	}

    public HashMap<String, Object> getInformation(VMJExchange vmjExchange){
		return record.getInformation(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllInformation(VMJExchange vmjExchange){
		return record.getAllInformation(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteInformation(VMJExchange vmjExchange){
		return record.deleteInformation(vmjExchange);
	}

}
