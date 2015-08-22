package com.wxisme.mygame01;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.wxisme.mygame01.Constant;

/**
 * 子弹类
 * @author wxisme
 *
 */
public class Bullet {
	double x, y;
	
	public Bullet(double x, double y, int pWidth) {
		this.x = x + pWidth/2 - Constant.BULLET_WEIGHT/2;
		this.y = y;	
	}
	//画我方子弹
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, Constant.BULLET_WEIGHT, Constant.BULLET_HIGHT);
		y -= Constant.BULLET_SPEED;
		g.setColor(c);
	}
	//画敌方子弹
	public void drawEnemy(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, Constant.BULLET_WEIGHT, Constant.BULLET_HIGHT);
		y += Constant.ENEMYPLANE_BULLET_SPEED;
		g.setColor(c);
	}
	
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, Constant.BULLET_WEIGHT, Constant.BULLET_HIGHT);
	}

}
