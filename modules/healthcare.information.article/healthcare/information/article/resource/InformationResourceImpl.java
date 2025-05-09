package healthcare.information.article;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationResourceDecorator;
import healthcare.information.core.InformationImpl;
import healthcare.information.core.InformationResourceComponent;

public class InformationResourceImpl extends InformationResourceDecorator {
    public InformationResourceImpl (InformationResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/article/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		  = create(vmjExchange);
		Repository.saveObject();
		return getAll(vmjExchange);
	}

    public Information create(VMJExchange vmjExchange){
		String content = (String) vmjExchange.getRequestBodyForm("content");
		
		  = record.create(vmjExchange);
		 deco = Factory.create("healthcare.article.core.InformationImpl", , content);
			return deco;
	}

    public Information create(VMJExchange vmjExchange, int id){
		String content = (String) vmjExchange.getRequestBodyForm("content");
		  = Repository.getObject(id);
		int recordId = (((Decorator) saved.getRecord()).getId();
		
		  = record.create(vmjExchange);
		 deco = Factory.create("healthcare.article.core.InformationImpl", id, , content);
			return deco;
	}

    // @Restriced(permission = "")
    @Route(url="call/article/update")
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
    @Route(url="call/article/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
		return record.getInformation(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/article/list")
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
    @Route(url="call/article/delete")
    public List<HashMap<String,Object>> deleteInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAll(vmjExchange);
	}

}
