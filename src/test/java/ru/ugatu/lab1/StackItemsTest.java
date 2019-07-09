package ru.ugatu.lab1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StackItemsTest {

    private static Brick brick1;
    private static Brick brick2;
    private static Brick brick3;

    @BeforeEach
    public void init() throws ItemStoreException, ItemAlreadyPlacedException {
        brick1 = new Brick("кирпич1",4, "плоский");
        brick2 = new Brick("кирпич2",4, "плоский");
        brick3 = new Brick("кирпич3",4, "плоский");
    }

    @Test
    public void addItem() throws ItemStoreException, ItemAlreadyPlacedException {
        StackItems stackItems = new StackItems("стопка",1,9,2);
        stackItems.addItem(brick1);
        stackItems.addItem(brick2);
        assertEquals(stackItems.getListItem().get(stackItems.getListItem().size()-1).toString(), "[кирпич2]");
    }

    @Test
    public void removeItem() throws ItemStoreException, ItemAlreadyPlacedException {
        StackItems stackItems = new StackItems("стопка",1,9,1);
        stackItems.addItem(brick1);
        assertEquals(stackItems.getListItem().size(), 1);
        stackItems.getListItem().remove(stackItems.getListItem().size()-1);
        assertEquals(stackItems.getListItem().size(), 0);
    }

    @Test()
    public void checkMaxCount() throws ItemAlreadyPlacedException, ItemStoreException {
        StackItems stackItems = new StackItems("стопка",1,9,1);
        stackItems.addItem(brick1);
        assertThrows(ItemStoreException.class,
                () -> stackItems.addItem(brick2));
    }

    @Test
    public void checkItemInside() throws ItemAlreadyPlacedException, ItemStoreException {
        StackItems stackItems = new StackItems("стопка",1,9,2);
        stackItems.addItem(brick1);
        assertThrows(ItemAlreadyPlacedException.class,
                () -> stackItems.addItem(brick1));
    }

    @Test
    void checkIsFlatItem() throws ItemStoreException, ItemAlreadyPlacedException {
        StackItems stackItems = new StackItems("стопка",1,9,2);
        Bag bag = new Bag("мешок",0.1, 4 );
        assertThrows(ItemStoreException.class,
                () -> stackItems.addItem(bag));
    }

    protected void checkIsFlatItem(Item item) throws ItemStoreException {
        if (!(item.getPropertiesItem().contains("плоский"))) {
            throw new ItemStoreException("Не плоские предметы нельзя положить в стопку");
        }
    }


}