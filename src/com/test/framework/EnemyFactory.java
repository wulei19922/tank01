package com.test.framework;

import com.test.tank.FaceDir;
import com.test.tank.RoleType;
import com.test.tank.enemy.Bullet_02;
import com.test.tank.enemy.RedTiggerTank;

import java.awt.*;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class EnemyFactory extends  GameFactory {


    
    
    @Override
    public AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir,int length,int speed) {

        return   new Bullet_02(x,y,width,height,faceDir,length,speed);
    }
    
    
    
    @Override
    public AbstrackTank createTank(int x, int y, int width, int height, FaceDir faceDir) {
        
        
        
        return new RedTiggerTank(null,"red_tiger", RoleType.ENEMY,x,y,width,height,faceDir);
    }


   
}
