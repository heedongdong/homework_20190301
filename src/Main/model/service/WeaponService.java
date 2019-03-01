package model.service;
import model.vo.Weapon;

public class WeaponService {
    public  Weapon  setWeapon(String job, int num){
        Weapon weapon = null;
        if(job=="전사" || job=="돌격병"){
            if(num==1){
                weapon=new Weapon("검",130,3, 80);
            }else if(num==2){
                weapon=new Weapon("도끼",90,3, 130);
            }
        }else if(job=="마법사" || job=="흑마술사" || job =="힐러"){
                weapon=new Weapon("지팡이",100,2, 80);
        }else if(job=="궁수"){
                weapon=new Weapon("활",130,10, 80);
        }
        return weapon;
    }
}
