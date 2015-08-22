package com.wxisme.mygame01;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * ���ù�����
 * @author wxisme
 * @version 1.0
 */

public class GameTools {
	/*
	 * �������еķ���һ����static�ģ�ֱ�����������á�
	 */
	private GameTools() {}
	
	//����ͼƬ
	public static Image getImage(String pash) {
		URL u = GameTools.class.getClassLoader().getResource(pash);
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(u);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return img;
	}
	
	

}
