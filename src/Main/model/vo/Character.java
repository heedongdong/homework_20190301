package model.vo;

import java.util.ArrayList;

public class Character {
    private String name;
    private int hp;
    private int mp;
    private int attack;
    private int defence;
    private int experience;
    private int distance;
    private int level;
    private int evasion;
    private Weapon weapon;
    private String job;
    private ArrayList skill;

    public ArrayList getSkill() {
        return skill;
    }

    public void setSkill(ArrayList skill) {
        this.skill = skill;
    }

    public Character() {
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

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int evasion) {
        this.evasion = evasion;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Character(String name, int hp, int mp, int attack, int defence, int experience, int distance, int level, int evasion, Weapon weapon, String job, ArrayList skill) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.distance = distance;
        this.level = level;
        this.evasion = evasion;
        this.weapon = weapon;
        this.job = job;
        this.skill = skill;
    }

    @Override
    public String toString() {
        String str = "*******************" +
                "\nname = " + name  +
                "\nhp = " + hp +
                "\nmp = " + mp +
                "\nattack = " + attack +
                "\ndefence = " + defence +
                "\nexperience = " + experience +
                "\ndistance = " + distance +
                "\nlevel = " + level +
                "\nevasion = " + evasion +
                "\nweapon = " + (weapon == null ? "없음" : weapon.getName()) +
                "\njob = " + job;
        if (skill != null) {
            for(int i=0;i<skill.size();i++){
                str += "\nskill"+i +" = "+ (skill.get(i) == null ? "" : ((Skill)skill.get(i)).getName());
            }
        }
        str += "\n*******************";
        return str;
    }
}