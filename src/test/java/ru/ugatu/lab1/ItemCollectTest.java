package ru.ugatu.lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCollectTest {

    private static Brick brick1;
    private static Brick brick2;
    private static Bag bag;
    private static Box box;

    @BeforeEach
    public void init() {
        brick1 = new Brick("кирпич1",2, "плоский");
        brick2 = new Brick("кирпич2",2, "плоский");
    }

    @Test
    public void addItem() throws ItemStoreException, ItemAlreadyPlacedException {
        bag = new Bag("мешок",0.1, 5 );
        bag.addItem(brick1);
        assertEquals("[[кирпич1]]", bag.getListItem().toString());
    }

    @Test
    public void removeItem() throws Exception {
        bag = new Bag("мешок",0.1, 4 );
        bag.addItem(brick1);
        bag.removeItem();
        assertEquals(0, bag.getListItem().size());
    }

    @Test
    public void findItem() throws Exception {
        bag = new Bag("мешок",0.1, 4 );
        bag.addItem(brick1);
        Item item = bag.findItem("кирпич1");
        assertEquals(item.getName(), "кирпич1");
    }

    @Test
    public void checkMaxWeight() throws ItemStoreException, ItemAlreadyPlacedException {
        bag = new Bag("мешок",0.1, 4 );
        bag.addItem(brick1);
        assertEquals(bag.getWeight(),2.1);
        assertThrows(ItemStoreException.class,
                () -> bag.addItem(brick2));

        /*try {
            bag.addItem(brick3);
            Assertions.fail("Expected ItemStoreException");
        } catch (ItemStoreException thrown) {
            Assertions.assertNotEquals("", thrown.getMessage());
        }*/
    }

    @Test
    public void checkItemInsideThisItem() {
        bag = new Bag("мешок",0.1, 4 );
        assertThrows(ItemAlreadyPlacedException.class,
                () -> bag.addItem(bag));
    }

    @Test
    void checkItemInside() throws ItemStoreException, ItemAlreadyPlacedException {
        bag = new Bag("мешок",0.1, 4 );
        bag.addItem(brick1);
        assertThrows(ItemAlreadyPlacedException.class,
                () -> bag.addItem(brick1));
    }

    @Test
    void checkItemInsideOtherItem() throws ItemStoreException, ItemAlreadyPlacedException {
        bag = new Bag("мешок",0.1, 4 );
        box = new Box("коробка",0.5, 10, "плоский");
        box.openBox();
        box.addItem(bag);
        assertThrows(ItemAlreadyPlacedException.class,
                () -> bag.addItem(brick1));
    }

    @Test
    void checkIsEmpty() {
        bag = new Bag("мешок",0.1, 4 );
        assertThrows(ItemStoreException.class,
                () -> bag.removeItem());
    }

}