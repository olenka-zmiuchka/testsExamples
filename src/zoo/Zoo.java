/*package java_oop;

import java.util.Objects;
import java.util.Scanner;

public class Zoo {
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
/*   public static void main(String[] args) {
       /// створення обєктів класу Animal
        Animal lion = new Animal("lion", "meat", "RRRRRRRRRRRRRR");
        Animal monkey = new Animal("chimpanzee", "bananas", "uiuiuiui");
        Animal bears = new Animal("white bear", "fish", "HRHRHRHRHR");
        Scanner input = new Scanner(System.in);

        int chosenTypeTicket= greetingAndChoosingTypeOfTicket(input);

        if (payingResult(chosenTypeTicket, input)){
            /// розгалудження, яке пропонує ввести користувачу визначенний корм для для даної тварини
            // в залежності від типу обраного квиткатварини
            switch (chosenTypeTicket) {
                case 1 -> System.out.println("We wish you a pleasant walk in our zoo");
                case 21 -> {
                    System.out.println("This is a lion, you can feed it, type 'meat'");
                    feeding(lion);
                }
                case 22 -> {
                    System.out.println("This is a chimpanzee, you can feed it, type 'bananas'");
                    feeding(monkey);
                }
                case 23 -> {
                    System.out.println("This is a white bear, you can feed it, type 'fish'");
                    feeding(bears);
                }
                case 3 -> {
                    System.out.println("This is a lion, you can feed it, type 'meat'");
                    feeding(lion);
                    System.out.println("This is a chimpanzee, you can feed it, type 'bananas'");
                    feeding(monkey);
                    System.out.println("This is a white bear, you can feed it, type 'fish'");
                    feeding(bears);
                }
            }
            System.out.println("Hope you like the excursion");
        }
        else System.out.println("Good buy, hope see you next time");
    }
    /// метод, що вітає користувача і надає змогу обрати тип квитка і повертає код обраного квитка
    static int greetingAndChoosingTypeOfTicket(Scanner input) {

        System.out.println("""
                 Welcome to our zoo! You have such options:
                1 -  ticket to zoo (see all animals without feeding)
                2 -  ticket to zoo and buy food for one choosing animal
                3 -  ticket to zoo end different food for feeding all animals (excursion)""");
        int chooseTicket = input.nextInt();
        if (chooseTicket == 2){
            System.out.println("""
                    What food do you want to buy:
                    1 - meat for lion
                    2 - bananas for chimpanzee
                    3 - fish for white bear""");
            chooseTicket = chooseTicket*10 + input.nextInt();
        }

        return chooseTicket;
    }
    /// метод, що перевіряє, чи достатня сума, надає користувачу решту і
    // повертає істиннисть оплати
    static boolean payingProcess(Scanner input,int price){
        int pay;
        System.out.println(price);
        pay = input.nextInt();
        if (pay == price) {
            System.out.println("Thanks, take your ticket");
            return true;
        } else if (pay > price) {
            System.out.println("Thanks, take your ticket and " + (pay - price) + " change");
            return true;
        } else {
            System.out.println("Sorry, it is not enough ");
            return false;
        }

    }
    /// метод, що реалізує процес сплати за ціною по коду обраного квитка і повертає кінцевий результат оплати
    static boolean payingResult(int result, Scanner input){

        boolean resultPaying=true;
        System.out.println("Please, pay for your ticket:");
        switch (result) {
            case 1 -> resultPaying = payingProcess(input, 10);
            case 21 -> resultPaying = payingProcess(input, 20);
            case 22 -> resultPaying = payingProcess(input, 13);
            case 23 -> resultPaying = payingProcess(input, 17);
            case 3 -> resultPaying = payingProcess(input, 25);
        }
        return  resultPaying;
    }
   /// метод, що реалізує процес годування отварини кормом. перевіряє, чи запропонований корм підходить тварині,
    // якщо ні, то пропонує дати інший, якщо так, то тварина видає характерний для неї звук

    static  void feeding(Animal animal){
        String animalFeeding;

        Scanner input1 = new Scanner(System.in);

        do {
            animalFeeding = input1.nextLine().toLowerCase();
            if (animal.voice(animalFeeding)) {
                animal.voiceGoodFood();
            } else animal.voiceBadFood();
        } while (!animal.voice(animalFeeding));

    }
}

/// клас "тварина"
class Animal{
    private String animalName;
    private String animalFood;
    private String animalVoice;
    Animal(String  name, String food, String voice){
        this.animalName = name;
        this.animalFood = food;
        this.animalVoice = voice;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalFood() {
        return animalFood;
    }

    public void setAnimalFood(String animalFood) {
        this.animalFood = animalFood;
    }

    public String getAnimalVoice() {
        return animalVoice;
    }

    public void setAnimalVoice(String animalVoice) {
        this.animalVoice = animalVoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalName, animal.animalName) && Objects.equals(animalFood, animal.animalFood) && Objects.equals(animalVoice, animal.animalVoice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalFood, animalVoice);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalName='" + animalName + '\'' +
                ", animalFood='" + animalFood + '\'' +
                ", animalVoice='" + animalVoice + '\'' +
                '}';
    }

    public boolean voice(String choosingAnimalFood){
        return  choosingAnimalFood.equals(this.animalFood);
    }
    public void voiceGoodFood(){
        System.out.println(this.animalVoice);
    }
    public void voiceBadFood(){
        System.out.println(" I' m still hungry, try another food  ");
    }
}
*/





