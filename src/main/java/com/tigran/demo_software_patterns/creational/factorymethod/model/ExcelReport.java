package com.tigran.demo_software_patterns.creational.factorymethod.model;

import org.springframework.stereotype.Component;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 2:59 PM
 */
@Component("EXCEL")
public class ExcelReport implements Report {
    @Override
    public String generate(String data) {
        return "Excel Report: " + data;
    }
}
