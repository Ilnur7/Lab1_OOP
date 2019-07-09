package ru.ugatu.lab1;

import java.util.ArrayList;

public abstract class ItemCollect extends Item {

    private double maxWeight;
    protected ArrayList<Item> listItem = new ArrayList<Item>();

    public ItemCollect(String name, double weight, double maxWeight, String... propertiesItem) {
        super(name, weight, propertiesItem);
        this.maxWeight = maxWeight;
    }

    public ItemCollect(String name) {
        super(name);
    }

    public ItemCollect(String name, String... propertiesItem) {
        super(name, propertiesItem);
    }

    protected void addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        checkItemInsideThisItem(item);
        checkItemInside(item);
        checkItemInsideOtherItem();
        checkMaxWeight(item);
        getListItem().add(item);
        item.setItemInside(true);
    }

    protected Item removeItem() throws ItemStoreException {
        checkIsEmpty();
        int a = (int) Math.ceil(Math.random() * (getListItem().size() - 1));
        Item item = getListItem().get(a);
        getListItem().remove(a);
        setWeight(this.getWeight()-item.getWeight());
        return item;
    }

    protected Item findItem(String name) throws ItemStoreException {
        checkIsEmpty();
        for (Item item: getListItem()) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new ItemStoreException("Предмет с именем " + name.toUpperCase() + " не найден");
    }

    protected void checkItemInside(Item item) throws ItemAlreadyPlacedException {
        if (item.getItemInside()){
            throw new ItemAlreadyPlacedException("Предмет уже помещен в другой контейнер");
        }
    }

    protected void checkItemInsideOtherItem() throws ItemAlreadyPlacedException {
        if (this.getItemInside()){
            throw new ItemAlreadyPlacedException("Нельзя добавить предмет в этот контейнер, так как он находится в другом в контейнере");
        }
    }

    protected void checkItemInsideThisItem(Item item) throws ItemAlreadyPlacedException {
        if ((this.getItemInside() && item.getItemInside() || this.equals(item))){
            throw new ItemAlreadyPlacedException("Нельзя добавить предмет сам в себя");
        }
    }

    protected void checkMaxWeight(Item item) throws ItemStoreException {
        double weight = this.getWeight() + item.getWeight();
        if (weight > getMaxWeight()) {
            throw new ItemStoreException("Масса превышает допустимый вес");
        }
        setWeight(weight);
    }

    protected void checkIsEmpty() throws ItemStoreException {
        if (getListItem().isEmpty()) {
            throw new ItemStoreException("Контейнер пуст");
        }
    }

    protected ArrayList<Item> getListItem() {
        return listItem;
    }

    protected double getMaxWeight() {
        return maxWeight;
    }
}
