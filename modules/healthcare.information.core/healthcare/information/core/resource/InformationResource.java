package healthcare.information.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface InformationResource {
    List<HashMap<String,Object>> saveInformation(VMJExchange vmjExchange);
    HashMap<String, Object> updateInformation(VMJExchange vmjExchange);
    HashMap<String, Object> getInformation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllInformation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteInformation(VMJExchange vmjExchange);
	HashMap<String, Object> Information(VMJExchange vmjExhange);
}
