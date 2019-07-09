package ru.ugatu.lab1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Item {

    private String name;
    private double weight;
    private boolean itemInside;
    private final Set<String> propertiesItem = new HashSet<String>();

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, double weight, String ... propertiesItem) {
        this.name = name;
        this.weight = weight;
        this.propertiesItem.addAll(Arrays.asList(propertiesItem));
    }

    public Item(String name, String ... propertiesItem) {
        this.name = name;
        this.propertiesItem.addAll(Arrays.asList(propertiesItem));
    }

    protected abstract String getInfo();

    protected boolean getItemInside() {
        return itemInside;
    }

    protected void setItemInside(boolean itemInside) {
        this.itemInside = itemInside;
    }

    protected Set<String> getPropertiesItem() {
        return propertiesItem;
    }

    protected String getName() {
        return name;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected double getWeight() {
        return weight;
    }



}
