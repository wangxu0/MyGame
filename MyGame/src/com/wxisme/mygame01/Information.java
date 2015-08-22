package com.wxisme.mygame01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 玩家游戏信息类
 * @author wxisme
 *
 */
public class Information {
	private String name;
	private int hitEnemyCnt, hitFriendCnt, bulletCnt, score, hScore;
	private long liveTime;
	public Information(String name) {
		this.name = name;
		this.hitEnemyCnt = 0;
		this.bulletCnt = 0;
		this.hitFriendCnt = 0;
		this.score = 0;
		this.hScore = 56010;
		this.liveTime = 0;
	}
	
	//击落敌机数量、误击客机数量、生存时间、弹药使用数量、总得分、历史最高分。
	
	public void printing(Graphics g) {
		Font f3 = new Font("幼圆", Font.BOLD, 20);
		printInfo(g, "生命值:", 800, 70, Color.red, f3);
		printInfo(g, "生存时间：    " + this.liveTime + "秒 ", 800, 100, Color.red, f3);
	}
	
	public void printed(Graphics g) {
		Font f1 = new Font("幼圆", Font.BOLD, 50);
		Font f2 = new Font("幼圆", Font.BOLD, 25);
		printInfo(g, "GAME OVER!", 450, 200, Color.red, f1);
		printInfo(g, "生存时间：" + this.liveTime + "秒 ",        450, 250, Color.blue, f2);
		//printInfo(g, "敌机总数：" + this.liveTime + "秒 ",        450, 250, Color.blue, f2);
		printInfo(g, "击落敌机数量：" + this.hitEnemyCnt + "架 ",  450, 290, Color.blue, f2);
		printInfo(g, "误击客机数量：" + this.hitFriendCnt + "架 ", 450, 330, Color.blue, f2);
		printInfo(g, "弹药使用数量：" + this.bulletCnt + "颗 ",    450, 370, Color.blue, f2);
		printInfo(g, "总得分：" + this.score + "分 ",            450, 410, Color.blue, f2);
		printInfo(g, "历史最高分：" + this.hScore + "分 ",        450, 450, Color.blue, f2);
		
	}
	
	
	public void printInfo(Graphics g, String str, int x, int y, Color c, Font f) {
		Color cc = g.getColor();
		g.setColor(c);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(cc);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHitEnemyCnt() {
		return hitEnemyCnt;
	}
	public void setHitEnemyCnt(int hitEnemyCnt) {
		this.hitEnemyCnt = hitEnemyCnt;
	}
	public int getHitFriendCnt() {
		return hitFriendCnt;
	}
	public void setHitFriendCnt(int hitFriendCnt) {
		this.hitFriendCnt = hitFriendCnt;
	}
	public int getBulletCnt() {
		return bulletCnt;
	}
	public void setBulletCnt(int bulletCnt) {
		this.bulletCnt = bulletCnt;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int gethScore() {
		return hScore;
	}
	public void sethScore(int hScore) {
		this.hScore = hScore;
	}
	public long getLiveTime() {
		return liveTime;
	}
	public void setLiveTime(long liveTime) {
		this.liveTime = liveTime;
	}
	
	
	
	

}
