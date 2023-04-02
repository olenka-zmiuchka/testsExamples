package zoo;
import java.util.Arrays;
import java.util.Scanner;
public class Zoo1 {

    private Animal [] animals = new Animal[3];

    public Zoo1() {
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo1{" +
                "animals=" + Arrays.toString(animals) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo1 zoo1 = (Zoo1) o;
        return Arrays.equals(animals, zoo1.animals);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(animals);
    }

    public void addAnimals(Animal animal){
        for (int i = 0; i < this.animals.length; i++){
            if (this.getAnimals()[i] == null){
                this.getAnimals()[i] = animal;
                break;
            }
        }
    }

    /// метод, що вітає користувача і надає змогу обрати тип квитка і повертає код обраного квитка
    public int greetingAndChoosingTypeOfTicket() {
        Scanner input = new Scanner(System.in);

        System.out.println("""
                Welcome to our zoo! You have such options:
                1 -  ticket to zoo (see all animals without feeding) - 10$
                2 -  ticket to zoo and buy food for one choosing animal - 15...30$
                3 -  ticket to zoo end different food for feeding all animals (excursion) - 50$""");
        int chooseTicket = input.nextInt();

        if (chooseTicket == 2){
            System.out.println("""
                    What food do you want to buy:
                    1 - oat for horse
                    2 - bananas for chimpanzee
                    3 - fish for white bear""");
            chooseTicket = chooseTicket*10 + input.nextInt();
        }
        return chooseTicket;
    }
    /// метод, що перевіряє, чи достатня сума, надає користувачу решту і повертає істиннисть оплати
    public boolean payingProcess(int visitorMoney,int price){
        if (visitorMoney == price) {
            System.out.println("Thanks, take your ticket");
            return true;
        } else if (visitorMoney > price) {
            System.out.println("Thanks, take your ticket and " + (visitorMoney - price) + " change");
            return true;
        } else {
            System.out.println("Sorry, it is not enough ");
            return false;
        }
    }
    /// метод, що реалізує процес сплати за ціною по коду обраного квитка і повертає кінцевий результат оплати
    public boolean payingResult(int result, int visitorMoney){

        boolean resultPaying=true;
        switch (result) {
            case 1 -> resultPaying = payingProcess(visitorMoney, 10);
            case 21 -> resultPaying = payingProcess(visitorMoney, 15);
            case 22 -> resultPaying = payingProcess(visitorMoney, 20);
            case 23 -> resultPaying = payingProcess(visitorMoney, 25);
            case 3 -> resultPaying = payingProcess(visitorMoney, 50);
        }
        return  resultPaying;
    }
    public void zooViziting(Visitor visitor) {

        int chosenTypeTicket = this.greetingAndChoosingTypeOfTicket();
        if (this.payingResult(chosenTypeTicket, visitor.getMoney())) {
            /// розгалудження, яке пропонує ввести користувачу визначенний корм для для даної тварини
            // в залежності від типу обраного квитка
            if (chosenTypeTicket == 1) {
                System.out.println("We wish you a pleasant walk in our zoo");
            } else if (chosenTypeTicket == 21 || chosenTypeTicket == 22 || chosenTypeTicket == 23) {
                switch (chosenTypeTicket % 10) {
                    case 1 -> choosingAnimAccordingToTicket("oat");
                    case 2 -> choosingAnimAccordingToTicket("bananas");
                    case 3 ->choosingAnimAccordingToTicket("fish");
                }
            } else {
                choosingAnimAccordingToTicket("oat");
                choosingAnimAccordingToTicket("bananas");
                choosingAnimAccordingToTicket("fish");
            }
            System.out.println("Hope you're liked this zoo visit"+ "\n");
        } else
            System.out.println("Good buy, hope see you next time"+"\n");
    }
    public void choosingAnimAccordingToTicket(String food){

        for (int i = 0; i < this.getAnimals().length; i++) {
            if (this.getAnimals()[i].getAnimalFood().equals(food)) {
                this.getAnimals()[i].feeding();
                break;
            }
        }
    }
}

