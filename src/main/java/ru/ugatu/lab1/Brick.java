package ru.ugatu.lab1;

public class Brick extends Item {

    protected Brick(String name, double weight, String... propertiesItem) {
        super(name, weight, propertiesItem);
    }

    protected Brick(String name, String... propertiesItem) {
        super(name, propertiesItem);
    }

    @Override
    protected String getInfo() {
        return "Предмет: " + getName() + ", вес: " + getWeight() + ", свойства: " + getPropertiesItem();
    }

    @Override
    public String toString() {
        return "[" + getName() + "]";
    }
}
