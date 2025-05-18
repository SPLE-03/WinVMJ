package healthcare.information.doctorinformation;
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
    @Route(url="call/doctorinformation/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		InformationDoctorInformation informationdoctorinformation = createInformationDoctorInformation(vmjExchange);
		informationdoctorinformationRepository.saveObject(informationdoctorinformation);
		return getAllInformationDoctorInformation(vmjExchange);
	}

    public Information createInformationDoctorInformation(VMJExchange vmjExchange){
		String specialist = (String) vmjExchange.getRequestBodyForm("specialist");
		
		InformationDoctorInformation informationdoctorinformation = record.createInformationDoctorInformation(vmjExchange);
		InformationDoctorInformation informationdoctorinformationdeco = InformationDoctorInformationFactory.createInformationDoctorInformation("healthcare.doctorinformation.core.InformationImpl", informationdoctorinformation, informationId, informationTitle, informationDescription
		specialist
		);
			return informationdoctorinformationdeco;
	}


    public Information createInformationDoctorInformation(VMJExchange vmjExchange, int id){
		String specialist = (String) vmjExchange.getRequestBodyForm("specialist");
		InformationDoctorInformation informationdoctorinformation = informationdoctorinformationRepository.getObject(id);
		int recordInformationDoctorInformationId = (((InformationDoctorInformationDecorator) savedInformationDoctorInformation.getRecord()).getId();
		
		InformationDoctorInformation informationdoctorinformation = record.createInformationDoctorInformation(vmjExchange);
		InformationDoctorInformation informationdoctorinformationdeco = InformationDoctorInformationFactory.createInformationDoctorInformation("healthcare.doctorinformation.core.InformationImpl", id, informationdoctorinformation, informationId, informationTitle, informationDescription
		specialist
		);
			return informationdoctorinformationdeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/update")
    public HashMap<String, Object> updateInformationDoctorInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		int id = Integer.parseInt(idStr);
		
		InformationDoctorInformation informationdoctorinformation = informationdoctorinformationRepository.getObject(id);
		informationdoctorinformation = createInformationDoctorInformation(vmjExchange, id);
		
		informationdoctorinformationRepository.updateObject(informationdoctorinformation);
		informationdoctorinformation = informationdoctorinformationRepository.getObject(id);
		//to do: fix association attributes
		
		return informationdoctorinformation.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/detail")
    public HashMap<String, Object> getInformationDoctorInformation(VMJExchange vmjExchange){
		return record.getInformationDoctorInformation(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/list")
    public List<HashMap<String,Object>> getAllInformationDoctorInformation(VMJExchange vmjExchange){
		List<InformationDoctorInformation> informationdoctorinformationList = informationdoctorinformationRepository.getAllObject("informationdoctorinformation_impl");
		return transformInformationDoctorInformationListToHashMap(informationdoctorinformationList);
	}

    public List<HashMap<String,Object>> transformInformationDoctorInformationListToHashMap(List<InformationDoctorInformation> InformationDoctorInformationList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < InformationDoctorInformationList.size(); i++) {
            resultList.add(InformationDoctorInformationList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/delete")
    public List<HashMap<String,Object>> deleteInformationDoctorInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		int id = Integer.parseInt(idStr);
		informationdoctorinformationRepository.deleteObject(id);
		return getAllInformationDoctorInformation(vmjExchange);
	}

	
}
