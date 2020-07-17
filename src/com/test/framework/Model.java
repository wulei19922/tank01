package com.test.framework;


import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/16
 **/
public class Model  {



    public  static  final  Model model=new Model(null);
    
    List<GameObject> gameObjects=new LinkedList<>();


    public Model(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }
    
    

    
    
    

    public void paint(Graphics graphics) {

        gameObjects.forEach(tem->{
            tem.paint(graphics);
        });
        
    }
}
