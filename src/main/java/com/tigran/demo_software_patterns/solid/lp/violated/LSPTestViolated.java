package com.tigran.demo_software_patterns.solid.lp.violated;

/**
 * Created by Tigran Melkonyan
 * Date: 2/13/25
 * Time: 3:24 PM
 */

public class LSPTestViolated {
    public static void main(String[] args) {
        // Using Rectangle works as expected.
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // 20

        // Substituting Square for Rectangle breaks expectations.
        Rectangle squareAsRectangle = new Square();
        squareAsRectangle.setWidth(5);
        squareAsRectangle.setHeight(4);
        System.out.println("Square Area: " + squareAsRectangle.getArea()); // 16 (Expected 20)
    }
}

class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}
