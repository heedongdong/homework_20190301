package model.vo;

public class Weapon {
    private String name;
    private int attack;
    private int distance;
    private int durability;

    public Weapon(String name, int attack, int distance, int durability) {
        this.name = name;
        this.attack = attack;
        this.distance = distance;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDistance() {
        return distance;
    }

    public int getDurability() {
        return durability;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", distance=" + distance +
                ", durability=" + durability +
                '}';
    }
}
