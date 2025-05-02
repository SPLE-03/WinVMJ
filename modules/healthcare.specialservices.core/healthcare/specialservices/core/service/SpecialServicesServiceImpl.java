package healthcare.specialservices.core;
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
import healthcare.specialservices.SpecialServicesFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class SpecialServicesServiceImpl extends SpecialServicesServiceComponent{

    public List<HashMap<String,Object>> saveSpecialServices(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		SpecialServices specialservices = createSpecialServices(requestBody);
		Repository.saveObject(specialservices);
		return getAllSpecialServices(requestBody);
	}

    public SpecialServices createSpecialServices(Map<String, Object> requestBody){
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String distanceStr = (String) requestBody.get("distance");
		int distance = Integer.parseInt(distanceStr);
		boolean available = (boolean) requestBody.get("available");
		String details = (String) requestBody.get("details");
		UUID specialServicesUser = UUID.fromString((String)requestBody.get("userId"));
		
		//to do: fix association attributes
		SpecialServices specialServices = SpecialServicesFactory.createSpecialServices(
			"healthcare.specialservices.core.SpecialServicesImpl",
		UUID.randomUUID()
		, price
		, distance
		, available
		, details
		, specialServicesUser
		);
		Repository.saveObject(specialServices);
		return specialServices;
	}

    public HashMap<String, Object> updateSpecialServices(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("specialServicesId");
		int id = Integer.parseInt(idStr);
		SpecialServices specialservices = Repository.getObject(id);
		
		String priceStr = (String) requestBody.get("price");
		specialservices.setPrice(Integer.parseInt(priceStr));
		String distanceStr = (String) requestBody.get("distance");
		specialservices.setDistance(Integer.parseInt(distanceStr));
		specialservices.setAvailable(Boolean.parseBoolean((String)requestBody.get("available")));
		specialservices.setDetails((String) requestBody.get("details"));
		
		Repository.updateObject(specialservices);
		
		//to do: fix association attributes
		
		return specialservices.toHashMap();
		
	}

    public HashMap<String, Object> getSpecialServices(Map<String, Object> requestBody){
		List<HashMap<String, Object>> specialservicesList = getAllSpecialServices(requestBody);
		String idStr = (String) requestBody.get("id");
		for (HashMap<String, Object> specialservices : specialservicesList){
			int record_id = ((Double) specialservices.get("record_id")).intValue();
			if (record_id == Integer.parseInt(idStr)){
				return specialservices;
			}
		}
		return null;
	}

	public HashMap<String, Object> getSpecialServicesById(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("specialServicesId"); 
		int id = Integer.parseInt(idStr);
		SpecialServices specialservices = Repository.getObject(id);
		return specialservices.toHashMap();
	}

    public List<HashMap<String,Object>> getAllSpecialServices(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<SpecialServices> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<SpecialServices> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteSpecialServices(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllSpecialServices(requestBody);
	}

	public int calculatePrice() {
		// TODO: implement this method
		return 0;
	}

	public boolean isAvailable() {
		// TODO: implement this method
		return false;
	}

	public boolean callService(UUID id) {
		// TODO: implement this method
		return false;
	}

	public String getDetails(UUID id) {
		// TODO: implement this method
		return "";
	}

	public boolean cancelService(UUID id) {
		// TODO: implement this method
		return false;
	}
}
