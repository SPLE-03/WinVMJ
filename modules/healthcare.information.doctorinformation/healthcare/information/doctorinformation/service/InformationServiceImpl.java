package healthcare.information.doctorinformation;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationServiceDecorator;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.InformationFactory;
import healthcare.information.core.InformationComponent;
import healthcare.information.core.Information;
import healthcare.information.doctorinformation.InformationImpl;

public class InformationServiceImpl extends InformationServiceDecorator {
    public InformationServiceImpl (InformationServiceComponent record) {
        super(record);
    }

    public Information saveDoctor(Map<String, Object> requestBody) {
        String specialist = (String) requestBody.get("specialist");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");

        Information baseComponent = record.createInformation(requestBody);
        
        // Create the decorated information
        Information deco = InformationFactory.createInformation(
            "healthcare.information.doctorinformation.InformationImpl", 
            baseComponent, 
            specialist
        );

        Repository.saveObject(deco);
        return deco;
    }

    public Information updateDoctor(Map<String, Object> requestBody) {
        String specialist = (String) requestBody.get("specialist");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");
        UUID id = UUID.fromString((String) requestBody.get("id"));

        Information information = Repository.getObject(id);

        ((InformationImpl) information).setSpecialist(specialist);
        ((InformationImpl) information).setInformationTitle(informationTitle);
        ((InformationImpl) information).setInformationDescription(informationDescription);

        Repository.updateObject(information);
        return information;
    }

    public List<Information> deleteDoctor(UUID id) {
        Information information = Repository.getObject(id);
        Repository.deleteObject(information.getInformationId());
        return getAllDoctor();
    }

    public Information getDoctor(UUID id) {
        return Repository.getObject(id);
    }

    public List<Information> getAllDoctor() {
        return Repository.getAllObject("information_doctorinformation");
    }
}
