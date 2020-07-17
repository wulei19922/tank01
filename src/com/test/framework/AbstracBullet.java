package com.test.framework;

import com.test.res.TankLoadRsourceCatch;
import com.test.tank.dir.FaceDir;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public  abstract  class AbstracBullet extends GameObject {
     
     public  int length;
     public FaceDir faceDir;


     public AbstracBullet( int x , int y, int width, int height, FaceDir faceDir,int length,int speed){
          this.x=x;
          this.y=y;
          this.width=width;
          this.height=height;
          this.faceDir=faceDir;
          this.length=length;
          this.speed=speed;
     }
     
     
     @Override
     public  void paint(Graphics g){

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


     };
     
}
