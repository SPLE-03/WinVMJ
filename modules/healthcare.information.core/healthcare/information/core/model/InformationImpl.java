package healthcare.information.core;

import java.lang.Math;
import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="information_impl")
@Table(name="information_impl")
public class InformationImpl extends InformationComponent {

	public InformationImpl(UUID informationId, String informationTitle, String informationDescription) {
		this.informationId = informationId;
		this.informationTitle = informationTitle;
		this.informationDescription = informationDescription;
	}

	public InformationImpl(UUID informationId, String informationTitle, String informationDescription) {
		this.informationId =  informationId.randomUUID();;
		this.informationId = informationId;
		this.informationTitle = informationTitle;
		this.informationDescription = informationDescription;
	}

	public InformationImpl() { }


	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> informationMap = new HashMap<String,Object>();
		informationMap.put("informationId",getInformationId());
		informationMap.put("informationTitle",getInformationTitle());
		informationMap.put("informationDescription",getInformationDescription());

        return informationMap;
    }

}
