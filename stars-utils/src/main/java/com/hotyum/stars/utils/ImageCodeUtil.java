package com.hotyum.stars.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class ImageCodeUtil {
	
	
	
	/**
	 * 
	 * @param width     
	 * @param height
	 * @param fontName
	 * @param fontStyle
	 * @param fontSize
	 * @param sRand
	 * @return
	 */
	public static  BufferedImage getImageWithSrand(int width,int height,String fontName,int fontStyle,int fontSize,String  sRand) {
		// 在内存中创建图象
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font(fontName, fontStyle, fontSize));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		int codeLength=sRand.length();
		int strWidth = width / 2 - g.getFontMetrics().stringWidth(sRand) / codeLength - 24;
		int strHeight = height / 2 + 12;
		for (int i = 0; i < codeLength; i++) {
			String rand = sRand.substring(i, i + 1);
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));// 调用函数出来的颜色相同，
			int zz = new Random().nextInt(8);
			zz = zz % 2 == 0 ? zz - 10 : zz;
			g.drawString(rand, strWidth + (13 + 16 * i), strHeight + zz);
		}
		g.dispose();
		return image;
	}
	
	public static  BufferedImage getImageWithSrand(String  sRand) {
		return getImageWithSrand(125, 38, "Times New Roman", 0, 25, sRand);
	}
	
	
	public static void main(String[] args) throws IOException {
	    String sRand= 	randomRand(4);
	    
	    BufferedImage image=getImageWithSrand(sRand);
	    
	    ImageIO.write(image, "gif", new File("aa.gif"));
	}
	
	
  static Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	private static String randomString = "ABCDEFGHIJKLMNPQRSTUVWXYZ23456789abcdefghijkmnpqrstuvwxyz";

	private static String randomNum= "0123456789";

	public static String randomRand(int n) {
		String rand = "";
		int len = randomString.length() - 1;
		double r;
		for (int i = 0; i < n; i++) {
			r = (Math.random()) * len;
			rand = rand + randomString.charAt((int) r);
		}
		return rand;
	}
	
	
	public static String randomRandNumber(int n) {
		String rand = "";
		int len = randomNum.length() - 1;
		double r;
		for (int i = 0; i < n; i++) {
			r = (Math.random()) * len;
			rand = rand + randomNum.charAt((int) r);
		}
		return rand;
	}

}
