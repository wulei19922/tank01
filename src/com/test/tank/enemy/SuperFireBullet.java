package com.test.tank.enemy;

import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.res.TankLoadRsourceCatch;
import com.test.tank.dir.FaceDir;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Desc:超级子弹
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class SuperFireBullet extends Bullet_02 {


    List<Bullet_02> list = new ArrayList<>();
    
    public SuperFireBullet(String name,int x, int y, int width, int height, FaceDir faceDir, int length, int speed) {
        super(x, y, width, height, faceDir, length, speed);
        this.name=name;
        list.add(new Bullet_02(x, y, width, height, FaceDir.RIGHT, length, speed));
        list.add(new Bullet_02(x, y, width, height, FaceDir.LEFT, length, speed));
        list.add(new Bullet_02(x, y, width, height, FaceDir.UP, length, speed));
        list.add(new Bullet_02(x, y, width, height, FaceDir.DOWN, length, speed));
        list.forEach(tem->{
            tem.name=name;
        });

    }

    

    @Override
    public void paint(Graphics g) {

        list.forEach(tem -> {
            
            int length = tem.length;
            int speed = tem.speed;
            int x = tem.x;
            int y = tem.y;
            length -= speed;
            FaceDir faceDir = tem.faceDir;

            if (length <= 0) {

                return;
            }

            BufferedImage image = null;

            switch (faceDir) {
                case UP:
                    tem.y -= speed;
                    image = TankLoadRsourceCatch.BL_U;
                    break;
                case DOWN:
                    tem.y += speed;
                    image = TankLoadRsourceCatch.BL_D;
                    break;
                case LEFT:
                    tem.x -= speed;
                    image = TankLoadRsourceCatch.BL_L;
                    break;
                case RIGHT:
                    tem.x += speed;
                    image = TankLoadRsourceCatch.BL_R;
                    break;
                default:
                    image = TankLoadRsourceCatch.BL_U;
                    break;
            }
            //调节子弹位置
            g.drawImage(image, x, y, null);


        });

//        super.paint(g);
    }
}
