package com.test.framework;

import com.test.tank.dir.FaceDir;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public  abstract   class GameFactory    {



    public abstract AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir, int length, int speed);

    public  abstract  AbstrackTank   createTank(int x, int y, int width, int height, FaceDir faceDir);
    
    public  abstract  AbstrackBarrier createBarrier(int x, int y, int width, int height, FaceDir faceDir);
    
}
