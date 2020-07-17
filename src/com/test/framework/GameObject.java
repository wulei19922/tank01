package com.test.framework;

import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;
import com.test.tank.state.TankStateEnum;

import java.awt.*;


/***
 * 渲染顶级接口
 */
public  abstract  class GameObject  {
    
    public   int x,y,width,height,speed;
    public FaceDir faceDir;
    
    public TankStateEnum tankStateEnum= TankStateEnum.LIFE;
    public String name;
    public abstract   void paint(Graphics graphics);


   
}
