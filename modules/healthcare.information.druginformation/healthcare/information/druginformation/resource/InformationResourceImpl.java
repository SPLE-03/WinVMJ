package healthcare.information.druginformation;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationResourceDecorator;
import healthcare.information.core.InformationImpl;
import healthcare.information.core.Information;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.core.InformationResourceComponent;

public class InformationResourceImpl extends InformationResourceDecorator {
	private InformationServiceImpl informationServiceImpl;

	public InformationResourceImpl(InformationResourceComponent record, InformationServiceComponent informationServiceImpl) {
		super(record);
		this.informationServiceImpl = new InformationServiceImpl(informationServiceImpl);
	}

    // @Restriced(permission = "")
    // @Route(url="call/druginformation/save")
    // public HashMap<String, Object> save(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	Information informationdruginformation = createInformationDrugInformation(vmjExchange);
	// 	Repository.saveObject(informationdruginformation);
	// 	return getAllInformationDrugInformation(vmjExchange);
	// }

	@Route(url="call/druginformation/save")
    public HashMap<String, Object> createInformationDrugInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }

		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		Information information = informationServiceImpl.createDrugInformation(requestBody);
		return information.toHashMap();
	}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/update")
    public HashMap<String, Object> updateInformationDrugInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
		Information information = informationServiceImpl.updateDrugInformation(requestBody);
		return information.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/detail")
    public HashMap<String, Object> getInformationDrugInformation(VMJExchange vmjExchange){
		String id = (String) vmjExchange.getGETParam("id");
		Information information = informationServiceImpl.getDrugInformation(UUID.fromString(id));
		return information.toHashMap();
}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/list")
    public List<HashMap<String,Object>> getAllInformationDrugInformation(VMJExchange vmjExchange){
		List<Information> information = informationServiceImpl.getAllDrugInformation();
        return transformListToHashMap(information);
	}

    public List<HashMap<String,Object>> transformInformationDrugInformationListToHashMap(List<InformationImpl> InformationDrugInformationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < InformationDrugInformationList.size(); i++) {
            resultList.add(InformationDrugInformationList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/delete")
    public List<HashMap<String,Object>> deleteInformationDrugInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		UUID id = UUID.fromString((String) vmjExchange.getRequestBodyForm("id"));
        List<Information> information = informationServiceImpl.deleteDrugInformation(id);
        return transformListToHashMap(information);
	}

	public List<HashMap<String,Object>> transformListToHashMap(List<Information> list){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }
        return resultList;
    }
}
