package zoo;
import java.util.Objects;
import java.util.Scanner;

public class Animal {
    private String animalType;
    private String animalName;
    private String animalFood;

    public Animal() {
    }
    public Animal(String type, String  name, String food){
        this.animalType = type;
        this.animalName = name;
        this.animalFood = food;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalType = animalName;
    }

    public String getAnimalFood() {
        return animalFood;
    }

    public void setAnimalFood(String animalFood) {
        this.animalFood = animalFood;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalType='" + animalType + '\'' +
                ", animalName='" + animalName + '\'' +
                ", animalFood='" + animalFood + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(animalType, animal.animalType) && Objects.equals(animalName, animal.animalName) && Objects.equals(animalFood, animal.animalFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalType, animalName, animalFood);
    }

    public void voice(){
        System.out.println("animalVoice");
    }
    public void voiceBadFood(){
        System.out.println(" I' m still hungry, try another food  ");
    }

    /// метод, що реалізує процес годування отварини кормом. перевіряє, чи запропонований корм підходить тварині,
    // якщо ні, то тварина залишається голодною, до тих пір, поки користувач не введе валідну назву корму,
    // якщо так, то тварина видає характерний для неї звук
    public void feeding(){
        Scanner input = new Scanner(System.in);
        boolean res = true;
        do{
            System.out.println("This is a " + this.getAnimalType() + " "+ this.getAnimalName() + ", you can feed it by typing '"+ this.getAnimalFood()+"'");
            if (input.nextLine().toLowerCase().equals(this.getAnimalFood())) {
                this.voice();
                res = false;
            }
            else this.voiceBadFood();
        }
        while (res);
    }
}
