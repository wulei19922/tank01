package com.test.tank.enemy;

import com.test.framework.AbstracBullet;
import com.test.res.TankLoadRsourceCatch;
import com.test.tank.FaceDir;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Desc:
 *02型穿甲弹
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class Bullet_02  extends AbstracBullet  {


    public Bullet_02(int x, int y, int width, int height, FaceDir faceDir, int length, int speed) {
        super(x, y, width, height, faceDir, length, speed);
    }

    @Override
    public void paint(Graphics g) {
        
        length-=speed;

        if(length<=0){

            return;
        }

        BufferedImage image=null;

        switch (faceDir){
            case UP:y-=speed; image= TankLoadRsourceCatch.BL_U;break;
            case DOWN:y+=speed;image= TankLoadRsourceCatch.BL_D;break;
            case LEFT:x-=speed; image= TankLoadRsourceCatch.BL_L; break;
            case RIGHT: x+=speed; image= TankLoadRsourceCatch.BL_R;break;
            default: image= TankLoadRsourceCatch.BL_U;break;
        }


        //调节子弹位置


        g.drawImage(image,x,y,null);



    }
    
    
}
