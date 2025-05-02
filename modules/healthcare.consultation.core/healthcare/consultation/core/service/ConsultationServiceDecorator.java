package healthcare.consultation.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public abstract class ConsultationServiceDecorator extends ConsultationServiceComponent{
	protected ConsultationServiceComponent record;

    public ConsultationServiceDecorator(ConsultationServiceComponent record) {
        this.record = record;
    }

	public ConsultationImpl createConsultation(Map<String, Object> requestBody){
		return record.createConsultation(requestBody);
	}

    public Consultation createConsultation(Map<String, Object> requestBody, Map<String, Object> response){
		return record.createConsultation(requestBody, response);
	}

	public HashMap<String, Object> getConsultation(Map<String, Object> requestBody){
		return record.getConsultation(requestBody);
	}

	public List<HashMap<String,Object>> getAllConsultation(Map<String, Object> requestBody){
		return record.getAllConsultation(requestBody);
	}

    public List<HashMap<String,Object>> saveConsultation(VMJExchange vmjExchange){
		return record.saveConsultation(vmjExchange);
	}

    public HashMap<String, Object> updateConsultation(Map<String, Object> requestBody){
		return record.updateConsultation(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Consultation> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteConsultation(Map<String, Object> requestBody){
		return record.deleteConsultation(requestBody);
	}

	public HashMap<String, Object> getConsultationById(int id){
        return record.getConsultationById(id);
    }

	public boolean consultationUpdate(String subject, String description) {
		return record.consultationUpdate(subject, description);
	}
}
