package com.test.tank;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public enum  FaceDir {
    
    
    LEFT(0),RIGHT(1),UP(2),DOWN(3);

    private  int  code;
    
         FaceDir(int i) {
        this.code=i;
    }
    
    
    
    public  FaceDir getFaceDir(int c){
        
        switch (c){
            case 0: return FaceDir.LEFT;
            case 1:return FaceDir.RIGHT;
            case 2:return FaceDir.UP;
            case 3:return  FaceDir.DOWN;
            default: return FaceDir.DOWN;
            
        }
        
        
        
        
    }
}
