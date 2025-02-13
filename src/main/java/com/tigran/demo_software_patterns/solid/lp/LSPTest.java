package com.tigran.demo_software_patterns.solid.lp;

/**
 * Created by Tigran Melkonyan
 * Date: 2/13/25
 * Time: 3:26 PM
 */
public class LSPTest {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 4);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // 20

        Shape square = new Square(5);
        System.out.println("Square Area: " + square.getArea()); // 25
    }
}

interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }

}

class Square implements Shape {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}