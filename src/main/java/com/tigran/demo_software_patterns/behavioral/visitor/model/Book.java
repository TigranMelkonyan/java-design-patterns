package com.tigran.demo_software_patterns.behavioral.visitor.model;

import com.tigran.demo_software_patterns.behavioral.visitor.service.Visitor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:11 PM
 */
@Getter
@Setter
public class Book implements Item {

    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

