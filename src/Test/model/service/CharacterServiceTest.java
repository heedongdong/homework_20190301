package model.service;

import model.vo.Character;
import model.vo.Skill;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CharacterServiceTest {
    Logger logger = LoggerFactory.getLogger(CharacterServiceTest.class);
    Character character=null;
    ArrayList<Skill> skillList = new ArrayList<Skill>();

    @Before
    public void setCharacter() {
        skillList.add(0,new Skill("회복",30,0));
        skillList.add(1,new Skill("분노",50,0));
        character=new Character("사람", 150, 150, 400, 50 , 1078000, 1,98, 50, null,"없음",skillList);
        skillList.add(2,new Skill("공격력 증가",50,0));
        Assert.assertEquals("사람",character.getName());

    }

    @Test
    public void setChangeJob() {
        String name=character.getName();
        int num = 1;
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
        Assert.assertEquals("전사",character.getJob());
        Assert.assertEquals("무적",((Skill)character.getSkill().get(3)).getName());

    }

    @Test
    public void levelUp() {
        character.setExperience(character.getExperience()+110);
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
        Assert.assertEquals(99,character.getLevel());

    }

    @Test
    public void byebye() {
        character.setHp(0);
        if(character.getHp() <= 0) {
            character=null;
            System.out.println("************GAME OVER!!!************");
        }
        Assert.assertEquals(null,character);
    }
}