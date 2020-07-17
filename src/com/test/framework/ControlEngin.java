package com.test.framework;

import com.test.audio.Audio;
import com.test.audio.AuditType;
import com.test.tank.Collision;
import com.test.tank.dir.FaceDir;
import com.test.tank.state.TankStateEnum;
import com.test.textshow.ScorBord;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.util.stream.Collectors;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/14
 **/
public class ControlEngin extends Frame {
    static final int GAME_WIDTH = 1440;
    static final int GAME_HEIGHT = 900;
    FaceDir faceDir = FaceDir.UP;

    //渲染模型
    List<GameObject> gameObjects = new ArrayList<>();


    GameObject m = null;


    //ScorBord
    ScorBord bord = new ScorBord();


    public ControlEngin(List<GameObject> gameObjects) {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Game");
        setVisible(true);
        bord.setEnemy(0);
        bord.setScore(0);

        this.gameObjects = gameObjects;
        m = gameObjects.stream().filter(tem -> tem.name.equals("主战坦克")).collect(Collectors.toList()).get(0);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new ActionListener());
        
        
        //启动一个线程 检查输入
        
        
        new Thread(()->{
            
            while (true){
                try {
                    Thread.sleep(100);
                    hit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                
            }

            //每次渲染一次 检查对象是否已经四方

        }).start();


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
        
        
        gameObjects.forEach(tem -> {
            tem.paint(g);
        });
        

    }

    

    
    //碰撞检测
    public void hit() {

        gameObjects.forEach(tem->{
            gameObjects.forEach(tem1->{
                if(tem.name.equals(tem1.name))
                    return;
                
                boolean b = new Collision().checkCollsionWith(tem, tem1);
              
                if(b){
                    tem.tankStateEnum=TankStateEnum.DIED;
                }
                

            });
            
        });
        gameObjects= gameObjects.stream().filter(tem -> tem.tankStateEnum == TankStateEnum.LIFE).collect(Collectors.toList());



    }


    boolean up = false, down = false, left = false, right = false;

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
        int scal_x = 0;
        int scal_y = 0;

        if (up) {
            faceDir = FaceDir.UP;
            scal_x = 0;
            scal_y = -1;
        }
        ;
        if (down) {
            faceDir = FaceDir.DOWN;
            scal_x = 0;
            scal_y = 1;
        }
        ;
        if (left) {
            faceDir = FaceDir.LEFT;
            scal_x = -1;
            scal_y = 0;
        }
        ;
        if (right) {
            faceDir = FaceDir.RIGHT;
            scal_x = 1;
            scal_y = 0;
        }


        m.x = m.x + scal_x * m.speed;
        m.y = m.y + scal_y * m.speed;
        
        m.faceDir=faceDir;


    }


    public void fire(FaceDir faceDir) {

        AbstracBullet b = new TeamFactory().createBullet(m.name,m.x, m.y, m.width, m.height, faceDir, 500, 20, 2);
      
        //计算炮口位置
        switch (faceDir) {
            case UP:
                b.x = m.x + m.width / 3;
                b.y = m.y;
                break;
            case DOWN:
                b.x = m.x + m.width / 3;
                b.y = m.y + m.height;
                break;
            case LEFT:
                b.x = m.x;
                b.y = m.y + m.height / 3;
                break;
            case RIGHT:
                b.x = m.x + m.width / 3;
                b.y = m.y + m.height / 3;
                break;


        }

        gameObjects.add(b);

        new Thread(() -> {

            new Audio().play(AuditType.FIRE);
        }).start();

    }


}
