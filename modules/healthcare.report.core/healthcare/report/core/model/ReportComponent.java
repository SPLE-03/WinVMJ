package healthcare.report.core;

import java.util.*;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="report_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ReportComponent implements Report{
	@Id
	public UUID reportId; 
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  reportId;
	@ManyToOne(targetEntity=healthcare..core.Component.class)
	public  reportUser;
	public String reportTitle;
	public String reportContent;
	public EDate createdAt;
	protected String objectName = ReportComponent.class.getName();

	public ReportComponent() {

	} 

	public ReportComponent(
        UUID reportId, UUID reportUser, String reportTitle, String reportContent, EDate createdAt
    ) {
        this.reportId = reportId;
        this.reportUser = reportUser;
        this.reportTitle = reportTitle;
        this.reportContent = reportContent;
        this.createdAt = createdAt;
    }

	public abstract UUID getReportId();
	public abstract void setReportId(UUID reportId);
	
	public abstract UUID getReportUser();
	public abstract void setReportUser(UUID reportUser);
	
	public abstract String getReportTitle();
	public abstract void setReportTitle(String reportTitle);
	
	public abstract String getReportContent();
	public abstract void setReportContent(String reportContent);
	
	public abstract EDate getCreatedAt();
	public abstract void setCreatedAt(EDate createdAt);
	
 
	public abstract boolean generate();

	@Override
    public String toString() {
        return "{" +
            " reportId='" + getReportId() + "'" +
            " reportUser='" + getReportUser() + "'" +
            " reportTitle='" + getReportTitle() + "'" +
            " reportContent='" + getReportContent() + "'" +
            " createdAt='" + getCreatedAt() + "'" +
            "}";
    }
	
}
