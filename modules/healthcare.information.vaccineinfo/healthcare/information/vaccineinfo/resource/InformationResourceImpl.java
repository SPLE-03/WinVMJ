package healthcare.information.vaccineinfo;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import healthcare.information.core.InformationResourceDecorator;
import healthcare.information.core.InformationImpl;
import healthcare.information.core.InformationResourceComponent;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.core.InformationComponent;
import healthcare.information.core.Information;
import healthcare.information.InformationFactory;
import vmj.routing.route.exceptions.*;

public class InformationResourceImpl extends InformationResourceDecorator {
    private InformationServiceImpl informationServiceImpl;
	
	public InformationResourceImpl (InformationResourceComponent record, InformationServiceComponent informationServiceImpl) {
        super(record);
		this.informationServiceImpl = new InformationServiceImpl(informationServiceImpl);
    }

    // @Restriced(permission = "")
	@Route(url="call/vaccineinfo/save")
    public HashMap<String,Object> createVaccineInfo(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.saveVaccineInfo(requestBody);
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Route(url="call/vaccineinfo/save")
    // public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
	// 	if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
	// 		return null;
	// 	}
	// 	InformationVaccineInfo informationvaccineinfo = createInformationVaccineInfo(vmjExchange);
	// 	informationvaccineinfoRepository.saveObject(informationvaccineinfo);
	// 	return getAllInformationVaccineInfo(vmjExchange);
	// }

    // public Information createInformationVaccineInfo(VMJExchange vmjExchange){
	// 	String vaccinationLocation = (String) vmjExchange.getRequestBodyForm("vaccinationLocation");
	// 	String type = (String) vmjExchange.getRequestBodyForm("type");
	// 	String schedule = (String) vmjExchange.getRequestBodyForm("schedule");
		
	// 	InformationVaccineInfo informationvaccineinfo = record.createInformationVaccineInfo(vmjExchange);
	// 	InformationVaccineInfo informationvaccineinfodeco = InformationVaccineInfoFactory.createInformationVaccineInfo("healthcare.vaccineinfo.core.InformationImpl", informationvaccineinfo, informationId, informationTitle, informationDescription
	// 	vaccinationLocation, type, schedule
	// 	);
	// 		return informationvaccineinfodeco;
	// }


    // public Information createInformationVaccineInfo(VMJExchange vmjExchange, int id){
	// 	String vaccinationLocation = (String) vmjExchange.getRequestBodyForm("vaccinationLocation");
	// 	String type = (String) vmjExchange.getRequestBodyForm("type");
	// 	String schedule = (String) vmjExchange.getRequestBodyForm("schedule");
	// 	InformationVaccineInfo informationvaccineinfo = informationvaccineinfoRepository.getObject(id);
	// 	int recordInformationVaccineInfoId = (((InformationVaccineInfoDecorator) savedInformationVaccineInfo.getRecord()).getId();
		
	// 	InformationVaccineInfo informationvaccineinfo = record.createInformationVaccineInfo(vmjExchange);
	// 	InformationVaccineInfo informationvaccineinfodeco = InformationVaccineInfoFactory.createInformationVaccineInfo("healthcare.vaccineinfo.core.InformationImpl", id, informationvaccineinfo, informationId, informationTitle, informationDescription
	// 	vaccinationLocation, type, schedule
	// 	);
	// 		return informationvaccineinfodeco;
	// }

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/update")
    public HashMap<String, Object> updateVaccineInfo(VMJExchange vmjExchange){
		// if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
		// 	return null;
		// }
		// String idStr = (String) vmjExchange.getRequestBodyForm("informationId");
		// int id = Integer.parseInt(idStr);
		
		// InformationVaccineInfo informationvaccineinfo = informationvaccineinfoRepository.getObject(id);
		// informationvaccineinfo = createInformationVaccineInfo(vmjExchange, id);
		
		// informationvaccineinfoRepository.updateObject(informationvaccineinfo);
		// informationvaccineinfo = informationvaccineinfoRepository.getObject(id);
		// //to do: fix association attributes
		
		// return informationvaccineinfo.toHashMap();

		if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.updateVaccineInfo(requestBody);
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
		
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/detail")
    public HashMap<String, Object> getVaccineInfo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			String id = (String) vmjExchange.getGETParam("id");
			Information information = informationServiceImpl.getVaccineInfo(UUID.fromString(id));
			return information.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/list")
    public List<HashMap<String,Object>> getAllVaccineInfo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			List<Information> informationvaccineinfoList = informationServiceImpl.getAllVaccineInfo();
			return transformInformationVaccineInfoListToHashMap(informationvaccineinfoList);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public List<HashMap<String,Object>> transformInformationVaccineInfoListToHashMap(List<Information> InformationVaccineInfoList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < InformationVaccineInfoList.size(); i++) {
            resultList.add(InformationVaccineInfoList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/vaccineinfo/delete")
    public List<HashMap<String,Object>> deleteVaccineInfo(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		UUID id = UUID.fromString((String) vmjExchange.getRequestBodyForm("id"));
        List<Information> information = informationServiceImpl.deleteVaccineInfo(id);
		return getAllVaccineInfo(vmjExchange);
	}

	
}
