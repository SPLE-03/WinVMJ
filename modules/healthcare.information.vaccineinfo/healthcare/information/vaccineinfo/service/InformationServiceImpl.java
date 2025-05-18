package healthcare.information.vaccineinfo;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationServiceDecorator;
import healthcare.information.InformationFactory;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.core.InformationComponent;
import healthcare.information.core.Information;
import healthcare.information.vaccineinfo.InformationImpl;

public class InformationServiceImpl extends InformationServiceDecorator {
    public InformationServiceImpl (InformationServiceComponent record) {
        super(record);
    }

    public Information saveVaccineInfo(Map<String, Object> requestBody) {
        String vaccinationLocation = (String) requestBody.get("vaccinationLocation");
        String type = (String) requestBody.get("type");
        String schedule = (String) requestBody.get("schedule");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");

        Information baseComponent = record.createInformation(requestBody);
        
        // Create the decorated information
        Information deco = InformationFactory.createInformation(
            "healthcare.information.vaccineinfo.InformationImpl", 
            baseComponent, 
            vaccinationLocation,
            type,
            schedule
        );

        Repository.saveObject(deco);
        return deco;
    }

    public Information updateVaccineInfo(Map<String, Object> requestBody) {
        String vaccinationLocation = (String) requestBody.get("vaccinationLocation");
        String type = (String) requestBody.get("type");
        String schedule = (String) requestBody.get("schedule");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");
        UUID id = UUID.fromString((String) requestBody.get("id"));

        Information information = Repository.getObject(id);

        ((InformationImpl) information).setVaccinationLocation(vaccinationLocation);
        ((InformationImpl) information).setType(type);
        ((InformationImpl) information).setSchedule(schedule);
        ((InformationImpl) information).setInformationTitle(informationTitle);
        ((InformationImpl) information).setInformationDescription(informationDescription);

        Repository.updateObject(information);
        return information;
    }

    public List<Information> deleteVaccineInfo(UUID id) {
        Information information = Repository.getObject(id);
        Repository.deleteObject(information.getInformationId());
        return getAllVaccineInfo();
    }

    public Information getVaccineInfo(UUID id) {
        return Repository.getObject(id);
    }

    public List<Information> getAllVaccineInfo() {
        return Repository.getAllObject("information_vaccineinfo");
    }
    
}
