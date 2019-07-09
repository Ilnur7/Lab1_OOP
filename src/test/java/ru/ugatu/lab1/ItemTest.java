package ru.ugatu.lab1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test

    public void testItem() throws Exception {

        Brick brick1 = new Brick("кирпич1",2, "плоский");
        Brick brick2 = new Brick("кирпич2",2, "плоский");
        Brick brick3 = new Brick("кирпич3",2, "плоский");

        Bag bag = new Bag("мешок",0.1, 5);
        Box box = new Box("коробка",0.5, 10, "плоский");

        bag.addItem(brick1);
        bag.addItem(brick2);
        assertEquals(4.1, bag.getWeight());

        box.openBox();
        box.addItem(brick3);
        assertEquals(2.5, box.getWeight());

        box.addItem(bag);
        assertEquals(6.6, box.getWeight());

        StackItems stackItems = new StackItems("стопка",1,10 ,3);

        stackItems.addItem(box);

        assertThrows(ItemAlreadyPlacedException.class,
                () -> stackItems.addItem(brick3));

        assertTrue(stackItems.removeItem().equals(box));

        assertThrows(ItemStoreException.class,
                () -> stackItems.addItem(bag));

    }
}