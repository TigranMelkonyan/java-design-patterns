package com.tigran.demo_software_patterns.creational.factorymethod.service;

import com.tigran.demo_software_patterns.creational.factorymethod.factory.ReportFactory;
import com.tigran.demo_software_patterns.creational.factorymethod.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:00 PM
 */
@Service
public class ReportService {

    private final ReportFactory reportFactory;

    @Autowired
    public ReportService(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    public String generateReport(String reportType, String data) {
        Report report = reportFactory.getReportGenerator(reportType);
        return report.generate(data);
    }
}
