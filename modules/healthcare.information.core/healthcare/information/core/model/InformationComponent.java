package healthcare.information.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="information_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class InformationComponent implements Information{
	@Id
	public UUID informationId; 
	public String informationTitle;
	public String informationDescription;
	protected String objectName = InformationComponent.class.getName();

	public InformationComponent() {

	} 

	public InformationComponent(
        UUID informationId, String informationTitle, String informationDescription
    ) {
        this.informationId = informationId;
        this.informationTitle = informationTitle;
        this.informationDescription = informationDescription;
    }

	public abstract UUID getInformationId();
	public abstract void setInformationId(UUID informationId);
	
	public abstract String getInformationTitle();
	public abstract void setInformationTitle(String informationTitle);
	
	public abstract String getInformationDescription();
	public abstract void setInformationDescription(String informationDescription);
	
 

	@Override
    public String toString() {
        return "{" +
            " informationId='" + getInformationId() + "'" +
            " informationTitle='" + getInformationTitle() + "'" +
            " informationDescription='" + getInformationDescription() + "'" +
            "}";
    }
	
}
