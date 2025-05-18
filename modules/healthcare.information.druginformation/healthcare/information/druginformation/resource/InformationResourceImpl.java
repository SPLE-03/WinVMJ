package healthcare.information.druginformation;
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
    @Route(url="call/druginformation/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		InformationDrugInformation informationdruginformation = createInformationDrugInformation(vmjExchange);
		informationdruginformationRepository.saveObject(informationdruginformation);
		return getAllInformationDrugInformation(vmjExchange);
	}

    public Information createInformationDrugInformation(VMJExchange vmjExchange){
		String dosage = (String) vmjExchange.getRequestBodyForm("dosage");
		
		InformationDrugInformation informationdruginformation = record.createInformationDrugInformation(vmjExchange);
		InformationDrugInformation informationdruginformationdeco = InformationDrugInformationFactory.createInformationDrugInformation("healthcare.druginformation.core.InformationImpl", informationdruginformation, informationId, informationTitle, informationDescription
		dosage
		);
			return informationdruginformationdeco;
	}


    public Information createInformationDrugInformation(VMJExchange vmjExchange, int id){
		String dosage = (String) vmjExchange.getRequestBodyForm("dosage");
		InformationDrugInformation informationdruginformation = informationdruginformationRepository.getObject(id);
		int recordInformationDrugInformationId = (((InformationDrugInformationDecorator) savedInformationDrugInformation.getRecord()).getId();
		
		InformationDrugInformation informationdruginformation = record.createInformationDrugInformation(vmjExchange);
		InformationDrugInformation informationdruginformationdeco = InformationDrugInformationFactory.createInformationDrugInformation("healthcare.druginformation.core.InformationImpl", id, informationdruginformation, informationId, informationTitle, informationDescription
		dosage
		);
			return informationdruginformationdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/update")
    public HashMap<String, Object> updateInformationDrugInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		int id = Integer.parseInt(idStr);
		
		InformationDrugInformation informationdruginformation = informationdruginformationRepository.getObject(id);
		informationdruginformation = createInformationDrugInformation(vmjExchange, id);
		
		informationdruginformationRepository.updateObject(informationdruginformation);
		informationdruginformation = informationdruginformationRepository.getObject(id);
		//to do: fix association attributes
		
		return informationdruginformation.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/detail")
    public HashMap<String, Object> getInformationDrugInformation(VMJExchange vmjExchange){
		return record.getInformationDrugInformation(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/druginformation/list")
    public List<HashMap<String,Object>> getAllInformationDrugInformation(VMJExchange vmjExchange){
		List<InformationDrugInformation> informationdruginformationList = informationdruginformationRepository.getAllObject("informationdruginformation_impl");
		return transformInformationDrugInformationListToHashMap(informationdruginformationList);
	}

    public List<HashMap<String,Object>> transformInformationDrugInformationListToHashMap(List<InformationDrugInformation> InformationDrugInformationList){
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
		
		String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		int id = Integer.parseInt(idStr);
		informationdruginformationRepository.deleteObject(id);
		return getAllInformationDrugInformation(vmjExchange);
	}

	
}
