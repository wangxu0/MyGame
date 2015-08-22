package com.wxisme.mygame01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * 飞机类
 * @author wxisme
 *
 */

public class Plane {
	Image img;
	double x, y;
	boolean left, right, up, down, space, isFriend;
	int spaceCnt = 0;
	boolean live = true;
	int width, hight;
	Explode explode = null;
	private Blood blood = new Blood();
	ArrayList<Bullet> bullet = new ArrayList<>();
	
	public Plane(String imgpath, double x, double y) {
		super();
		this.img = GameTools.getImage(imgpath);
		this.width = img.getWidth(null);
		this.hight = img.getHeight(null);
		this.x = x - this.width/2;
		this.y = y - this.hight;
	}
	
	public Plane(String imgpath, double x, double y, boolean isFriend) {
		super();
		this.img = GameTools.getImage(imgpath);
		this.width = img.getWidth(null);
		this.hight = img.getHeight(null);
		this.x = x - this.width/2;
		this.y = y - this.hight;
		this.isFriend = isFriend;
	}
	
	public Plane() {
		this.x = -1;
		this.live = false;
	}
	//画我方飞机
	public void draw(Graphics g) {
		if(this.x != -1) {
			g.drawImage(img, (int)x, (int)y, null);
			move();
			this.blood.drawBlood(g);//生命值
			for(int i=0; i<bullet.size(); i++) {
			bullet.get(i).draw(g);
			}
		}
	}
	//画敌方飞机
	public void drawEnemy(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		moveEnemy();
		if(!this.isFriend) {
			Date bulletGap = new Date();
			long gap = ((bulletGap.getTime() - GameFrame.startTime.getTime()));
			if(gap % 3000 <= 50 || gap % 3000 >= 2950) {
				this.bullet.add(new Bullet(this.x, this.y+this.hight, this.width));
			}
//			System.out.println("size" + " " + this.bullet.size());
//			System.out.println("gap " + gap);
			for(int i=0; i<this.bullet.size(); i++) {
				this.bullet.get(i).drawEnemy(g);
				//break;
			}
		}
	}
	
	private boolean bulletHit;
	public boolean isBulletHit() {
		return bulletHit;
	}

	public void setBulletHit(boolean bulletHit) {
		this.bulletHit = bulletHit;
	}

	//碰撞检测
	public void isCrash(Plane p) {
		boolean isIntersect = false;
		//遍历子弹  判断子弹和飞机是否碰撞
		for(int i=0; i<p.bullet.size(); i++) {
			isIntersect = p.bullet.get(i).getRect().intersects(this.getRect());
			if(isIntersect) {
				this.bulletHit = true;
				this.setLive(false);
				break;
			}
		}
		//判断飞机和飞机是否碰撞
		if(p.getRect().intersects(this.getRect())) {
			p.setLive(false);
			this.setLive(false);
		}
		
	}
    
	
	
	
	public void move()  {
		if(left) {
			if(x > 8)
				x -= Constant.PLANE_SPEED;
		}
		if(right) {
			if(x < Constant.WINDOW_WEIGHT - 120)
				x += Constant.PLANE_SPEED;
		}
		if(up) {
			if(y > 25)
				y -= Constant.PLANE_SPEED;
		}
		if(down) {
			if(y < Constant.WINDOW_HIGHT - 105)
				y += Constant.PLANE_SPEED;
		}

	}
	
	public void moveEnemy() {
		//x = x;
		y += Constant.ENEMYPLANE_SPEED;
	}
	
	public void checkedDirection(KeyEvent e) {
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
			bullet.add(new Bullet(this.x, this.y, this.width));
			space = true;
			spaceCnt ++;
			//System.out.println(spaceCnt);
			break;
		default:
			break;
		}
	}
	
	//监听键盘操作  空格为发射子弹
	public void uncheckedDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_SPACE:
			space = false;
			break;
		default:
			break;
		}
	}
	

	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, width, hight);
	}

	
	public int getBlood() {
		return this.blood.getLength();
	}

	public void setBlood(int length) {
		this.blood.setLength(length);
	}

	public Image getImg() {
		return img;
	}


	public void setImg(Image img) {
		this.img = img;
	}


	public boolean isFriend() {
		return isFriend;
	}

	public Explode getExplode() {
		return explode;
	}


	public void setExplode(Explode e) {
		this.explode = e;
	}
	
	public int getSpaceCnt() {
		return this.spaceCnt;
	}

	public void setSpaceCnt(int spaceCnt) {
		this.spaceCnt = spaceCnt;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}