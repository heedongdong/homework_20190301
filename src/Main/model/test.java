package model;

import Main.model.service.ViewService;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class test {
    @Test
    public static void main(String args[]) {
        long sum = 10+10;
        assertTrue("참",sum == 20);
        ViewService viewService = new ViewService();
        viewService.mainView();
        while (true) {
            int random = (int)(Math.random()*10);
            System.out.println("몬스터 찾는중.....\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            viewService.setJobView();
            viewService.fightView(random);
        }
    }
}
