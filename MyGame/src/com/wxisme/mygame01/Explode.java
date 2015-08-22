package com.wxisme.mygame01;

import java.awt.Graphics;
import java.awt.Image;

/**
 * ��ը��
 * @author wxisme
 *
 */
public class Explode {
	double x, y;
	int count = 0;
	static Image[] imgs = new Image[16];
	//��̬��ʼ��
	static {
		for(int i=0; i<16; i++) {
			imgs[i] = GameTools.getImage("images/explode/e" + (i+1) + ".gif");
			imgs[i].getWidth(null);
		}
	}
	//ģ�ⱬըЧ��
	public void draw(Graphics g) {
		if(count <= 15) {
			g.drawImage(imgs[count++], (int)x, (int)y, null);
		}
	}
	
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}
