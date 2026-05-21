package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;

	public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter report = new ExtentSparkReporter("Reports/ExtentReport.html");

            report.config().setReportName("EMI Calculator Automation");
            report.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(report);

            extent.setSystemInfo("Tester", "Sujitha");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }
	
}