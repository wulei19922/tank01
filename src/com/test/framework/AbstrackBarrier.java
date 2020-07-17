package com.test.framework;

import com.test.res.TankLoadRsourceCatch;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;
import com.test.tank.state.TankStateEnum;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/


public abstract  class AbstrackBarrier extends GameObject {
    
    
    public TankStateEnum tankState= TankStateEnum.LIFE;
    public RoleTypeEnum
            roleTypeEnum= RoleTypeEnum.BARRIER;
    public AbstrackBarrier(String tankName, RoleTypeEnum roleTypeEnum, int x , int y, int width, int height, FaceDir faceDir){
        this.name=tankName;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.faceDir=faceDir;
        this.speed=0;
    }
    
    
    @Override
    public  void paint(Graphics graphics){

        BufferedImage bufferedImage=TankLoadRsourceCatch.WALL;
//        switch (faceDir){
//            case LEFT:bufferedImage=TankLoadRsourceCatch.TK_L; break;
//            case RIGHT:bufferedImage=TankLoadRsourceCatch.TK_R;break;
//            case UP:bufferedImage=TankLoadRsourceCatch.TK_U;break;
//            case DOWN:bufferedImage=TankLoadRsourceCatch.TK_D;break;
//            
//        }
        graphics.drawImage(bufferedImage,x,y,null);
        
    }


}
