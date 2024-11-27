package com.tigran.demo_software_patterns.structural.composite.file;

/**
 * Created by Tigran Melkonyan
 * Date: 12/6/24
 * Time: 5:04 PM
 */
public class File implements FileSystemComponent {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + " bytes)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
