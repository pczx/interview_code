package designPattern;

public class FactoryPattern {
    public static void main(String[] args) {
        new ShapeFactory().getShape("cicle").draw();
    }
}

class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if (shape.equals("rectange")) {
            return new Rectangle();
        } else if (shape.equals("square")) {
            return new Square();
        } else {
            return new Cicle();
        }
    }
}

abstract class AbstractFactory {
    abstract Shape getShape(String shape);
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw square");
    }
}

class Cicle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw cicle");
    }
}

interface Shape {
    void draw();
}
