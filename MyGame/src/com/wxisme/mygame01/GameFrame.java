package com.wxisme.mygame01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/*
 * 需要改进的地方： 在飞机被击毁后发出的子弹应该保留，   添加发散子弹的敌机.解决这些问题需要代码重构。
 */

/**
 * 游戏窗口类，加载游戏窗口
 * @author wxisme
 * @version 1.0
 * 
 */          
@SuppressWarnings("serial")
public class GameFrame extends MyFrame {
	Image bgimg = GameTools.getImage("images/bg.jpg");
	
	Plane p1 = new Plane("images/plane.png", Constant.WINDOW_WEIGHT/2, Constant.WINDOW_HIGHT);
	ArrayList<Plane> enemyPlane = new ArrayList<>();
	int count = 0, planeCount = 0;
	boolean isFirstBullet = true, isFirstInit = true, isFirstEx = true;
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	public static Date startTime, endingTime;
	long liveTime = 0;
	Explode ex;
	Blood b = new Blood();
	Information info;
	int hitEnemyCnt, hitFriendCnt, bulletCnt, score, hScore;
	ArrayList<Integer> rand = new ArrayList<>();
	
	public int hitCount = 0;
	
	public GameFrame() {}

	//初始化飞机
	public void initEnemyPlane() {
//		if(enemyPlane.size()!=0)
//			enemyPlane.clear(); 
		if(isFirstInit) {
			for(int i=1; i<=9; i++) {
				rand.add(i);
			}
			isFirstInit = false;
		}
		Collections.shuffle(rand);//打乱顺序
		for(int i=4; i<7; i++) {
			String pPath = "images/p" + rand.get(i) +".png";
			int eX = rand.get(i) * 130 - 50;
			int eY = rand.get(i) * 20;
			enemyPlane.add(new Plane(pPath, eX, eY));
			if(enemyPlane.size() % 15 == 0) {
				enemyPlane.add(new Plane("images/f1.png", rand.get(1)*130-50, rand.get(1)*20, true));
			}
			planeCount ++;             
		}
		if(planeCount % 200 == 0) {
			for(int i=0; i<180; i++) {
				enemyPlane.remove(i);
			}
		}
	}
	//画飞机
	public void paint(Graphics g) {
		g.drawImage(bgimg, 0, 0 , null);
		p1.draw(g);
		b.drawBorder(g);
		Date enemyGap = new Date();
		long gap = (enemyGap.getTime() - startTime.getTime());
		if(isFirstBullet || gap % 4000 >= 3950) {
			initEnemyPlane();
			isFirstBullet = false;
		}
		
		for(int i=0; i<enemyPlane.size(); i++) {
			Plane p = enemyPlane.get(i);
			p.drawEnemy(g); 
			p1.isCrash(p);
			if(!p1.isLive() && p1.isBulletHit()) {
				hitCount ++;
				//System.out.println(hitCount);
				if(hitCount < Constant.RESIST_POWER * 43) {
					p1.setLive(true);
					p1.setBlood(p1.getBlood() - 1);
				}
				p1.setBulletHit(false);
			}
			
			p.isCrash(p1);
	    }

		for(int i=0; i<enemyPlane.size(); i++) {
//			System.out.println("enemy Live " + enemyPlane.get(i).isLive());
//			System.out.println("my plane live " + p1.isLive());
			Plane p = enemyPlane.get(i);
			if(!p.isLive()) {
				if(p.getExplode() == null)
					p.setExplode(new Explode(p.x, p.y));
				p.getExplode().draw(g);
			    if(p.explode.getCount() == 16) {
			    	if(p.isFriend()) {
			    		hitFriendCnt ++;
			    	} else {
			    		hitEnemyCnt ++;
			    	}
			    	enemyPlane.remove(i);
			    }
				//System.out.println("peng!+++++++++++++++++++");
			}
		} 
		
		if(!p1.isLive()) {
			if(p1.getExplode() == null)
				p1.setExplode(new Explode(p1.x, p1.y));
			if(p1.explode.getCount() <= 15)
				p1.getExplode().draw(g);
			if(p1.explode.getCount() == 16) {
		    	p1 = new Plane();
		    	p1.setExplode(new Explode(0, 0));
		    	p1.explode.setCount(17);
			}
			isFirstEx = false;
			//System.out.println("duang!+++++++++++++++++++"); 
		}
		
		
		if(count == 0) {
			endingTime = new Date();
			liveTime = (endingTime.getTime() - startTime.getTime()) / 1000;
		}
		info.setLiveTime(liveTime);
		info.printing(g);
		if(p1.getSpaceCnt() != 0) {
			bulletCnt = p1.getSpaceCnt();
			info.setBulletCnt(bulletCnt);
		}
		//System.out.println(bulletCnt);
		if(!p1.isLive()) {
			count ++;
//			bulletCnt = p1.getSpaceCnt();
//			info.setBulletCnt(bulletCnt);
			info.setHitEnemyCnt(hitEnemyCnt);
			info.setHitFriendCnt(hitFriendCnt);
			score = (int)liveTime*50 + hitEnemyCnt * 50 - hitFriendCnt*30 - bulletCnt*2;
			info.setScore(score);
			info.printed(g);
			enemyPlane.clear();
			
		}
	}
	
	public Information getInfo() {
		return info;
	}

	public void setInfo(Information info) {
		this.info = info;
	}

	public void launchFrame() {
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyCtrl());
		startTime = new Date();
	}
	
	class KeyCtrl extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			p1.checkedDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p1.uncheckedDirection(e);
		}
	}
	
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		Information info = new Information("wx");
		gf.setInfo(info);
		gf.launchFrame();
	}
}
