package healthcare.information.doctorinformation;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import healthcare.information.core.InformationResourceDecorator;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.core.InformationImpl;
import healthcare.information.core.InformationResourceComponent;
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
    @Route(url="call/doctorinformation/save")
    public HashMap<String,Object> createInformationDoctor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.saveDoctor(requestBody);
            return information.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    // public Information createInformationDoctorInformation(VMJExchange vmjExchange){
	// 	String specialist = (String) vmjExchange.getRequestBodyForm("specialist");
		
	// 	InformationDoctorInformation informationdoctorinformation = record.createInformationDoctorInformation(vmjExchange);
	// 	InformationDoctorInformation informationdoctorinformationdeco = InformationDoctorInformationFactory.createInformationDoctorInformation("healthcare.doctorinformation.core.InformationImpl", informationdoctorinformation, informationId, informationTitle, informationDescription, specialist);
	// 		return informationdoctorinformationdeco;
	// }


    // public Information createInformationDoctorInformation(VMJExchange vmjExchange, int id){
	// 	String specialist = (String) vmjExchange.getRequestBodyForm("specialist");
	// 	InformationDoctorInformation informationdoctorinformation = informationdoctorinformationRepository.getObject(id);
	// 	int recordInformationDoctorInformationId = (((InformationDoctorInformationDecorator) savedInformationDoctorInformation.getRecord()).getId());
		
	// 	InformationDoctorInformation informationdoctorinformation = record.createInformationDoctorInformation(vmjExchange);
	// 	InformationDoctorInformation informationdoctorinformationdeco = InformationDoctorInformationFactory.createInformationDoctorInformation("healthcare.doctorinformation.core.InformationImpl", id, informationdoctorinformation, informationId, informationTitle, informationDescription, specialist);
	// 		return informationdoctorinformationdeco;
	// }

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/update")
    public HashMap<String, Object> updateInformationDoctor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
			HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.updateDoctor(requestBody);
            return information.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/detail")
    public HashMap<String, Object> getInformationDoctor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			String id = (String) vmjExchange.getGETParam("id");
			Information information = informationServiceImpl.getDoctor(UUID.fromString(id));
			return information.toHashMap();
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/list")
    public List<HashMap<String,Object>> getAllDoctor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("GET")) {
			List<Information> information = informationServiceImpl.getAllDoctor();
			return transformListToHashMap(information);
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Information> list){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/doctorinformation/delete")
    public List<HashMap<String,Object>> deleteInformationDoctor(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		UUID id = UUID.fromString((String) vmjExchange.getRequestBodyForm("id"));
		List<Information> information = informationServiceImpl.deleteDoctor(id);
		return transformListToHashMap(information);
	}

	
}
