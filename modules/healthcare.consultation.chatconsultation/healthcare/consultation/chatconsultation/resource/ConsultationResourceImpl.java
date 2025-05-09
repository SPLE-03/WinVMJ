package healthcare.consultation.chatconsultation;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import healthcare.consultation.core.ConsultationResourceDecorator;
import healthcare.consultation.core.ConsultationImpl;
import healthcare.consultation.core.ConsultationResourceComponent;

public class ConsultationResourceImpl extends ConsultationResourceDecorator {
    public ConsultationResourceImpl (ConsultationResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Consultation create(VMJExchange vmjExchange){
		
		  = record.create(vmjExchange);
		 deco = Factory.create("healthcare.chatconsultation.core.ConsultationImpl", , ListChatMessages);
			return deco;
	}

    public Consultation create(VMJExchange vmjExchange, int id){
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("healthcare.chatconsultation.core.ConsultationImpl", id, , ListChatMessages);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/chatconsultation/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		  = Repository.getObject(id);
		 = create(vmjExchange, id);
		
		Repository.updateObject();
		 = Repository.getObject(id);
		//to do: fix association attributes
		
		return .toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/chatconsultation/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getConsultation(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/chatconsultation/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
		List<> List = Repository.getAllObject("_impl");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/chatconsultation/delete")
    public List<HashMap<String,Object>> deleteConsultation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
