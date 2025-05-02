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
import prices.auth.vmj.annotations.Restricted;
//add other required packages

public class ReportServiceImpl extends ReportServiceComponent{

    public List<HashMap<String,Object>> saveReport(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Report report = createReport(vmjExchange);
		reportRepository.saveObject(report);
		return getAllReport(vmjExchange);
	}

    public Report createReport(Map<String, Object> requestBody){
		String reportTitle = (String) requestBody.get("reportTitle");
		String reportContent = (String) requestBody.get("reportContent");
		
		//to do: fix association attributes
		Report Report = ReportFactory.createReport(
			"healthcare.report.core.ReportImpl",
		reportId
		, reportUser
		, reportTitle
		, reportContent
		, createdAt
		);
		Repository.saveObject(report);
		return report;
	}

    public Report createReport(Map<String, Object> requestBody, int id){
		String reportTitle = (String) vmjExchange.getRequestBodyForm("reportTitle");
		String reportContent = (String) vmjExchange.getRequestBodyForm("reportContent");
		
		//to do: fix association attributes
		
		Report report = ReportFactory.createReport("healthcare.report.core.ReportImpl", reportId, reportUser, reportTitle, reportContent, createdAt);
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
		List<HashMap<String, Object>> reportList = getAllReport("report_impl");
		for (HashMap<String, Object> report : reportList){
			int record_id = ((Double) report.get("record_id")).intValue();
			if (record_id == id){
				return report;
			}
		}
		return null;
	}

	public HashMap<String, Object> getReportById(int id){
		String idStr = vmjExchange.getGETParam("reportId"); 
		int id = Integer.parseInt(idStr);
		Report report = reportRepository.getObject(id);
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
	}
}
