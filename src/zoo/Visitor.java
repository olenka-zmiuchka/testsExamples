package zoo;

import java.util.Objects;

public class Visitor {
    private String name;
    private int money;

    public Visitor() {

    }

    public Visitor(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Visitor name " + name + " have  " + money + " dollars" + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return money == visitor.money && Objects.equals(name, visitor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}

