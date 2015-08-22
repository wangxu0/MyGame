package com.wxisme.mygame01;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ������
 * @author wxisme 
 * 
 */
@SuppressWarnings("serial")
public class MyFrame extends Frame {
	//���ش���
	void launchFrame() {
		setSize(Constant.WINDOW_WEIGHT, Constant.WINDOW_HIGHT);
		setLocation(Constant.WINDOW_START_X, Constant.WINDOW_START_Y);
		setVisible(true);
		
		new PaintThread().start();
	
	//���Ӵ��ڼ���
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
		
	/**
	 * paint�߳�
	 * @author wxisme
	 *
	 */
	class PaintThread extends Thread {
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
			
	}
		
	//update window
	
	public void update(Graphics g) {
		Image offScreenIamge = null;
		if(offScreenIamge == null) {
			offScreenIamge = this.createImage(Constant.WINDOW_WEIGHT, Constant.WINDOW_HIGHT);
		}
		Graphics gOff = offScreenIamge.getGraphics();
		
		paint(gOff);
		g.drawImage(offScreenIamge, 0, 0, null);
	}

}
