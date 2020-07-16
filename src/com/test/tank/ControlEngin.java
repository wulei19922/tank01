package com.test.tank;

import com.test.audio.Audio;
import com.test.audio.AuditType;
import com.test.framework.AbstracBullet;
import com.test.framework.AbstrackTank;
import com.test.framework.TeamFactory;
import com.test.textshow.ScorBord;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public class ControlEngin extends Frame {
    int x = 0;
    int y = 0;
    int speed = 20;
    static final int GAME_WIDTH = 1440;
    static final int GAME_HEIGHT = 900;
    FaceDir faceDir = FaceDir.UP;
    TankState state = TankState.INVINCIBLE;
    boolean up = false, down = false, left = false, right = false;
   
    //坦克角色
    List<AbstrackTank> tankroles;
    
    
    //爆炸效果
    List<Boom>booms=new ArrayList<>();
    
    
    
    //ScorBord
    ScorBord bord=new ScorBord();
    
    
    public ControlEngin(List<AbstrackTank> enemy) {
        this.tankroles = enemy;
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Game");
        setVisible(true);
        bord.setEnemy(enemy.size());
        bord.setScore(0);
    }


    public boolean addSystem() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new ActionListener());
        return false;
    }

    

    public void fire(FaceDir faceDir) {


        
        List<AbstrackTank> self = tankroles.stream().filter(n -> n.roleType == RoleType.SELF).collect(Collectors.toList());
        AbstrackTank tankStance = self.get(0);

        int x = 0;
        int y = 0;


        //计算炮口位置
        switch (tankStance.faceDir) {

            case UP:
                x = tankStance.x + tankStance.width / 3;
                y = tankStance.y;
                break;
            case DOWN:
                x = tankStance.x + tankStance.width / 3;
                y = tankStance.y + tankStance.height;
                break;
            case LEFT:
                x = tankStance.x;
                y = tankStance.y + tankStance.height / 3;
                break;
            case RIGHT:
                x = tankStance.x + tankStance.width / 3;
                y = tankStance.y + tankStance.height / 3;
                break;


        }
        
        AbstracBullet bullet1 = new TeamFactory().createBullet(tankStance.x,tankStance.y,tankStance.width,tankStance.height,tankStance.faceDir,500,20,2);


        tankStance.list.add(bullet1);
            
        new Thread(()->{

            new Audio().play(AuditType.FIRE);
        }).start();

//        bulletList.add();
    }


    Image offScreenImage = null;

    Graphics goff = null;


    @Override
    public void update(Graphics g) {
        if (null == offScreenImage) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics goff = offScreenImage.getGraphics();
        paint(goff);
        goff.setColor(Color.BLACK);
        g.drawImage(offScreenImage, 0, 0, null);
        goff.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

    }


    @Override
    public void paint(Graphics g) {

        //遍历所有玩家
        this.tankroles.forEach(n -> {

            if (n.roleType == RoleType.SELF) {
                n.faceDir = faceDir;
                n.faceDir= faceDir;
                n.paint(g);
                n.list.forEach(tem -> {
                    tem.paint(g);
                });
            } else {
                n.paint(g);
                n.list.forEach(tem -> {
                    tem.paint(g);
                });

            }


        });


        //检查存活对象
        hit();


        //渲染爆炸效果

        booms.stream().forEach(tem->{
            tem.paint(g);
           new Thread(()->{

               new Audio().play(AuditType.HIT);
           }).start();
        });
        
        booms=new ArrayList<>();
        
        
        
        //回执积分办
        bord.paint(g);


    }


    public void hit() {

        //检测当期系统中被击中对象

        tankroles.forEach(e -> {

            int x = e.x;
            int y = e.y;
            int width = e.width;
            int height = e.height;
            AtomicBoolean live = new AtomicBoolean(false);//默认死亡

            tankroles.forEach(e2 -> {
                if(e.roleType==e2.roleType)return;
                e2.list.forEach(bu -> {
                    if(bu.check(e,bu)){
                        live.set(true);
                    }
                });

            });
            if (live.get()) {
                e.tankState = TankState.DIED;
                int socr =bord.getScore();
                int enemy =bord.getEnemy();
                bord.setScore(socr+1);
                bord.setEnemy(enemy-1);


                System.out.println(bord.getScore());
                //当前玩家死亡 加入爆炸效果

//                booms.add(new Boom(e.getTankStance().x,e.getTankStance().y));
                booms.add(new Boom(e.x-e.width/2,e.y-e.height/2));
            }

            //检查子弹


            List<AbstracBullet> collect = e.list.stream().filter(n -> {
                //如果当前子弹的非常长度为0 那么销毁该子弹
                if (n.length <= 0) {

                    return false;

                } else {
                    return true;
                }


            }).collect(Collectors.toList());

            //过滤子弹
            e.list=collect;


        });

        List<AbstrackTank> live = tankroles.stream().filter(n -> {
            return n.tankState != TankState.DIED;
        }).collect(Collectors.toList());

        tankroles = live;
        //标志游戏结束
        
        
        //碰撞


    }


    class ActionListener extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {


            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_UP:
                    up = true;
                    break;
                case KeyEvent.VK_DOWN:
                    down = true;
                    break;
                case KeyEvent.VK_SPACE:
                    fire(faceDir);
                    break;
                default:
                    break;
            }


            setTankDir();


        }

        @Override
        public void keyReleased(KeyEvent e) {
            left = false;
            up = false;
            right = false;
            down = false;
        }


    }


    private void setTankDir() {
        int scal_x=0;
        int scal_y=0;

        if (up) {
            faceDir = FaceDir.UP;
            scal_x=0;
            scal_y=-1;
        }
        ;
        if (down) {
            faceDir = FaceDir.DOWN;
            scal_x=0;
            scal_y=1;
        }
        ;
        if (left) {
            faceDir = FaceDir.LEFT;
            scal_x=-1;
            scal_y=0;
        }
        ;
        if (right) {
            faceDir = FaceDir.RIGHT;
            scal_x=1;
            scal_y=0;
        }


        List<AbstrackTank> collect = tankroles.stream().filter(n -> n.roleType == RoleType.SELF).collect(Collectors.toList());
        AbstrackTank se=collect.get(0);
            se.x= se.x+scal_x*se.speed;
            se.y=se.y+scal_y*se.speed;
      
        
        
        
        
    }
}
