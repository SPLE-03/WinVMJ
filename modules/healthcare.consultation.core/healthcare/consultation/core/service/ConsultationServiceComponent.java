package healthcare.consultation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ConsultationServiceComponent implements ConsultationService{
	protected RepositoryUtil<Consultation> Repository;

    public ConsultationServiceComponent(){
        this.Repository = new RepositoryUtil<Consultation>(healthcare.consultation.core.ConsultationComponent.class);
    }	

    public abstract List<HashMap<String,Object>> saveConsultation(VMJExchange vmjExchange);
    public abstract Consultation createConsultation(Map<String, Object> requestBodye);
	public abstract Consultation createConsultation(Map<String, Object> requestBody, Map<String, Object> response);    
	public abstract HashMap<String, Object> updateConsultation(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getConsultation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> getAllConsultation(Map<String, Object> requestBody);
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Consultation> List);
    public abstract List<HashMap<String,Object>> deleteConsultation(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getConsultationById(int id);

	public abstract boolean consultationUpdate(String subject, String description);
}
