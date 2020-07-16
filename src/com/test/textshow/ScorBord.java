package com.test.textshow;

import java.awt.*;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/15
 **/
public class ScorBord {
    
   volatile int  score=0;
   volatile  int  enemy=0;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getEnemy() {
        return enemy;
    }

    public void setEnemy(int enemy) {
        this.enemy = enemy;
    }

    public void paint(Graphics g) {
        
        g.setColor(Color.BLACK);
        
        g.drawString("当前分数："+score+" 存活敌人："+enemy,100,100);
        
        
    }
}
