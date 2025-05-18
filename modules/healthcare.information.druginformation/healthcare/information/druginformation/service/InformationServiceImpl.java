package healthcare.information.druginformation;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationServiceDecorator;
import healthcare.information.druginformation.InformationImpl;
import healthcare.information.core.Information;
import healthcare.information.InformationFactory;
import healthcare.information.core.InformationServiceComponent;

public class InformationServiceImpl extends InformationServiceDecorator {
    public InformationServiceImpl (InformationServiceComponent record) {
        super(record);
    }

    public Information createDrugInformation(Map<String, Object> requestBody) {
        String dosage = (String) requestBody.get("dosage");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");

        Information baseComponent = record.createInformation(requestBody);
        
        // Create the decorated information
        Information deco = InformationFactory.createInformation(
            "healthcare.information.druginformation.InformationImpl", 
            baseComponent, 
            dosage
        );

        Repository.saveObject(deco);
        return deco;
    }

    public Information updateDrugInformation(Map<String, Object> requestBody) {
        String dosage = (String) requestBody.get("dosage");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");
        UUID id = UUID.fromString((String) requestBody.get("id"));

        Information information = Repository.getObject(id);

        ((InformationImpl) information).setDosage(dosage);
        ((InformationImpl) information).setInformationTitle(informationTitle);
        ((InformationImpl) information).setInformationDescription(informationDescription);

        Repository.updateObject(information);
        return information;
    }

    public List<Information> deleteDrugInformation(UUID id) {
        Information information = Repository.getObject(id);
        Repository.deleteObject(information.getInformationId());
        return getAllDrugInformation();
    }

    public Information getDrugInformation(UUID id) {
        return Repository.getObject(id);
    }

    public List<Information> getAllDrugInformation() {
        return Repository.getAllObject("information_druginformation");
    }
    
}
