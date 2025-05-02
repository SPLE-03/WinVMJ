package healthcare.report.core;

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


@Entity(name="report_impl")
@Table(name="report_impl")
public class ReportImpl extends ReportComponent {

	public ReportImpl(UUID reportId, UUID reportUser, String reportTitle, String reportContent, Date createdAt) {
		this.reportId = reportId;
		this.reportUser = reportUser;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.createdAt = createdAt;
	}

	public ReportImpl() { }


	public boolean generate() {
		// TODO: implement this method
		return false;
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> reportMap = new HashMap<String,Object>();
		reportMap.put("reportId",getReportId());
		reportMap.put("reportUser",getReportUser());
		reportMap.put("reportTitle",getReportTitle());
		reportMap.put("reportContent",getReportContent());
		reportMap.put("createdAt",getCreatedAt());

        return reportMap;
    }
	public UUID getReportId() {
		return this.reportId;
	}
	public void setReportId(UUID reportId) {
		this.reportId = reportId;
	}
	public UUID getReportUser() {
		return this.reportUser;
	}
	public void setReportUser(UUID reportUser) {
		this.reportUser = reportUser;
	}
	public String getReportTitle() {
		return this.reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getReportContent() {
		return this.reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
