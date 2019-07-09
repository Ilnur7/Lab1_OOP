package ru.ugatu.lab1;

public class Box extends Bag {

    private boolean isOpen = false;

    public Box(String name, double weight, double maxWeight, String... propertiesItem) {
        super(name, weight, maxWeight, propertiesItem);
    }

    protected boolean getIsOpen() {
        return isOpen;
    }

    protected void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    protected void openBox(){
        setIsOpen(true);
    }

    protected void closeBox(){
        setIsOpen(false);
    }

    protected String checkBox(){
        if (getIsOpen() == true){
            return "Коробка открыта";
        }else {
            return "Коробка закрыта";
        }
    }

    protected void checkIsOpenBox(Item item) throws ItemStoreException {
        if (getIsOpen() == false){
            throw new ItemStoreException("Коробка закрыта, откройте коробку");
        }
    }

    @Override
    protected void addItem(Item item) throws ItemStoreException, ItemAlreadyPlacedException {
        checkIsOpenBox(item);
        super.addItem(item);

    }

    @Override
    public String toString() {
        return "[" + getName() + "]";
    }
}
