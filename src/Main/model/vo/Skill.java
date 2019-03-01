package model.vo;

public class Skill {
    private  String name;
    private int mp;
    private int time;

    public Skill() {
    }

    public Skill(String name, int mp, int time) {
        this.name = name;
        this.mp = mp;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", mp=" + mp +
                ", time=" + time +
                '}';
    }
}