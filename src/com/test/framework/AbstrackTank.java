package com.test.framework;

import com.test.res.TankLoadRsourceCatch;
import com.test.tank.FaceDir;
import com.test.tank.RoleType;
import com.test.tank.TankState;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/


public abstract  class AbstrackTank {
    public  String tankName="";
    public TankState tankState=TankState.LIFE;
    public  RoleType roleType=RoleType.TEAMER;
    public  List<AbstracBullet> list=new ArrayList<>();
    public  FaceDir faceDir;
    public  int  x,y,width,height,speed;
    
    public AbstrackTank(List<AbstracBullet>list, String tankName, RoleType roleType,int x ,int y,int width,int height,FaceDir faceDir){
        this.tankName=tankName;
        this.roleType=roleType;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.faceDir=faceDir;
        this.speed=20;
    }
    
    
    public  void paint(Graphics graphics){

        BufferedImage bufferedImage=null;
        switch (faceDir){
            case LEFT:bufferedImage=TankLoadRsourceCatch.TK_L; break;
            case RIGHT:bufferedImage=TankLoadRsourceCatch.TK_R;break;
            case UP:bufferedImage=TankLoadRsourceCatch.TK_U;break;
            case DOWN:bufferedImage=TankLoadRsourceCatch.TK_D;break;
            
        }
        
        graphics.drawImage(bufferedImage,x,y,null);
        
        
        
    }


}
