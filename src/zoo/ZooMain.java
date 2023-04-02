package zoo;
 /*
    15.11.2022 (lection 5)
    3. Создать систему классов для программы "зоопарк". Пользователь должен иметь возможность попасть в зоопарк,
    оплатив его и кормить разных животных по выбору(лошадь, шимпанзе, кенгуру).
    Каждое животное должно издавать только ему присущий звук при кормежке .
    У пользователя должна быть возможность попасть на экскурсию(покормить всех животных).

    Тут наверное имелось в виду, что нужно исопльзовать иерархию наследования.
    ЧТо например Лошадь наследник Животного, переопределяете метод голос, добавляете нужные поля и так далее.
    А то уж слишком просто задание получается.Ну и класс посетитель должен быть.
    */

public class ZooMain {
    public static void main(String[] args) {
        Horse horse1 = new Horse("horse", "Holly", "oat", false);
        Monkey monkey1 = new Monkey("monkey","Ozzy", "bananas", true, "chess");
        Bear bear = new Bear();
        bear.setAnimalType("white bear");
        bear.setAnimalName("Teddy");
        bear.setAnimalFood("fish");
        bear.setFishingTogether("let's fishing together");


        Visitor visitor1 = new Visitor("Olga", 50);
        Visitor visitor2 = new Visitor("Oleg", 20);

        Zoo1 zoo = new Zoo1();

        zoo.addAnimals(horse1);
        zoo.addAnimals(monkey1);
        zoo.addAnimals(bear);

        System.out.println(visitor1);
        zoo.zooViziting(visitor1);
        System.out.println(visitor2);
        zoo.zooViziting(visitor2);
    }
}
