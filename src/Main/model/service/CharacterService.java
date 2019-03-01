package model.service;
import model.vo.Character;
import model.vo.Skill;

import java.util.ArrayList;

public class CharacterService {
    public  Character  setCharacter(int num){
        Character unit = null;
        ArrayList<Skill> skillList = new ArrayList<Skill>();
        skillList.add(0,new Skill("회복",30,0));
        skillList.add(1,new Skill("분노",50,0));
        if(num==1){
            skillList.add(2,new Skill("방어력 증가",40,0));
            unit=new Character("사람", 150, 150, 400, 50 , 1078000, 1,98, 50, null,"없음",skillList);
        }else if(num==2){
            skillList.add(2,new Skill("공격력 증가",50,0));
            unit=new Character("오크", 150, 50, 100, 50 , 0, 3,1, 10,null,"없음",skillList);
        }else if(num==3){
            skillList.add(2,new Skill("회피력 증가",40,0));
            unit=new Character("엘프", 150, 130, 100, 20 , 0, 1,1, 150, null,"없음",skillList);
        }
        return unit;
    }
    public Character setChangeJob(Character character, int num){
        String name=character.getName();
        if(name=="사람"){
            if(num==1){
                character.setJob("전사");
                character.getSkill().add(3,new Skill("무적",100,10));
            }else if (num==2){
                character.setJob("마법사");
                character.getSkill().add(3,new Skill("메테오 소환",100,2));
            }
        }else if(name=="오크") {
            if (num == 1) {
                character.setJob("돌격병");
                character.getSkill().add(3,new Skill("공격력 5배",100,30));
            } else if(num == 2) {
                character.setJob("흑마술사");
                character.getSkill().add(3,new Skill("포이즌",100,20));
            }
        }else if(name=="엘프") {
            if (num == 1) {
                character.setJob("궁수");
                character.getSkill().add(3,new Skill("활 50발",100,20));
            } else if (num == 2) {
                character.setJob("힐러");
                character.getSkill().add(3,new Skill("부활",100,15));
            }
        }
        return character;
    }

    public  Character levelUp(Character character){
        if(character.getLevel()*character.getLevel()*110<=character.getExperience()){
            character.setLevel(character.getLevel()+1);
            character.setHp((int)(character.getHp()*1.5));
            character.setMp((int)(character.getMp()*1.3));
            character.setAttack((int)(character.getAttack()*1.3));
            character.setDefence((int)(character.getDefence()*1.3));
            character.setEvasion((int)(character.getEvasion()*1.3));
            System.out.println("************level up!!!************");
            System.out.println("************level : "+character.getLevel()+"!!!************");
        }
        return  character;
    }

    public Character byebye(Character character){
        if(character.getHp() <= 0) {
            character=null;
        }
        return character;
    }
}
