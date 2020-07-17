package com.test.tank.enemy;

import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;

import java.util.List;

/**
 * Desc:
 *          红虎主战坦克
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class RedTiggerTank extends AbstrackTank {


    public RedTiggerTank(String tankName, RoleTypeEnum roleTypeEnum, int x, int y, int width, int height, FaceDir faceDir) {
        super(tankName, roleTypeEnum, x, y, width, height, faceDir);
    }
}
