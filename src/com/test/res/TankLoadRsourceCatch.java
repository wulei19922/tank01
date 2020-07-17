package com.test.res;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class TankLoadRsourceCatch {


    public static BufferedImage TK_L, TK_R, TK_U, TK_D,BL_L,BL_R,BL_U,BL_D,BOOM,WALL;


    static {
        try {
            TK_L = ImageIO.read(new File(TankResource.TK_LEFT));
            TK_R = ImageIO.read(new File(TankResource.TK_RIGHT));
            TK_U = ImageIO.read(new File(TankResource.TK_UP));
            TK_D = ImageIO.read(new File(TankResource.TK_DOWN));
            
            BL_D = ImageIO.read(new File(TankResource.BU_DOWN));
            BL_U = ImageIO.read(new File(TankResource.TBU_UP));
            BL_L = ImageIO.read(new File(TankResource.BU_LEFT));
            BL_R = ImageIO.read(new File(TankResource.BU_RIGHT));
            BOOM = ImageIO.read(new File(TankResource.BOOM));
            WALL = ImageIO.read(new File(TankResource.WALL));
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
