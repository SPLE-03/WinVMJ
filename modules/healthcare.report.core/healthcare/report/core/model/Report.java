package healthcare.report.core;
import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import java.util.*;

public interface Report {
	public UUID getReportId();
	public void setReportId(UUID reportId);
	public UUID getReportUser();
	public void setReportUser(UUID reportUser);
	public String getReportTitle();
	public void setReportTitle(String reportTitle);
	public String getReportContent();
	public void setReportContent(String reportContent);
	public EDate getCreatedAt();
	public void setCreatedAt(EDate createdAt);
	public boolean generate();
	HashMap<String, Object> toHashMap();
}
