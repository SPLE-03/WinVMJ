package healthcare.consultation.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Consultation {
	public UUID getConsultationId();
	public void setConsultationId(UUID consultationId);
	public String getConsultationSubject();
	public void setConsultationSubject(String consultationSubject);
	public String getConsultationDescription();
	public void setConsultationDescription(String consultationDescription);
	public boolean getConsultationStatus();
	public void setConsultationStatus(boolean consultationStatus);
	public boolean update(String subject, String description);
	HashMap<String, Object> toHashMap();
}
