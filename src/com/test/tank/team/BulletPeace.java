package com.test.tank.team;

import com.test.framework.AbstracBullet;
import com.test.res.TankLoadRsourceCatch;
import com.test.tank.FaceDir;
import com.test.tank.MoveDir;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Desc:
 *子弹类
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public class BulletPeace extends AbstracBullet {
    
    private static final  int  speed=15;
    private    int  length=600;
    private  int x,y,tkwidth,tkheight;
    
    MoveDir dir= MoveDir.STAND;
    FaceDir faceDir;

    public BulletPeace(int x, int y, int width, int height, FaceDir faceDir, int length, int speed) {
        super(x, y, width, height, faceDir, length, speed);
    }


    public void paint(Graphics g) {
       
        
        
        super.paint(g);


    }

  
}
