package zoo;

import java.util.Objects;

public class Bear extends Animal {
    private String fishingTogether;

    public Bear() {
    }

    public Bear(String type, String name, String food, String fishingTogether) {
        super(type,name,food);
        this.fishingTogether = fishingTogether;
    }

    public String getFishingTogether() {
        return fishingTogether;
    }

    public void setFishingTogether(String fishingTogether) {
        this.fishingTogether = fishingTogether;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bear bear = (Bear) o;
        return Objects.equals(fishingTogether, bear.fishingTogether);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fishingTogether);
    }

    @Override
    public String toString() {
        return "Bear{" +super.toString()+
                "fishingTogether='" + fishingTogether + '\'' +
                '}';
    }
    @Override
    public void voice() {
        System.out.println("Bear voice");
    }
}
