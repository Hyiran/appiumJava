package com.appium.autotest.ui.pageobject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;


import com.appuim.autotest.ui.testbase.initializerValue;

public class HtmlValue extends initializerValue {

	/**
	 * @Description：图片对比
	 * @param path1
	 * @param path2
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param Factor
	 * @return
	 * @throws FileNotFoundException
	 */

	public static boolean sameAs(BufferedImage myImage,
			BufferedImage otherImage, double percent) {
		// BufferedImage otherImage = other.getBufferedImage();
		// BufferedImage myImage = getBufferedImage();
		if (otherImage.getWidth() != myImage.getWidth()) {
			return false;
		}
		if (otherImage.getHeight() != myImage.getHeight()) {
			return false;
		}
		@SuppressWarnings("unused")
		int[] otherPixel = new int[1];
		@SuppressWarnings("unused")
		int[] myPixel = new int[1];
		int width = myImage.getWidth();
		int height = myImage.getHeight();
		int numDiffPixels = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (myImage.getRGB(x, y) != otherImage.getRGB(x, y)) {
					numDiffPixels++;
				}
			}
		}
		double numberPixels = height * width;
		double diffPercent = numDiffPixels / numberPixels;
		return percent <= 1.0D - diffPercent;
	}

	public static BufferedImage getSubImage(BufferedImage image, int x, int y,
			int w, int h) {
		return image.getSubimage(x, y, w, h);
	}

	public static BufferedImage getImageFromFile(File f) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// if failed, then copy it to local path for later check:TBD
			// FileUtils.copyFile(f, new File(p1));
			e.printStackTrace();
			System.exit(1);
		}
		return img;
	}

}
