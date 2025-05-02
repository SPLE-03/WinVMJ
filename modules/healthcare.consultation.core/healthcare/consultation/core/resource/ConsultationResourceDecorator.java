package healthcare.consultation.core;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

public abstract class ConsultationResourceDecorator extends ConsultationResourceComponent{
	protected ConsultationResourceComponent record;

    public ConsultationResourceDecorator(ConsultationResourceComponent record) {
        this.record = record;
    }

    public Consultation createConsultation(VMJExchange vmjExchange){
		return record.createConsultation(vmjExchange);
	}

    public HashMap<String, Object> updateConsultation(VMJExchange vmjExchange){
		return record.updateConsultation(vmjExchange);
	}

    public HashMap<String, Object> getConsultation(VMJExchange vmjExchange){
		return record.getConsultation(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllConsultation(VMJExchange vmjExchange){
		return record.getAllConsultation(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteConsultation(VMJExchange vmjExchange){
		return record.deleteConsultation(vmjExchange);
	}

	public boolean consultationUpdate(String subject, String description) {
		return record.consultationUpdate(subject, description);
	}
}
