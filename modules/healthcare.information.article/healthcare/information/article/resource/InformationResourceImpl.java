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

public class InformationResourceImpl extends InformationResourceDecorator {
    private InformationServiceImpl informationServiceImpl;

    public InformationResourceImpl(InformationResourceComponent record, InformationServiceComponent informationServiceImpl) {
        super(record);
        this.informationServiceImpl = new InformationServiceImpl(informationServiceImpl);
    }

    // @Restriced(permission = "")
    @Route(url="call/article/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        Information information = create(vmjExchange);
        // return informationServiceImpl.saveInformation(information);
        return null;
    }

    public Information create(VMJExchange vmjExchange){
        String content = (String) vmjExchange.getRequestBodyForm("content");
        
        // Get base information data via the parent implementation
        HashMap<String, Object> baseInformationData = record.createInformation(vmjExchange);
        
        // Extract information from the base data
        String informationTitle = (String) baseInformationData.get("informationTitle");
        String informationDescription = (String) baseInformationData.get("informationDescription");
        
        // Create the base component
        InformationComponent baseComponent = new healthcare.information.core.InformationImpl(
            UUID.randomUUID(),
            informationTitle,
            informationDescription
        );
        
        // Create the decorated information
        Information deco = InformationFactory.createInformation(
            "healthcare.information.article.InformationImpl", 
            baseComponent, 
            content
        );
        
        // return deco;
        return null;
    }

    public Information create(VMJExchange vmjExchange, int id){
        // String content = (String) vmjExchange.getRequestBodyForm("content");
        // Information saved = Repository.getObject(id);
        // InformationComponent baseRecord = (InformationComponent) saved;
        
        // // Get updated information data
        // HashMap<String, Object> baseInformationData = record.createInformation(vmjExchange);
        
        // // Extract information from the base data
        // String informationTitle = (String) baseInformationData.get("informationTitle");
        // String informationDescription = (String) baseInformationData.get("informationDescription");
        
        // // Create the base component with existing ID
        // InformationComponent baseComponent = new healthcare.information.core.InformationImpl(
        //     baseRecord.getInformationId(),
        //     informationTitle,
        //     informationDescription
        // );
        
        // // Create the decorated information
        // Information deco = InformationFactory.createInformation(
        //     "healthcare.information.article.InformationImpl", 
        //     baseComponent, 
        //     content
        // );
        
        // return deco;
        return null;
    }

    // @Restriced(permission = "")
    @Route(url="call/article/update")
    public HashMap<String, Object> update(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        // String idStr = (String) vmjExchange.getRequestBodyForm("id");
        // int id = Integer.parseInt(idStr);
        
        // Information information = Repository.getObject(id);
        // information = create(vmjExchange, id);
        
        // return informationServiceImpl.updateInformation(information);
        return null;
    }

    // @Restriced(permission = "")
    @Route(url="call/article/detail")
    public HashMap<String, Object> get(VMJExchange vmjExchange){
        // return record.getInformation(vmjExchange);
        return null;
    }

    // @Restriced(permission = "")
    @Route(url="call/article/list")
    public List<HashMap<String,Object>> getAll(VMJExchange vmjExchange){
        // return informationServiceImpl.getAllInformation();
        return null;
    }

    public List<HashMap<String,Object>> transformListToHashMap(List<Information> list){
        List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < list.size(); i++) {
            resultList.add(list.get(i).toHashMap());
        }
        // return resultList;
        return null;
    }

    // @Restriced(permission = "")
    @Route(url="call/article/delete")
    public List<HashMap<String,Object>> deleteInformation(VMJExchange vmjExchange){
        if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
            return null;
        }
        
        String idStr = (String) vmjExchange.getRequestBodyForm("id");
        int id = Integer.parseInt(idStr);
        // return informationServiceImpl.deleteInformation(id);
        return null;
    }
}