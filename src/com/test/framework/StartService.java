package com.test.framework;


import com.test.framework.*;
import com.test.res.mapresource.MapInfo;
import com.test.tank.MainTank;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;

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

        MapInfo mapInfo=new  MapInfo().setHeiht(0).setName("demo");
        
        
        

        int width = 50;
        int height = 50;
        List<GameObject> life = new ArrayList<GameObject>();

        GameFactory factory = new EnemyFactory();
        GameFactory teamFactory = new TeamFactory();


        
        //敌人实例化
        for (int i = 0; i < 5; i++) {
            GameObject tank = factory.createTank(getPosition(1440), getPosition(1440), width, height, FaceDir.DOWN);
            tank.name="Enemy"+i;

            life.add(tank);
        }

        //队友实例化
        for (int i = 0; i < 5; i++) {
            GameObject teams = teamFactory.createTank(getPosition(1440), getPosition(900), width, height, FaceDir.DOWN);
            teams.name="Team"+i;
            life.add(teams);

        }

        
        AbstrackTank player = new MainTank("主战坦克",RoleTypeEnum.SELF,getPosition(1440),getPosition(900),width,height,FaceDir.DOWN);
             player.roleTypeEnum = RoleTypeEnum.SELF;
             life.add(player);
             
             
             //加入随机墙

        for (int i = 0; i < 10; i++) {
            
            GameObject gameObject=new BariryFactory().createBarrier(getPosition(1440),getPosition(900),width,height,FaceDir.DOWN);
            life.add(gameObject);
            
        }
        
        
        
        
        

        //启动
        ControlEngin tankFrame = new ControlEngin(life);
//        tankFrame.addSystem();


        //启动一个线程 没100ms更改一次位置




        new Thread(() -> {


            int count = 0;

            //每10次换方向

            while (true) {
                try {
                    Thread.sleep(1000);
                    count++;

                    int finalCount = count;
                    life.stream().forEach(tem -> {


                        if (tem.name.equals("主战坦克") ||"Wall".equals(tem.name)) {
                            return;
                        }


                        GameObject tem1 = tem;


                        if (new Random().nextInt(10) % 2 == 0) {
                            tem1.x = tem1.x + (new Random().nextInt(3) - 1) * 20;

                        } else {

                            tem1.y = tem1.y + (new Random().nextInt(3) - 1) * 20;

                        }



                        if (finalCount % 10 == 0) {

                           int r= new Random().nextInt(4);
                           
                            for (FaceDir c : FaceDir.values()) {
                                tem1.faceDir =  c.getFaceDir(r);
                            };
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
