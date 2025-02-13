package com.tigran.demo_software_patterns.solid.ocp;

/**
 * Created by Tigran Melkonyan
 * Date: 2/13/25
 * Time: 2:54 PM
 */
public class Main {

    static ShapeDrawer drawer = new ShapeDrawer();

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        drawer.drawer(circle);
        drawer.drawer(rectangle);
    }
}

interface Shape {
    void draw();

}

class Circle implements Shape {

    public void draw() {
        System.out.println("Circle");
    }

}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Rectangle");
    }

}

class ShapeDrawer {

    public void drawer(Shape shape) {
        shape.draw();
    }

}
