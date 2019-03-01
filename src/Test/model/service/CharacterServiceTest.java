package model.service;

import model.vo.Character;
import model.vo.Skill;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CharacterServiceTest {
    Logger logger = LoggerFactory.getLogger(CharacterServiceTest.class);
    @Test
    public void setCharacter() {
        Character unit = null;
        ArrayList<Skill> skillList = new ArrayList<Skill>();
        skillList.add(0,new Skill("회복",30,0));
        skillList.add(1,new Skill("분노",50,0));

        skillList.add(2,new Skill("방어력 증가",40,0));
        unit=new Character("사람", 150, 150, 400, 50 , 1078000, 1,98, 50, null,"없음",skillList);
//        skillList.add(2,new Skill("공격력 증가",50,0));
//        unit=new Character("오크", 150, 50, 100, 50 , 0, 3,1, 10,null,"없음",skillList);
//        skillList.add(2,new Skill("회피력 증가",40,0));
//        unit=new Character("엘프", 150, 130, 100, 20 , 0, 1,1, 150, null,"없음",skillList);
        logger.info(unit.toString());
    }

    @Test
    public void setChangeJob() {
    }

    @Test
    public void levelUp() {
    }

    @Test
    public void byebye() {
    }
}