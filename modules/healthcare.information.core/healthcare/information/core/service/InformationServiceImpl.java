package healthcare.information.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.information.InformationFactory;
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class InformationServiceImpl extends InformationServiceComponent{

    public List<HashMap<String,Object>> saveInformation(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Information information = createInformation(vmjExchange);
		informationRepository.saveObject(information);
		return getAllInformation(vmjExchange);
	}

    public Information createInformation(Map<String, Object> requestBody){
		String informationTitle = (String) requestBody.get("informationTitle");
		String informationDescription = (String) requestBody.get("informationDescription");
		
		//to do: fix association attributes
		Information Information = InformationFactory.createInformation(
			"healthcare.information.core.InformationImpl",
		informationId
		, informationTitle
		, informationDescription
		);
		Repository.saveObject(information);
		return information;
	}

    public Information createInformation(Map<String, Object> requestBody, int id){
		String informationTitle = (String) vmjExchange.getRequestBodyForm("informationTitle");
		String informationDescription = (String) vmjExchange.getRequestBodyForm("informationDescription");
		
		//to do: fix association attributes
		
		Information information = InformationFactory.createInformation("healthcare.information.core.InformationImpl", informationId, informationTitle, informationDescription);
		return information;
	}

    public HashMap<String, Object> updateInformation(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("informationId");
		int id = Integer.parseInt(idStr);
		Information information = Repository.getObject(id);
		
		information.setInformationTitle((String) requestBody.get("informationTitle"));
		information.setInformationDescription((String) requestBody.get("informationDescription"));
		
		Repository.updateObject(information);
		
		//to do: fix association attributes
		
		return information.toHashMap();
		
	}

    public HashMap<String, Object> getInformation(Map<String, Object> requestBody){
		List<HashMap<String, Object>> informationList = getAllInformation("information_impl");
		for (HashMap<String, Object> information : informationList){
			int record_id = ((Double) information.get("record_id")).intValue();
			if (record_id == id){
				return information;
			}
		}
		return null;
	}

	public HashMap<String, Object> getInformationById(int id){
		String idStr = vmjExchange.getGETParam("informationId"); 
		int id = Integer.parseInt(idStr);
		Information information = informationRepository.getObject(id);
		return information.toHashMap();
	}

    public List<HashMap<String,Object>> getAllInformation(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Information> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Information> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteInformation(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllInformation(requestBody);
	}

}
