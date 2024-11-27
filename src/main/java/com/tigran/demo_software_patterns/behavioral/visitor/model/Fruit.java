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
public class Fruit implements Item {

    private String name;
    private double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

