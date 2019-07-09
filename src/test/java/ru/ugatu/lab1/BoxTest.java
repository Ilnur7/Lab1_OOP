package ru.ugatu.lab1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {
    Brick brick1;
    Brick brick2;
    Brick brick3;
    Box box;

    @BeforeEach
    public void init() throws ItemStoreException, ItemAlreadyPlacedException {
        brick1 = new Brick("кирпич1",4, "плоский");
        brick2 = new Brick("кирпич2",4, "плоский");
        brick3 = new Brick("кирпич3",4, "плоский");
        box = new Box("коробка",0.5, 10, "плоский");
        box.openBox();
        box.addItem(brick1);
        box.addItem(brick2);
    }

    @Test
    public void checkBox() {
        box.setIsOpen(true);
        assertEquals("Коробка открыта", box.checkBox());
    }

    @Test
    public void openBox() {
        assertTrue(brick1.getItemInside());
    }

    @Test
    public void closeBox() {
        box.closeBox();
        assertFalse(box.getItemInside());
    }

    @Test
    public void checkIsOpenBoxм() {
        Box box1 = new Box("коробка",0.5, 10, "плоский");
        assertThrows(ItemStoreException.class,
                () -> box1.addItem(brick1));
    }


}