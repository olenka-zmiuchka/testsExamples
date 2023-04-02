package zoo;

import java.util.Objects;

public class Monkey extends Animal {
    private String playing;
    private boolean photo;

    public Monkey() {
        super();
    }

    public Monkey(String type,String name, String food, boolean photo, String playing) {
        super(type, name, food);
        this.photo = photo;
        this.playing = playing;
    }

    public String getPlaying() {
        return playing;
    }

    public void setPlaying(String playing) {
        this.playing = playing;
    }

    public boolean isPhoto() {
        return photo;
    }

    public void setPhoto(boolean photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monkey monkey = (Monkey) o;
        return photo == monkey.photo && Objects.equals(playing, monkey.playing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playing, photo);
    }

    @Override
    public String toString() {
        return "Monkey{" +super.toString()+
                "playing='" + playing + '\'' +
                ", photo=" + photo +
                '}';
    }

    @Override
    public void voice() {
        System.out.println("uiuiuiui");
    }
}
