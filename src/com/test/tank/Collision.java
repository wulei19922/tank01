package com.test.tank;

import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.framework.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/16
 **/
public class Collision {
    //
    
    final  static  Collision co=new Collision();
    
    
    List<GameObject> list =new LinkedList<>();


    public static Collision getCo() {
        
        return co;
    }

    public boolean checkCollsionWith(GameObject abstrackTank, GameObject bu) {

        
        //只需要检查坦克可子弹
        
        if(abstrackTank instanceof  AbstrackTank && bu instanceof  AbstracBullet){
            if (bu.x > abstrackTank.x && bu.x < abstrackTank.x + abstrackTank.width &&
                    bu.y> abstrackTank.y && bu.y < abstrackTank.y + abstrackTank.height
            ) {

                return  true;


            }else{

                return  false;
            }
            
        }else  if(abstrackTank instanceof  AbstracBullet  && bu instanceof AbstrackTank ){
            
            checkCollsionWith(bu,abstrackTank);
            
        }else{


            return  false;
        }


        return  false;


    }
    
    
    
    
    
    
    
}
