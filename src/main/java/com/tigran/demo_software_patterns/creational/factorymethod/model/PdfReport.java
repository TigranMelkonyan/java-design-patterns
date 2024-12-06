package com.tigran.demo_software_patterns.creational.factorymethod.model;

import org.springframework.stereotype.Component;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 2:58 PM
 */
@Component("PDF")
public class PdfReport implements Report {
    @Override
    public String generate(String data) {
        return "PDF Report: " + data;
    }
}
