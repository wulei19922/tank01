package com.test.tank;

import com.test.audio.Audio;
import com.test.audio.AuditType;
import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.framework.TeamFactory;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.RoleTypeEnum;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/16
 **/
public class MainTank extends AbstrackTank {


    
    

    public MainTank(String tankName, RoleTypeEnum roleTypeEnum, int x, int y, int width, int height, FaceDir faceDir) {
        super(tankName, roleTypeEnum, x, y, width, height, faceDir);
    }


    




}
