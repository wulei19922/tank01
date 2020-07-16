package com.test.tank;


import com.test.framework.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public class StartService {


    public static void main(String[] args) throws InterruptedException {

        int width = 50;
        int height = 50;
        List<AbstrackTank> life = new ArrayList<AbstrackTank>();

        GameFactory factory = new EnemyFactory();
        GameFactory teamFactory = new TeamFactory();


        for (int i = 0; i < 5; i++) {
            AbstrackTank tank = factory.createTank(getPosition(800), getPosition(600), width, height, FaceDir.DOWN);
            life.add(tank);

        }


        for (int i = 0; i < 5; i++) {
            AbstrackTank teams = teamFactory.createTank(getPosition(800), getPosition(600), width, height, FaceDir.DOWN);
            life.add(teams);

        }

        AbstrackTank player = teamFactory.createTank(getPosition(800), getPosition(600), width, height, FaceDir.DOWN);
             player.roleType = RoleType.SELF;
             life.add(player);


        //启动迎请
        ControlEngin tankFrame = new ControlEngin(life);
        tankFrame.addSystem();


        //启动一个线程 没100ms更改一次位置

        new Thread(() -> {


            int count = 0;

            //每10次换方向

            while (true) {
                try {
                    Thread.sleep(500);
                    count++;

                    int finalCount = count;
                    tankFrame.tankroles.stream().forEach(tem -> {


                        if (tem.roleType == RoleType.SELF) {
                            return;
                        }


                        AbstrackTank tem1 = tem;

                        ;

                        if (new Random().nextInt(10) % 2 == 0) {
                            tem1.x = tem1.x + (new Random().nextInt(3) - 1) * 5;

                        } else {

                            tem1.y = tem1.y + (new Random().nextInt(3) - 1) * 5;

                        }


                        tem1.list.add(factory.createBullet(tem1.x, tem1.y, tem1.width, tem1.height, tem1.faceDir, 500, 20));

                        if (finalCount % 10 == 0) {
                            for (FaceDir c : FaceDir.values()) {
                                tem1.faceDir = c.getFaceDir(new Random().nextInt(4));
                            }
                            ;
                        }


                    });


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();


        while (true) {

            Thread.sleep(100);
            tankFrame.repaint();
        }


    }


    public static int getPosition(int length) {


        return new Random().nextInt(length);
    }
}
