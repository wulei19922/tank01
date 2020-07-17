package com.test.res;

import com.test.framework.AbstrackBarrier;
import com.test.framework.GameObject;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/17
 **/
public class Wall  extends AbstrackBarrier {


    public Wall(String tankName, RoleTypeEnum roleTypeEnum, int x, int y, int width, int height, FaceDir faceDir) {
        super(tankName, roleTypeEnum, x, y, width, height, faceDir);
    }
}
