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

	public ReportImpl(UUID reportId, UUID reportUser, String reportTitle, String reportContent, EDate createdAt) {
		this.reportId = reportId;
		this.reportUser = reportUser;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.createdAt = createdAt;
	}

	public ReportImpl(UUID reportId, UUID reportUser, String reportTitle, String reportContent, EDate createdAt) {
		this.reportId =  reportId.randomUUID();;
		this.reportId = reportId;
		this.reportUser = reportUser;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.createdAt = createdAt;
	}

	public ReportImpl() { }


	public boolean generate() {
		// TODO: implement this method
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

}
