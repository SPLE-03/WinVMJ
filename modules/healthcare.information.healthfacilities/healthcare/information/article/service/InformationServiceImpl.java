package healthcare.information.healthfacilities;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationServiceDecorator;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.InformationFactory;

import healthcare.information.core.InformationComponent;

import healthcare.information.core.Information;
import healthcare.information.healthfacilities.InformationImpl;

public class InformationServiceImpl extends InformationServiceDecorator {
    public InformationServiceImpl (InformationServiceComponent record) {
        super(record);
    }

    public Information saveHealthFacilities(Map<String, Object> requestBody) {
        String location = (String) requestBody.get("location");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");

        Information baseComponent = record.createInformation(requestBody);
        
        // Create the decorated information
        Information deco = InformationFactory.createInformation(
            "healthcare.information.healthfacilities.InformationImpl", 
            baseComponent, 
            location
        );

        Repository.saveObject(deco);
        return deco;
    }

    public Information updateHealthFacilities(Map<String, Object> requestBody) {
        String location = (String) requestBody.get("location");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");
        UUID id = UUID.fromString((String) requestBody.get("id"));

        Information information = Repository.getObject(id);

        ((InformationImpl) information).setLocation(location);
        ((InformationImpl) information).setInformationTitle(informationTitle);
        ((InformationImpl) information).setInformationDescription(informationDescription);

        Repository.updateObject(information);
        return information;
    }

    public List<Information> deleteHealthFacilities(UUID id) {
        Information information = Repository.getObject(id);
        Repository.deleteObject(information.getInformationId());
        return getAllHealthFacilities();
    }

    public Information getHealthFacilities(UUID id) {
        return Repository.getObject(id);
    }

    public List<Information> getAllHealthFacilities() {
        return Repository.getAllObject("information_healthfacilities");
    }
}