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
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class SpecialServicesServiceImpl extends SpecialServicesServiceComponent{

    public List<HashMap<String,Object>> saveSpecialServices(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		SpecialServices specialservices = createSpecialServices(vmjExchange);
		specialservicesRepository.saveObject(specialservices);
		return getAllSpecialServices(vmjExchange);
	}

    public SpecialServices createSpecialServices(Map<String, Object> requestBody){
		String priceStr = (String) requestBody.get("price");
		int price = Integer.parseInt(priceStr);
		String distanceStr = (String) requestBody.get("distance");
		int distance = Integer.parseInt(distanceStr);
		boolean available = (boolean) requestBody.get("available");
		String details = (String) requestBody.get("details");
		
		//to do: fix association attributes
		SpecialServices SpecialServices = SpecialServicesFactory.createSpecialServices(
			"healthcare.specialservices.core.SpecialServicesImpl",
		specialServicesId
		, price
		, distance
		, available
		, details
		, specialServicesUser
		);
		Repository.saveObject(specialservices);
		return specialservices;
	}

    public SpecialServices createSpecialServices(Map<String, Object> requestBody, int id){
		String priceStr = (String) vmjExchange.getRequestBodyForm("price");
		int price = Integer.parseInt(priceStr);
		String distanceStr = (String) vmjExchange.getRequestBodyForm("distance");
		int distance = Integer.parseInt(distanceStr);
		boolean available = (boolean) vmjExchange.getRequestBodyForm("available");
		String details = (String) vmjExchange.getRequestBodyForm("details");
		
		//to do: fix association attributes
		
		SpecialServices specialservices = SpecialServicesFactory.createSpecialServices("healthcare.specialservices.core.SpecialServicesImpl", specialServicesId, price, distance, available, details, specialServicesUser);
		return specialservices;
	}

    public HashMap<String, Object> updateSpecialServices(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("specialServicesId");
		int id = Integer.parseInt(idStr);
		SpecialServices specialservices = Repository.getObject(id);
		
		String priceStr = (String) requestBody.get("price");
		specialservices.setPrice(Integer.parseInt(priceStr));
		String distanceStr = (String) requestBody.get("distance");
		specialservices.setDistance(Integer.parseInt(distanceStr));
		specialservices.setAvailable((String) requestBody.get("available"));
		specialservices.setDetails((String) requestBody.get("details"));
		
		Repository.updateObject(specialservices);
		
		//to do: fix association attributes
		
		return specialservices.toHashMap();
		
	}

    public HashMap<String, Object> getSpecialServices(Map<String, Object> requestBody){
		List<HashMap<String, Object>> specialservicesList = getAllSpecialServices("specialservices_impl");
		for (HashMap<String, Object> specialservices : specialservicesList){
			int record_id = ((Double) specialservices.get("record_id")).intValue();
			if (record_id == id){
				return specialservices;
			}
		}
		return null;
	}

	public HashMap<String, Object> getSpecialServicesById(int id){
		String idStr = vmjExchange.getGETParam("specialServicesId"); 
		int id = Integer.parseInt(idStr);
		SpecialServices specialservices = specialservicesRepository.getObject(id);
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
	}

	public boolean isAvailable() {
		// TODO: implement this method
	}

	public boolean callService(UUID id) {
		// TODO: implement this method
	}

	public String getDetails(UUID id) {
		// TODO: implement this method
	}

	public boolean cancelService(UUID id) {
		// TODO: implement this method
	}
}
