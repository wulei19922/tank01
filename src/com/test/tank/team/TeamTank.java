package com.test.tank.team;

import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.tank.*;

import java.awt.*;
import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public class TeamTank extends AbstrackTank {


    public TeamTank(List<AbstracBullet> list, String tankName, RoleType roleType, int x, int y, int width, int height, FaceDir faceDir) {
        super(list, tankName, roleType, x, y, width, height, faceDir);
    }
}
    
    
