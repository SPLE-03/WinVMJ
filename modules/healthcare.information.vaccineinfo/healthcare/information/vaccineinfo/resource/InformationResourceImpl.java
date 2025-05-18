package healthcare.information.vaccineinfo;
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
    @Route(url="call/vaccineinfo/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		InformationVaccineInfo informationvaccineinfo = createInformationVaccineInfo(vmjExchange);
		informationvaccineinfoRepository.saveObject(informationvaccineinfo);
		return getAllInformationVaccineInfo(vmjExchange);
	}

    public Information createInformationVaccineInfo(VMJExchange vmjExchange){
		String vaccinationLocation = (String) vmjExchange.getRequestBodyForm("vaccinationLocation");
		String type = (String) vmjExchange.getRequestBodyForm("type");
		String schedule = (String) vmjExchange.getRequestBodyForm("schedule");
		
		InformationVaccineInfo informationvaccineinfo = record.createInformationVaccineInfo(vmjExchange);
		InformationVaccineInfo informationvaccineinfodeco = InformationVaccineInfoFactory.createInformationVaccineInfo("healthcare.vaccineinfo.core.InformationImpl", informationvaccineinfo, informationId, informationTitle, informationDescription
		vaccinationLocation, type, schedule
		);
			return informationvaccineinfodeco;
	}


    public Information createInformationVaccineInfo(VMJExchange vmjExchange, int id){
		String vaccinationLocation = (String) vmjExchange.getRequestBodyForm("vaccinationLocation");
		String type = (String) vmjExchange.getRequestBodyForm("type");
		String schedule = (String) vmjExchange.getRequestBodyForm("schedule");
		InformationVaccineInfo informationvaccineinfo = informationvaccineinfoRepository.getObject(id);
		int recordInformationVaccineInfoId = (((InformationVaccineInfoDecorator) savedInformationVaccineInfo.getRecord()).getId();
		
		InformationVaccineInfo informationvaccineinfo = record.createInformationVaccineInfo(vmjExchange);
		InformationVaccineInfo informationvaccineinfodeco = InformationVaccineInfoFactory.createInformationVaccineInfo("healthcare.vaccineinfo.core.InformationImpl", id, informationvaccineinfo, informationId, informationTitle, informationDescription
		vaccinationLocation, type, schedule
		);
			return informationvaccineinfodeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/update")
    public HashMap<String, Object> updateInformationVaccineInfo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		int id = Integer.parseInt(idStr);
		
		InformationVaccineInfo informationvaccineinfo = informationvaccineinfoRepository.getObject(id);
		informationvaccineinfo = createInformationVaccineInfo(vmjExchange, id);
		
		informationvaccineinfoRepository.updateObject(informationvaccineinfo);
		informationvaccineinfo = informationvaccineinfoRepository.getObject(id);
		//to do: fix association attributes
		
		return informationvaccineinfo.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/detail")
    public HashMap<String, Object> getInformationVaccineInfo(VMJExchange vmjExchange){
		return record.getInformationVaccineInfo(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/list")
    public List<HashMap<String,Object>> getAllInformationVaccineInfo(VMJExchange vmjExchange){
		List<InformationVaccineInfo> informationvaccineinfoList = informationvaccineinfoRepository.getAllObject("informationvaccineinfo_impl");
		return transformInformationVaccineInfoListToHashMap(informationvaccineinfoList);
	}

    public List<HashMap<String,Object>> transformInformationVaccineInfoListToHashMap(List<InformationVaccineInfo> InformationVaccineInfoList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < InformationVaccineInfoList.size(); i++) {
            resultList.add(InformationVaccineInfoList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/delete")
    public List<HashMap<String,Object>> deleteInformationVaccineInfo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		int id = Integer.parseInt(idStr);
		informationvaccineinfoRepository.deleteObject(id);
		return getAllInformationVaccineInfo(vmjExchange);
	}

	
}
