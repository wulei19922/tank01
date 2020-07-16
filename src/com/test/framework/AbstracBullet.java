package com.test.framework;

import com.test.res.TankLoadRsourceCatch;
import com.test.tank.FaceDir;
import com.test.tank.RoleType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public  abstract  class AbstracBullet implements Collion {
     
     public  int x ,y,width,height,length,speed;
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
     
     
     
     //是否击中
     @Override
     public   boolean  check(AbstrackTank abstrackTank,AbstracBullet bu){


          if (bu.x > abstrackTank.x && bu.x < abstrackTank.x + abstrackTank.width &&
                  bu.y> abstrackTank.y && bu.y < abstrackTank.y + abstrackTank.height
          ) {
              
              return  true;
             

          }else{
               
          return  false;
          }
          
          
          
     };
     

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
