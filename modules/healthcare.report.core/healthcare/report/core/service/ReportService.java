package healthcare.report.core;
import java.util.*;

import vmj.routing.route.VMJExchange;

public interface ReportService {
	Report createReport(Map<String, Object> requestBody);
	Report createReport(Map<String, Object> requestBody, Map<String, Object> response);
	HashMap<String, Object> getReport(Map<String, Object> requestBody);
    List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange);
    HashMap<String, Object> updateReport(Map<String, Object> requestBody);
    HashMap<String, Object> getReportById(int id);
    List<HashMap<String,Object>> getAllReport(Map<String, Object> requestBody);
    List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Report> List);
}
