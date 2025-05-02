package healthcare.report.core;
import java.util.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;
import vmj.routing.route.exceptions.*;
import healthcare.report.ReportFactory;
import vmj.auth.annotations.Restricted;
//add other required packages

public class ReportServiceImpl extends ReportServiceComponent{

    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Map<String, Object> requestBody = vmjExchange.getPayload();
		Report report = createReport(requestBody);
		Repository.saveObject(report);
		return getAllReport(requestBody);
	}

    public Report createReport(Map<String, Object> requestBody){
		String reportUser = (String) requestBody.get("reportUser");
		String reportTitle = (String) requestBody.get("reportTitle");
		String reportContent = (String) requestBody.get("reportContent");
		String createdAt = (String) requestBody.get("createdAt");
		//to do: fix association attributes
		Report Report = ReportFactory.createReport(
			"healthcare.report.core.ReportImpl",
		UUID.randomUUID()
		, reportUser
		, reportTitle
		, reportContent
		, createdAt
		);
		return Report;
	}

    public Report createReport(Map<String, Object> requestBody, Map<String, Object> response){
		String reportUser = (String) requestBody.get("reportUser");
		String reportTitle = (String) requestBody.get("reportTitle");
		String reportContent = (String) requestBody.get("reportContent");
		String createdAt = (String) requestBody.get("createdAt");

		//to do: fix association attributes

		Report report = ReportFactory.createReport(
			"healthcare.report.core.ReportImpl",
		UUID.randomUUID()
		, reportUser
		, reportTitle
		, reportContent
		, createdAt
		);
		return report;
	}

    public HashMap<String, Object> updateReport(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("reportId");
		int id = Integer.parseInt(idStr);
		Report report = Repository.getObject(id);
		
		report.setReportTitle((String) requestBody.get("reportTitle"));
		report.setReportContent((String) requestBody.get("reportContent"));
		
		Repository.updateObject(report);
		
		//to do: fix association attributes
		
		return report.toHashMap();
		
	}

    public HashMap<String, Object> getReport(Map<String, Object> requestBody){
		int id = Integer.parseInt((String) requestBody.get("reportId"));
		List<HashMap<String, Object>> reportList = getAllReport(requestBody);
		for (HashMap<String, Object> report : reportList){
			int record_id = Integer.parseInt((String) report.get("reportId"));
			if (record_id == id){
				return report;
			}
		}
		return null;
	}

	public HashMap<String, Object> getReportById(int id){
		Report report = Repository.getObject(id);
		return report.toHashMap();
	}

    public List<HashMap<String,Object>> getAllReport(Map<String, Object> requestBody){
		String table = (String) requestBody.get("table_name");
		List<Report> List = Repository.getAllObject(table);
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Report> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteReport(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllReport(requestBody);
	}

	public boolean generate() {
		// TODO: implement this method
		return false;
	}
}
