package ru.ugatu.lab1;

public class StackItems extends ItemCollect {

    private int maxCounter;

    protected StackItems(String name, double weight, double maxWeight, int maxCounter, String... propertiesItem) {
        super(name, weight, maxWeight, propertiesItem);
        this.maxCounter = maxCounter;
    }

    @Override
    protected String getInfo() {
        return "Предмет: " + getName() + ", количество: " + getListItem().size() + ", набор: "
                + getListItem();
    }

    @Override
    protected void addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        checkMaxCount(item);
        checkIsFlatItem(item);
        super.addItem(item);
    }

    protected void checkMaxCount(Item item) throws ItemStoreException {
        int counter = getListItem().size() + 1;
        if (counter > getMaxCounter()){
            throw new ItemStoreException("В стопке достигнуто max количество предметов");
        }
    }

    protected void checkIsFlatItem(Item item) throws ItemStoreException {
        if (!(item.getPropertiesItem().contains("плоский"))) {
            throw new ItemStoreException("Не плоские предметы нельзя положить в стопку");
        }
    }

    @Override
    protected Item removeItem() throws ItemStoreException {
        checkIsEmpty();
        Item item = getListItem().get(getListItem().size() -1);
        getListItem().remove(getListItem().size()-1);
        setWeight(this.getWeight()-item.getWeight());
        return item;
    }

    protected int getMaxCounter() {
        return maxCounter;
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
