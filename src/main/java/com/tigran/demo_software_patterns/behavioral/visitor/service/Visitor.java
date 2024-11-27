package com.tigran.demo_software_patterns.behavioral.visitor.service;

import com.tigran.demo_software_patterns.behavioral.visitor.model.Book;
import com.tigran.demo_software_patterns.behavioral.visitor.model.Fruit;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:12 PM
 */
public interface Visitor {

    void visit(Book book);

    void visit(Fruit fruit);
}
