package com.test.tank;

import com.test.res.TankLoadRsourceCatch;
import com.test.tank.dir.FaceDir;
import com.test.tank.dir.MoveDir;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class Boom {

    private  int x,y;

    MoveDir dir= MoveDir.STAND;
    FaceDir faceDir;
    
    
    public Boom(int x,int y ){
        this.x=x;
        this.y=y;
    }


    
    //爆炸声音
    public  void  playBoom(){
        
        
    }

    public void paint(Graphics g) {


        BufferedImage boom = TankLoadRsourceCatch.BOOM;
        //调节子弹位置
        g.setColor(Color.BLUE);
        g.drawImage(boom,x,y,null);





    }

    
    
    
    
    
}
