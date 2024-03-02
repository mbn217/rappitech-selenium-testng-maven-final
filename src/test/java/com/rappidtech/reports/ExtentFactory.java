package com.rappidtech.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

    public class ExtentFactory {

        public static ExtentSparkReporter sparkReporter; // declaring sparkReporter
        public static ExtentReports extentReports;

        /**
         * Returns an ExtentReports object .
         * If an ExtentReports object doesn't exist, it's created and an ExtentSparkReporter is attached.
         */
        public static ExtentReports getInstance(){
            if (extentReports == null) {
                // Initializing the object and specifying the file path
                sparkReporter = new ExtentSparkReporter("./reports/extentreport.html"); // ExtentSparkReporter class used to customize the report file
                //Add additional information into our reports
                sparkReporter.config().setDocumentTitle("Automation Report For Sauce Labs");//Change report file title
                sparkReporter.config().setReportName("Report for RappidTech"); //Change report name
                sparkReporter.config().setTheme(Theme.STANDARD);
                extentReports = new ExtentReports();//ExtentReports class used to create report file
                extentReports.attachReporter(sparkReporter); //Attach ExtentSparkReporter object to ExtentReports object
                extentReports.setSystemInfo("Tester", "RappidTech");//Put System info
                extentReports.setSystemInfo("Selenium Version" ,"4.16.1");
                extentReports.setSystemInfo("Environment","QA");
                extentReports.setSystemInfo("Machine","Mac OS");
            }
            return extentReports;
        }
}
