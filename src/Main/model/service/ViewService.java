package model.service;

import model.vo.Character;
import model.vo.Monster;
import model.vo.Skill;
import org.junit.Before;

import java.util.Scanner;

public class ViewService {

    CharacterService characterService = new CharacterService();
    WeaponService weaponService = new WeaponService();
    Character unit;
    int num;
    Scanner sc = new Scanner(System.in);

    @Before
    public void mainView() {
        boolean check = false;
        do {
            System.out.println("==============================");
            System.out.println("1. 게임 시작하기");
            System.out.println("==============================");
            int a = sc.nextInt();
            if (a == 1) {
                characterView();
            } else if (a == 0) {
                adminView();
            } else {
                System.out.println("잘못 입력 했습니다;^;");
                check = true;
            }
        } while (check);
    }

    public void characterView() {
        System.out.println("==============================");
        System.out.println("캐릭터 선택 : ");
        System.out.println("1. 사람");
        System.out.println("2. 오크");
        System.out.println("3. 엘프");
        System.out.println("==============================");
        int a = sc.nextInt();
        unit = characterService.setCharacter(a);
    }

    public void adminView() {
        System.out.println("==============================");
        System.out.println("관리자로 접속했습니다.");
        System.out.println("캐릭터 선택 : ");
        int charac = sc.nextInt();
        unit = characterService.setCharacter(charac);

        System.out.println("hp  : ");
        num = sc.nextInt();
        unit.setHp(num);

        System.out.println("mp : ");
        num = sc.nextInt();
        unit.setMp(num);

        System.out.println("attack  : ");
        num = sc.nextInt();
        unit.setAttack(num);

        System.out.println("defence : ");
        num = sc.nextInt();
        unit.setDefence(num);

        System.out.println("experience : ");
        num = sc.nextInt();
        unit.setExperience(num);

        System.out.println("distance : ");
        num = sc.nextInt();
        unit.setDistance(num);

        System.out.println("level : ");
        num = sc.nextInt();
        unit.setLevel(num);

        System.out.println("evasion : ");
        num = sc.nextInt();
        unit.setEvasion(num);

//        System.out.println("weapon : ");
//        str=sc.next();
//        Weapon weapon = new Weapon(str);
//        unit.setWeapon(num);

    }

    public void setJobView() {
        if (unit.getLevel() == 99 && unit.getJob() == "없음") {
            String name = unit.getName();
            System.out.println("전직 레벨에 도달 했습니다.");
            System.out.println("직업을 선택하세요");
            System.out.println("==============================");
            if (name == "사람") {
                System.out.println("1. 전사");
                System.out.println("2. 마법사");
            } else if (name == "오크") {
                System.out.println("1. 돌격병");
                System.out.println("2. 흑마술사");
            } else if (name == "엘프") {
                System.out.println("1. 궁수");
                System.out.println("2. 힐러");
            }
            System.out.println("==============================");
            num = sc.nextInt();
            unit = characterService.setChangeJob(unit, num);
            System.out.println("당신은" + unit.getJob() + "로 전직 되었습니다.");
            setWeaponView();
        }
    }

    public void setWeaponView() {
        String job = unit.getJob();
        System.out.println("무기를 선택하세요.");
        System.out.println("==============================");
        if (job == "전사" || job == "돌격병") {
            System.out.println("1. 검");
            System.out.println("2. 도끼");
            num = sc.nextInt();
            unit.setWeapon(weaponService.setWeapon(job, num));
        } else {
            unit.setWeapon(weaponService.setWeapon(job, 1));
        }
        unit.setAttack(unit.getAttack() + unit.getWeapon().getAttack());
        unit.setAttack(unit.getDistance() + unit.getWeapon().getDistance());
        System.out.println("당신은 " + unit.getWeapon().getName() + "을(를) 장착했습니다.");
        System.out.println("사거리가 " + unit.getWeapon().getDistance() + " 증가했습니다.");
        System.out.println("공격력이 " + unit.getWeapon().getAttack() + " 증가했습니다.");
    }

