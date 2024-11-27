package com.tigran.demo_software_patterns.behavioral.visitor.cart;

import com.tigran.demo_software_patterns.behavioral.visitor.model.Item;
import com.tigran.demo_software_patterns.behavioral.visitor.service.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:12 PM
 */
public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void accept(Visitor visitor) {
        for (Item item : items) {
            item.accept(visitor);
        }
    }
}