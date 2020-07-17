package com.test.framework;

import com.test.res.Wall;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/17
 **/
public    class BariryFactory extends  GameFactory {


    @Override
    public AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir, int length, int speed) {
        
        
        return null;
    }

    @Override
    public AbstrackTank createTank(int x, int y, int width, int height, FaceDir faceDir) {
        
        
        return null;
    }

    @Override
    public AbstrackBarrier createBarrier(int x, int y, int width, int height, FaceDir faceDir) {
        return new Wall("Wall", RoleTypeEnum.BARRIER,x,y,width,height,faceDir);
    }
}