    public void fightView(int random) {
        if (random >= 7) {

            System.out.println("      /\\              /\\                   ");
            System.out.println("     /  \\ -----------/  \\                  ");
            System.out.println("   (                     )                   ");
            System.out.println("   (      \\     /        )                  ");
            System.out.println("   (     ㅇ      ㅇ      )                   ");
            System.out.println("    (        ㅈ         )                    ");
            System.out.println("     (                )                      ");
            System.out.println("       (            )                        ");
            System.out.println("       / (        )  \\                      ");
            System.out.println("      /  (        )    \\                    ");
            System.out.println("     /   (        )      \\                  ");
            System.out.println("         (        )                          ");
            System.out.println("----------------------------------           ");
            System.out.println("몬스터가 등장했습니다.");
            int distance = unit.getDistance();

            MonsterService monsterService = new MonsterService();
            Monster monster = monsterService.setMonster();
            boolean check = true;// 몬스터 생존 확인
            boolean skillYN = false; //궁극기 사용 여부
            boolean monsterAttack = true; //몬스터 공격 가능 여부 (false면 무적상태)
            int count = 0;
            int skillStart = 0;
            Character character2 = new Character();//복사용


            do {
                System.out.println("\n\n\n==============나차례=============");
                System.out.println("0. 내거 볼래");
                System.out.println("1. 공격");
                System.out.println("2. 스킬 사용");
                if(unit.getLevel() >= 99) System.out.println("3. 궁극기 사용");
                System.out.println("=================================");
                num = sc.nextInt();
                int cnt = 0;

                if (num == 0) {
                    System.out.println(unit.toString());
                    continue;
                } else if (num == 1) {
                    cnt++;
                    monster.setHp(monster.getHp() - unit.getAttack());
                    if (cnt >= 100) {
                        unit.getWeapon().setDurability(unit.getWeapon().getDurability() - 1);
                        if (unit.getWeapon().getDurability() == 0) {
                            unit.setAttack(unit.getAttack() - unit.getWeapon().getAttack());
                            unit.setWeapon(null);
                        }
                    }
                } else if (num == 2) {//스킬사용
                    String skill1 = ((Skill) unit.getSkill().get(0)).getName();
                    String skill2 = ((Skill) unit.getSkill().get(1)).getName();
                    String skill3 = ((Skill) unit.getSkill().get(2)).getName();
                    System.out.println("==============================");
                    System.out.println("1. " + skill1 + " 스킬");
                    System.out.println("2. " + skill2 + " 스킬");
                    System.out.println("3. " + skill3 + " 스킬");
                    System.out.println("==============================");
                    num = sc.nextInt();
                    if (num == 1) {//hp증가
                        unit.setHp(unit.getHp() + 30);
                        unit.setMp(unit.getMp() - ((Skill) unit.getSkill().get(0)).getMp());
                        System.out.println(skill1 + "스킬을 사용했습니다. :D");
                        System.out.println("hp : " + unit.getHp());

                    } else if (num == 2) {//방어력20%저하 공격력은 30% 상승
                        unit.setAttack((int) (unit.getAttack() * 1.3));
                        unit.setDefence((int) (unit.getDefence() * 0.8));
                        unit.setMp(unit.getMp() - ((Skill) unit.getSkill().get(1)).getMp());
                        System.out.println(skill2 + "스킬을 사용했습니다. :D");
                        System.out.println("공격력 : " + unit.getAttack());
                        System.out.println("방어력 : " + unit.getDefence());
                    } else if (num == 3) {
                        System.out.println(skill3 + "스킬을 사용했습니다. :D");
                        if (unit.getName() == "사람") {
                            unit.setDefence((int) (unit.getDefence() * 1.5));
                            unit.setMp(unit.getMp() - ((Skill) unit.getSkill().get(2)).getMp());
                            System.out.println("방어력 : " + unit.getDefence());
                        } else if (unit.getName() == "오크") {
                            unit.setAttack((int) (unit.getAttack() * 1.5));
                            unit.setMp(unit.getMp() - ((Skill) unit.getSkill().get(2)).getMp());
                            System.out.println("공격력 : " + unit.getAttack());
                        } else if (unit.getName() == "엘프") {
                            unit.setEvasion((int) (unit.getEvasion() * 1.5));
                            unit.setMp(unit.getMp() - ((Skill) unit.getSkill().get(2)).getMp());
                            System.out.println("회피력 : " + unit.getEvasion());
                        }
                    }
                } else if (num == 3) { //궁극기 사용
//                    if(skill4!=null)
                    skillYN=true;
                    Skill skill4 = (Skill) unit.getSkill().get(3);
                    if (unit.getMp() - skill4.getMp() < 0) continue;
                    skillYN = true;
                    character2 = unit;
                    skillStart = count + skill4.getTime();
                    unit.setMp(unit.getMp() - skill4.getMp());
                    if (unit.getJob() == "전사") { //무적
                        monsterAttack=false;
                    } else if (unit.getJob() == "마법사") { //메테오
                        unit.setDistance(30);
                        unit.setAttack(1000);
                    } else if (unit.getJob() == "돌격병") { //공격력 5배
                        unit.setAttack(unit.getAttack()*5);
                    } else if (unit.getJob() == "흑마술사") { //포이즌
                        unit.setDistance(30);
                        unit.setAttack(1000);
                    } else if (unit.getJob() == "궁수") { //활 50발
                        unit.setAttack(unit.getAttack()*50);
                    }else if (unit.getJob() == "힐러") { //나 치유
                        unit.setHp(unit.getHp()*5);
                    }
                        System.out.println(skill4.getName() + "스킬을 사용했습니다. :D");
                }

                distance--;
                count++;

                if (monster.getHp() <= 0) {
                    System.out.println("몬스터가 죽었습니다!!ㅇ0ㅇ");
                    unit.setExperience(unit.getExperience() + monster.getExperience());
                    unit = characterService.levelUp(unit);
                    check = false;
                } else {
                    System.out.println("몬스터 Hp : " + monster.getHp());
                    if (distance <= monster.getDistance()) {
                        System.out.println("\n\n\n==============너차례=============");
                        check = true;
                        //몬스터공격
                        System.out.println("몬스터가 공격했습니다!!ㄷㄷㄷ");
                        count++;
                        if(monsterAttack) unit.setHp(unit.getHp() - (monster.getAttack() - (int) (unit.getDefence() * 0.1)));
                    }
                    System.out.println("user Hp : " + (unit.getHp() <=0 ? 0:unit.getHp()));
                    System.out.println("================================");
                    unit = characterService.byebye(unit);
                    if(unit == null){ check=false; System.out.println("************GAME OVER!!!************");System.exit(0);}
                }
                if (count - skillStart >= 0 && skillYN){//궁극기 종료
                    skillYN=false;
                    monsterAttack=true;
                    if(unit.getJob()!="힐러") {
                        unit = character2;
                    }
                }
            } while (check);

        }
    }
}
