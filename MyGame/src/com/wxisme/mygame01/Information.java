package com.wxisme.mygame01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * �����Ϸ��Ϣ��
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
	
	//����л�����������ͻ�����������ʱ�䡢��ҩʹ���������ܵ÷֡���ʷ��߷֡�
	
	public void printing(Graphics g) {
		Font f3 = new Font("��Բ", Font.BOLD, 20);
		printInfo(g, "����ֵ:", 800, 70, Color.red, f3);
		printInfo(g, "����ʱ�䣺    " + this.liveTime + "�� ", 800, 100, Color.red, f3);
	}
	
	public void printed(Graphics g) {
		Font f1 = new Font("��Բ", Font.BOLD, 50);
		Font f2 = new Font("��Բ", Font.BOLD, 25);
		printInfo(g, "GAME OVER!", 450, 200, Color.red, f1);
		printInfo(g, "����ʱ�䣺" + this.liveTime + "�� ",        450, 250, Color.blue, f2);
		//printInfo(g, "�л�������" + this.liveTime + "�� ",        450, 250, Color.blue, f2);
		printInfo(g, "����л�������" + this.hitEnemyCnt + "�� ",  450, 290, Color.blue, f2);
		printInfo(g, "����ͻ�������" + this.hitFriendCnt + "�� ", 450, 330, Color.blue, f2);
		printInfo(g, "��ҩʹ��������" + this.bulletCnt + "�� ",    450, 370, Color.blue, f2);
		printInfo(g, "�ܵ÷֣�" + this.score + "�� ",            450, 410, Color.blue, f2);
		printInfo(g, "��ʷ��߷֣�" + this.hScore + "�� ",        450, 450, Color.blue, f2);
		
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
