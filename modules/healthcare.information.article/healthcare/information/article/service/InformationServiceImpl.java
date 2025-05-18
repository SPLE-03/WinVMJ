package healthcare.information.article;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationServiceDecorator;
import healthcare.information.core.InformationServiceComponent;
import healthcare.information.InformationFactory;

import healthcare.information.core.InformationComponent;

import healthcare.information.core.Information;
import healthcare.information.article.InformationImpl;

public class InformationServiceImpl extends InformationServiceDecorator {
    public InformationServiceImpl (InformationServiceComponent record) {
        super(record);
    }

    public Information saveArticle(Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");

        Information baseComponent = record.createInformation(requestBody);
        
        // Create the decorated information
        Information deco = InformationFactory.createInformation(
            "healthcare.information.article.InformationImpl", 
            baseComponent, 
            content
        );

        Repository.saveObject(deco);
        return deco;
    }

    public Information updateArticle(Map<String, Object> requestBody) {
        String content = (String) requestBody.get("content");
        String informationTitle = (String) requestBody.get("informationTitle");
        String informationDescription = (String) requestBody.get("informationDescription");
        UUID id = UUID.fromString((String) requestBody.get("id"));

        Information information = Repository.getObject(id);

        ((InformationImpl) information).setContent(content);
        ((InformationImpl) information).setInformationTitle(informationTitle);
        ((InformationImpl) information).setInformationDescription(informationDescription);

        Repository.updateObject(information);
        return information;
    }

    public List<Information> deleteArticle(UUID id) {
        Information information = Repository.getObject(id);
        Repository.deleteObject(information.getInformationId());
        return getAllArticle();
    }

    public Information getArticle(UUID id) {
        return Repository.getObject(id);
    }

    public List<Information> getAllArticle() {
        return Repository.getAllObject("information_article");
    }
    
}
