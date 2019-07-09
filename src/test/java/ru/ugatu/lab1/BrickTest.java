package ru.ugatu.lab1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BrickTest {

    Brick brick;

    @BeforeEach
    public void init(){
        brick = new Brick("кирпич", 2.5, "плоский", "красный");
    }

    @Test
    public void testBrick(){
        assertEquals(brick.getName(),"кирпич","кирпич");
        assertEquals(2.5, brick.getWeight());
        assertEquals(false, brick.getItemInside());
    }

}