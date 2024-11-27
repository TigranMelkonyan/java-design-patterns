package com.tigran.demo_software_patterns.structural.composite.file;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:02 PM
 */
public interface FileSystemComponent {

    void display(String indent);

    int getSize();
}