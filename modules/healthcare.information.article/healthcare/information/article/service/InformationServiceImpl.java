package healthcare.information.article;

import java.util.*;

import vmj.routing.route.VMJExchange;

import healthcare.information.core.InformationServiceDecorator;
import healthcare.information.core.InformationImpl;
import healthcare.information.core.InformationServiceComponent;

public class InformationServiceImpl extends InformationServiceDecorator {
    public InformationServiceImpl (InformationServiceComponent record) {
        super(record);
    }

    
}
