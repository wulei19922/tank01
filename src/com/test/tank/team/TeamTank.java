package com.test.tank.team;

import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;

import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public class TeamTank extends AbstrackTank {


    
    public TeamTank(String tankName, RoleTypeEnum roleTypeEnum, int x, int y, int width, int height, FaceDir faceDir) {
        super(tankName, roleTypeEnum, x, y, width, height, faceDir);
    }
}
    
    
