package healthcare.information.article;
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
    @Route(url="call/article/save")
    public HashMap<String,Object> createArticle(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.saveArticle(requestBody);
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/article/update")
    public HashMap<String, Object> updateArticle(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("POST")) {
            HashMap<String, Object> requestBody = (HashMap<String, Object>) vmjExchange.getPayload();
            Information information = informationServiceImpl.updateArticle(requestBody);
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/article/detail")
    public HashMap<String, Object> getArticle(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("GET")) {
            String id = (String) vmjExchange.getGETParam("id");
            Information information = informationServiceImpl.getArticle(UUID.fromString(id));
            return information.toHashMap();
        }
        throw new NotFoundException("Route tidak ditemukan");
    }

    // @Restriced(permission = "")
    @Route(url="call/article/list")
    public List<HashMap<String, Object>> getAllArticle(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("GET")) {
            List<Information> information = informationServiceImpl.getAllArticle();
            return transformListToHashMap(information);
        }
        throw new NotFoundException("Route tidak ditemukan");
    }
    
    // @Restriced(permission = "")
    @Route(url="call/article/delete")
    public List<HashMap<String, Object>> deleteArticle(VMJExchange vmjExchange) {
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        UUID id = UUID.fromString((String) vmjExchange.getRequestBodyForm("id"));
        List<Information> information = informationServiceImpl.deleteArticle(id);
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