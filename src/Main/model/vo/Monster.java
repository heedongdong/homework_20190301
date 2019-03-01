package model.vo;

public class Monster {
    private String name;
    private int hp;
    private int attack;
    private int defence;
    private int distance;
    private int level;
    private  int experience;


    public Monster(String name, int hp, int attack, int defence, int distance, int level, int experience) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.distance = distance;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", distance=" + distance +
                ", level=" + level +
                ", experience=" + experience +
                '}';
    }
}