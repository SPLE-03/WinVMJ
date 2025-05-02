package healthcare.consultation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ConsultationService {
	Consultation createConsultation(Map<String, Object> requestBody);
	Consultation createConsultation(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getConsultation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveConsultation(Map<String, Object> requestBody);
    HashMap<String, Object> updateConsultation(Map<String, Object> requestBody);
    HashMap<String, Object> getConsultationById(int id);
    List<HashMap<String,Object>> getAllConsultation(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteConsultation(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Disbursement> List);
}
