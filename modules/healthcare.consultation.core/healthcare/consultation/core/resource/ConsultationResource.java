package healthcare.consultation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ConsultationResource {
    List<HashMap<String,Object>> saveConsultation(VMJExchange vmjExchange);
    HashMap<String, Object> updateConsultation(VMJExchange vmjExchange);
    HashMap<String, Object> getConsultation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllConsultation(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteConsultation(VMJExchange vmjExchange);
	HashMap<String, Object> createConsultation(VMJExchange vmjExhange);
}
