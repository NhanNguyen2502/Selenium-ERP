package erp.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private  static  final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/ExtentReport.html");
        reporter.config().setReportName("Demo extent Report");
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Nhan Nguyen");
        extentReports.setSystemInfo("Author", "Nhan Nguyen");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setDocumentTitle("Automation Report");
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
