package healthcare.report.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class ReportDecorator extends ReportComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected ReportComponent record;

	public ReportDecorator () {
		super();
		this.record = record;
		this.reportId =  reportId.randomUUID();
		
	public ReportDecorator (ReportComponent record) {
		this.reportId =  reportId.randomUUID();
		this.record = record;
	}

	public ReportDecorator (UUID reportId, ReportComponent record) {
		this.reportId =  reportId;
		this.record = record;
	}
	
	public ReportDecorator (ReportComponent record, String objectName) {
		this.reportId =  reportId.randomUUID();
		this.record = record;	
		this.objectName=objectName;
	}

	public ReportDecorator() { }


	public boolean generate() {
		return record.generate();
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
