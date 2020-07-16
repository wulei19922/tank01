package com.test.framework;

import com.test.tank.FaceDir;
import com.test.tank.enemy.Bullet_02;

import java.awt.*;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public  abstract   class GameFactory    {



    public abstract AbstracBullet createBullet(int x, int y, int width, int height, FaceDir faceDir, int length, int speed);

    public  abstract  AbstrackTank   createTank(int x, int y, int width, int height, FaceDir faceDir);
    
}
