package com.tigran.demo_software_patterns.creational.factorymethod.factory;

import com.tigran.demo_software_patterns.creational.factorymethod.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 2:59 PM
 */
@Component
public class ReportFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public ReportFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public Report getReportGenerator(String reportType) {
        try {
            return applicationContext.getBean(reportType.toUpperCase(), Report.class);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid report type: " + reportType);
        }
    }
}
