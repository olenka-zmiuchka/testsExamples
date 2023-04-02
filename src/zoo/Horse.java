package zoo;

import java.util.Objects;

public class Horse extends Animal {
    private boolean ride;

    public Horse() {
        super();
    }

    public Horse(String type, String name, String food, boolean ride) {
        super(type, name, food);
        this.ride = ride;
    }

    public boolean isRide() {
        return ride;
    }

    public void setRide(boolean ride) {
        this.ride = ride;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Horse horse = (Horse) o;
        return ride == horse.ride;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ride);
    }

    @Override
    public String toString() {
        return "Horse{" + super.toString()+
                "ride=" + ride +
                '}';
    }
    @Override
    public void voice (){
        System.out.println("Hrrr-Hrrr_Hrr");
    }
}
