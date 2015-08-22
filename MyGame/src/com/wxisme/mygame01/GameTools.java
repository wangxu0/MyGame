package com.wxisme.mygame01;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * 常用工具类
 * @author wxisme
 * @version 1.0
 */

public class GameTools {
	/*
	 * 工具类中的方法一般是static的，直接用类名调用。
	 */
	private GameTools() {}
	
	//加载图片
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
