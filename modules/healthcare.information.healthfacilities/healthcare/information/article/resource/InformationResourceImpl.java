package healthcare.information.healthfacilities;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.hibernate.integrator.RepositoryUtil;

import healthcare.information.core.InformationResourceDecorator;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.core.InformationImpl;
import healthcare.information.core.InformationComponent;
import healthcare.information.core.Information;
import healthcare.information.core.InformationResourceComponent;
import healthcare.information.InformationFactory;
import vmj.routing.route.exceptions.*;

public class InformationResourceImpl extends InformationResourceDecorator {
    private InformationServiceImpl informationServiceImpl;

    public InformationResourceImpl(InformationResourceComponent record, InformationServiceComponent informationServiceImpl) {
        super(record);
        this.informationServiceImpl = new InformationServiceImpl(informationServiceImpl);
    }

    // @Restriced(permission = "")
    @Route(url="call/healthfacilities/save")
    public HashMap<String,Object> createHealthFacilities(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.saveHealthFacilities(requestBody);
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/healthfacilities/update")
    public HashMap<String, Object> updateHealthFacilities(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.updateHealthFacilities(requestBody);
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/healthfacilities/detail")
    public HashMap<String, Object> getHealthFacilities(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("GET")) {
            String id = (String) vmjExchange.getGETParam("id");
            Information information = informationServiceImpl.getHealthFacilities(UUID.fromString(id));
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/healthfacilities/list")
    public List<HashMap<String, Object>> getAllHealthFacilities(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("GET")) {
            List<Information> information = informationServiceImpl.getAllHealthFacilities();
            return transformListToHashMap(information);
        }
        throw new NotFoundException("Route tidak ditemukan");
    }
    
    // @Restriced(permission = "")
    @Route(url="call/healthfacilities/delete")
    public List<HashMap<String, Object>> deleteHealthFacilities(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        UUID id = UUID.fromString((String) vmjExchange.getRequestBodyForm("id"));
        List<Information> information = informationServiceImpl.deleteHealthFacilities(id);
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