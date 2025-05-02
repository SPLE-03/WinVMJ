package healthcare.consultation.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ConsultationResourceComponent implements ConsultationResource{
	
	public ConsultationResourceComponent() { }
 
    public abstract Consultation createConsultation(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateConsultation(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getConsultation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllConsultation(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteConsultation(VMJExchange vmjExchange);

	public abstract boolean consultationUpdate(String subject, String description);
}
