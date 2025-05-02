package healthcare.specialservices.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface SpecialServicesResource {
    List<HashMap<String,Object>> saveSpecialServices(VMJExchange vmjExchange);
    HashMap<String, Object> updateSpecialServices(VMJExchange vmjExchange);
    HashMap<String, Object> getSpecialServices(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllSpecialServices(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteSpecialServices(VMJExchange vmjExchange);
	HashMap<String, Object> createSpecialServices(VMJExchange vmjExhange);
}
