package model.service;
import model.vo.Monster;

public class MonsterService {
    public Monster setMonster(){
        Monster monster = new Monster("몬스터(lv.1)",400,10,0,1,1,100);
        return monster;
    }

}
