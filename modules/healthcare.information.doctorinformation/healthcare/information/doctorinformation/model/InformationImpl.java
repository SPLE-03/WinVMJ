package healthcare.information.doctorinformation;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import healthcare.information.core.InformationDecorator;
import healthcare.information.core.Information;
import healthcare.information.core.InformationComponent;

@Entity(name="information_doctorinformation")
@Table(name="information_doctorinformation")
public class InformationImpl extends InformationDecorator {

	@Column(name="specialist", columnDefinition="TEXT")
	public String specialist;

	public InformationImpl() {
        super();
        this.objectName = InformationImpl.class.getName();
    }
    
    public InformationImpl(String specialist) {
    	super();
		this.specialist = specialist;
		this.objectName = InformationImpl.class.getName();
    }
	
	public InformationImpl(InformationComponent record, String specialist) {
		super(record);
		this.specialist = specialist;
		this.objectName = InformationImpl.class.getName();
	}

	@Override
    public UUID getInformationId() {
        return record.getInformationId();
    }

    @Override
    public void setInformationId(UUID informationId) {
        record.setInformationId(informationId);
    }

    @Override
    public String getInformationTitle() {
        return record.getInformationTitle();
    }

    @Override
    public void setInformationTitle(String informationTitle) {
        record.setInformationTitle(informationTitle);
    }

    @Override
    public String getInformationDescription() {
        return record.getInformationDescription();
    }

    @Override
    public void setInformationDescription(String informationDescription) {
        record.setInformationDescription(informationDescription);
    }

    public String getSpecialist() {
        return this.specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("specialist", specialist);
        return map;
    }

}
