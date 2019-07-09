package ru.ugatu.lab1;

public class Bag extends ItemCollect {

    public Bag(String name, double weight, double maxWeight, String... propertiesItem){
        super(name, weight, maxWeight, propertiesItem);
    }

    @Override
    protected String getInfo() {
        return "Предмет: " + getName() + ", вес: " + getWeight() + ", макс.вес: " + getMaxWeight() + ", свойства: "
                + getPropertiesItem() + ", набор: " + getListItem();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
