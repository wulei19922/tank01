package com.test.framework;

import com.test.tank.FaceDir;
import com.test.tank.RoleType;
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
public class TeamFactory extends GameFactory {


 

    @Override
    public AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir, int length, int speed) {
       
       //队友用的和平子弹
        return new BulletPeace(x,y,width,height,faceDir,length,speed); 
    }

    @Override
    public AbstrackTank createTank(int x, int y, int width, int height, FaceDir faceDir) {
        
        return new TeamTank(new ArrayList<>(),"teamtak", RoleType.TEAMER,x,y,width,height,faceDir);
    }


//    @Override
    public AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir, int length, int speed,int  type) {

        //超级子弹
        return new SuperFireBullet(x,y,width,height,faceDir,length,speed);
    }
    
}
