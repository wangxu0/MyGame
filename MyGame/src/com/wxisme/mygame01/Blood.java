package com.wxisme.mygame01;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 血条类我方飞机的生命值
 * @author wxisme
 * 
 */

public class Blood {
	private int length;
	
	
	public Blood() {
		this.length = 250;
	}
	
	public Blood(int length) {
		this.length = length;
	}
	
	public void drawBlood(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillRect(900, 50, this.length, 18);
		g.setColor(c);
	}
	
	public void drawBorder(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.green);
		g.drawLine(900, 49, 1150, 49);
		g.drawLine(900, 50, 1150, 50);
		g.drawLine(900, 51, 1150, 51);
		
		g.drawLine(899, 49, 899, 70);
		g.drawLine(898, 49, 898, 70);
		g.drawLine(900, 49, 900, 70);
		
		g.drawLine(1149, 49, 1149, 70);
		g.drawLine(1148, 49, 1148, 70);
		g.drawLine(1150, 49, 1150, 70);
		
		g.drawLine(900, 68, 1150, 68);
		g.drawLine(900, 69, 1150, 69);
		g.drawLine(900, 70, 1150, 70);
		g.setColor(c);
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	
	

}
