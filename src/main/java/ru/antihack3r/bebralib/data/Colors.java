/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.data;

import ru.antihack3r.bebralib.math.Meth;

import java.awt.*;
import java.util.Objects;

public class Colors {
	
	public static float getRedF(Color color) {
		return ((float) Objects.requireNonNull(color).getRed()) / 255F;
	}
	
	public static float getGreenF(Color color) {
		return ((float) Objects.requireNonNull(color).getGreen()) / 255F;
	}
	
	public static float getBlueF(Color color) {
		return ((float) Objects.requireNonNull(color).getBlue()) / 255F;
	}
	
	public static float getAlphaF(Color color) {
		return ((float) Objects.requireNonNull(color).getAlpha()) / 255F;
	}
	
	public static int[] getValues3i(Color color) {
		Objects.requireNonNull(color);
		
		return new int[] {
				color.getRed(),
				color.getGreen(),
				color.getBlue()
		};
	}
	
	public static int[] getValues4i(Color color) {
		Objects.requireNonNull(color);
		
		return new int[] {
				color.getRed(),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha()
		};
	}
	
	public static float[] getValues3f(Color color) {
		Objects.requireNonNull(color);
		return color.getRGBColorComponents(null);
	}
	
	public static float[] getValues4f(Color color) {
		Objects.requireNonNull(color);
		return color.getRGBComponents(null);
	}
	
	public static Color injectRed(Color color, int red) {
		Objects.requireNonNull(color);
		return new Color(normInt(red), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	public static Color injectRed(Color color, float red) {
		Objects.requireNonNull(color);
		return new Color(normInt((int)(red * 255F)), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	public static Color injectGreen(Color color, int green) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), normInt(green), color.getBlue(), color.getAlpha());
	}
	
	public static Color injectGreen(Color color, float green) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), normInt((int)(green * 255F)), color.getBlue(), color.getAlpha());
	}
	
	public static Color injectBlue(Color color, int blue) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getGreen(), normInt(blue), color.getAlpha());
	}
	
	public static Color injectBlue(Color color, float blue) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getBlue(), normInt((int)(blue * 255F)), color.getAlpha());
	}
	
	public static Color injectAlpha(Color color, int alpha) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), normInt(alpha));
	}
	
	public static Color injectAlpha(Color color, float alpha) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), normInt((int)(alpha * 255F)));
	}
	
	public static Color fromRgb(int rgb) {
		return new Color(rgb, false);
	}
	
	public static Color fromArgb(int argb) {
		return new Color(argb, true);
	}
	
	private static int normInt(int value) {
		return Meth.clamp(value, 0, 255);
	}
	
	private static float normFloat(float value) {
		return Meth.clamp(value, 0F, 1F);
	}
	
}
