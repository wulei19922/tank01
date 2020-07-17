package com.test.framework;

import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;
import com.test.tank.enemy.SuperFireBullet;
import com.test.tank.team.BulletPeace;
import com.test.tank.team.TeamTank;

import java.util.ArrayList;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public   class TeamFactory extends GameFactory {


 

    @Override
    public AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir, int length, int speed) {
       
       //队友用的和平子弹
        return new BulletPeace(x,y,width,height,faceDir,length,speed); 
    }

    @Override
    public AbstrackTank createTank(int x, int y, int width, int height, FaceDir faceDir) {
        
        return new TeamTank("teamtak", RoleTypeEnum.TEAMER,x,y,width,height,faceDir);
    }

    
    
    @Override
    public AbstrackBarrier createBarrier(int x, int y, int width, int height, FaceDir faceDir) {
        return null;
    }


    //    @Override
    public AbstracBullet createBullet(String name ,int x, int y, int width, int height, FaceDir faceDir, int length, int speed,int  type) {

        //超级子弹
        return new SuperFireBullet(name,x,y,width,height,faceDir,length,speed);
    }
    
}
