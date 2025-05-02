package healthcare.report.core;
import java.util.*;

import vmj.hibernate.integrator.RepositoryUtil;
import vmj.routing.route.VMJExchange;
//add other required packages

public abstract class ReportResourceComponent implements ReportResource{
	
	public ReportResourceComponent() { }
 
    public abstract Report createReport(VMJExchange vmjExchange);    
	public abstract HashMap<String, Object> updateReport(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getReport(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllReport(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteReport(VMJExchange vmjExchange);

	public abstract boolean generate();
}
