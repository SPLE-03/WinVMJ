package healthcare.consultation.chatconsultation;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.consultation.core.ConsultationServiceDecorator;
import healthcare.consultation.core.ConsultationImpl;
import healthcare.consultation.core.ConsultationServiceComponent;

public class ConsultationServiceImpl extends ConsultationServiceDecorator {
    public ConsultationServiceImpl (ConsultationServiceComponent record) {
        super(record);
    }

    
}
