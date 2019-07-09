package ru.ugatu.lab1;

public class Main {

    public static void main(String[] args) throws Exception {
        Brick brick = new Brick("кирпич", 5, "красный", "плоский");
        System.out.println(brick.getInfo());
        System.out.println(brick);


        Bag bag = new Bag("мешок1",2,20);
        Brick brick1 = new Brick("кирпич1", 5, "красный", "плоский");
        Brick brick2 = new Brick("кирпич2", 6, "оранжевый", "прямоугольный", "плоский");
        Brick brick3 = new Brick("кирпич3", 7, "белый", "плоский");
        bag.addItem(brick1);
        bag.addItem(brick2);

        System.out.println(bag.findItem("кирпич2"));
        System.out.println(bag);

        StackItems stack = new StackItems("стопка1",1,6,4);
        stack.addItem(brick);

        System.out.println(stack.removeItem());
        System.out.println(stack);

        Box box = new Box("коробка1", 2,10,"плоский");
        stack.addItem(box);
        box.openBox();
        //box.addItem(brick3);
        System.out.println(stack);

    }
}
