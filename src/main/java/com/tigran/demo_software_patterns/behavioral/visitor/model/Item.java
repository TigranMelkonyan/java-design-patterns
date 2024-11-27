package com.tigran.demo_software_patterns.behavioral.visitor.model;

import com.tigran.demo_software_patterns.behavioral.visitor.service.Visitor;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 9:11 PM
 */
public interface Item {
   
    void accept(Visitor visitor);
}

