package com.tigran.demo_software_patterns.behavioral.visitor.service;

import com.tigran.demo_software_patterns.behavioral.visitor.model.Book;
import com.tigran.demo_software_patterns.behavioral.visitor.model.Fruit;
import lombok.Getter;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:12 PM
 */
@Getter
public class PriceCalculator implements Visitor {

    private double totalPrice = 0;

    @Override
    public void visit(Book book) {
        totalPrice += book.getPrice();
    }

    @Override
    public void visit(Fruit fruit) {
        totalPrice += fruit.getPrice();
    }
    
}

