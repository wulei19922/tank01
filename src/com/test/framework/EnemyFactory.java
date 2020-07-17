package com.test.framework;

import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;
import com.test.tank.enemy.Bullet_02;
import com.test.tank.enemy.RedTiggerTank;

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
        
        
        
        return new RedTiggerTank("red_tiger", RoleTypeEnum.ENEMY,x,y,width,height,faceDir);
    }

    
    @Override
    public AbstrackBarrier createBarrier(int x, int y, int width, int height, FaceDir faceDir) {
        return null;
    }


}
