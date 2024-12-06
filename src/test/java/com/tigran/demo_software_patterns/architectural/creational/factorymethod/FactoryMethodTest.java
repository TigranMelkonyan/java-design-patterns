package com.tigran.demo_software_patterns.architectural.creational.factorymethod;

import com.tigran.demo_software_patterns.creational.factorymethod.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 3:02 PM
 */
@SpringBootTest
public class FactoryMethodTest {


    @Autowired
    private ReportService reportService;

    @Test
    void shouldGeneratePdfReport() {
        String result = reportService.generateReport("PDF", "TestData");
        assertThat(result).isEqualTo("PDF Report: TestData");
    }

    @Test
    void shouldGenerateCsvReport() {
        String result = reportService.generateReport("CSV", "TestData");
        assertThat(result).isEqualTo("CSV Report: TestData");
    }

    @Test
    void shouldGenerateExcelReport() {
        String result = reportService.generateReport("EXCEL", "TestData");
        assertThat(result).isEqualTo("Excel Report: TestData");
    }

    @Test
    void shouldThrowExceptionForInvalidReportType() {
        assertThatThrownBy(() -> reportService.generateReport("INVALID", "TestData"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid report type: INVALID");
    }
}
