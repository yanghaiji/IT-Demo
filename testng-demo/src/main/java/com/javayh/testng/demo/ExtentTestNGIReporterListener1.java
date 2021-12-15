package com.javayh.testng.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author haiyang
 */
public class ExtentTestNGIReporterListener1 implements IReporter {

    private static final String OUTPUT_FOLDER = "test-output/";
    private static final String FILE_NAME = "Extent.html";

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        boolean createSuiteNode = false;
        if(suites.size()>1){
            createSuiteNode=true;
        }
        init();
        for (ISuite suite : suites) {
            Map<String,ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);
            }
        }
        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }

        extent.flush();
    }

    private void init() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        htmlReporter.config().setDocumentTitle("Javayh Demo 自动化测试报告");
        htmlReporter.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss");
        htmlReporter.config().setReportName("Javayh Demo API自动化测试报告");
        htmlReporter.config().setEncoding("utf-8");
        //图表位置
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                //显示方法名称
                String name = "";
                if (result.getMethod().getDescription() == null){
                    name = result.getMethod().getTestClass().getName();
                } else {
                    name = result.getMethod().getDescription();
                }
                test = extent.createTest(name);
                //创建子案例
                //test.createNode("子案例");
                for (String group : result.getMethod().getGroups()) {
                    //根据group
                    test.assignCategory(group);
                }

                if (result.getThrowable() != null) {
                    //异常案例，显示log到报告
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
                test.getModel().setDescription("测试案例执行!");
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}