package com.test.tank.enemy;

import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.tank.FaceDir;
import com.test.tank.RoleType;

import java.util.List;

/**
 * Desc:
 *          红虎主战坦克
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class RedTiggerTank extends AbstrackTank {


    public RedTiggerTank(List<AbstracBullet> list, String tankName, RoleType roleType, int x, int y, int width, int height, FaceDir faceDir) {
        super(list, tankName, roleType, x, y, width, height, faceDir);
    }
}
