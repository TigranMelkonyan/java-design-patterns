package com.tigran.demo_software_patterns.solid.isp;

/**
 * Created by Tigran Melkonyan
 * Date: 2/13/25
 * Time: 3:48 PM
 */
public class MultiFunctionPrinter implements Printer, Scanner, Fax {
 
    public void print(Document d) {
    }

    public void scan(Document d) {
    }

    public void fax(Document d) {
    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

interface Fax {
    void fax(Document d);
}

class Document {
    private String title;
    private String author;

    public Document(
            final String title,
            final String author) {
        this.title = title;
        this.author = author;
    }
}