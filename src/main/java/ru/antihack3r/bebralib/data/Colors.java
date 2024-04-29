/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/rusnuker/bebralib
 */

package ru.antihack3r.bebralib.data;

import ru.antihack3r.bebralib.math.Meth;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Objects;

public class Colors {
	
	/**
	 * Gets the floating-point red value of the specified <tt>color</tt>.
	 * @param color the color.
	 * @return the floating-point red value of the specified <tt>color</tt>.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static float getRedF(@Nonnull Color color) {
		return ((float) Objects.requireNonNull(color).getRed()) / 255F;
	}
	
	/**
	 * Gets the floating-point green value of the specified <tt>color</tt>.
	 * @param color the color.
	 * @return the floating-point green value of the specified <tt>color</tt>.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static float getGreenF(@Nonnull Color color) {
		return ((float) Objects.requireNonNull(color).getGreen()) / 255F;
	}
	
	/**
	 * Gets the floating-point blue value of the specified <tt>color</tt>.
	 * @param color the color.
	 * @return the floating-point blue value of the specified <tt>color</tt>.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static float getBlueF(@Nonnull Color color) {
		return ((float) Objects.requireNonNull(color).getBlue()) / 255F;
	}
	
	/**
	 * Gets the floating-point alpha value of the specified <tt>color</tt>.
	 * @param color the color.
	 * @return the floating-point alpha value of the specified <tt>color</tt>.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static float getAlphaF(@Nonnull Color color) {
		return ((float) Objects.requireNonNull(color).getAlpha()) / 255F;
	}
	
	/**
	 * Returns an <tt>integer</tt> array consisting of red, green and blue values of the specified color.
	 * @param color the color.
	 * @return an <tt>integer</tt> array consisting of red, green and blue values of the specified color.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull int[] getValues3i(@Nonnull Color color) {
		Objects.requireNonNull(color);
		
		return new int[] {
				color.getRed(),
				color.getGreen(),
				color.getBlue()
		};
	}
	
	/**
	 * Returns an <tt>integer</tt> array consisting of red, green, blue and alpha values of the specified color.
	 * @param color the color.
	 * @return an <tt>integer</tt> array consisting of red, green, blue and alpha values of the specified color.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull int[] getValues4i(@Nonnull Color color) {
		Objects.requireNonNull(color);
		
		return new int[] {
				color.getRed(),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha()
		};
	}
	
	/**
	 * Returns a <tt>float</tt> array consisting of red, green and blue values of the specified color.
	 * @param color the color.
	 * @return a <tt>float</tt> array consisting of red, green and blue values of the specified color.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull float[] getValues3f(@Nonnull Color color) {
		Objects.requireNonNull(color);
		return color.getRGBColorComponents(null);
	}
	
	/**
	 * Returns a <tt>float</tt> array consisting of red, green, blue and alpha values of the specified color.
	 * @param color the color.
	 * @return a <tt>float</tt> array consisting of red, green, blue and alpha values of the specified color.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull float[] getValues4f(@Nonnull Color color) {
		Objects.requireNonNull(color);
		return color.getRGBComponents(null);
	}
	
	/**
	 * Injects a <tt>red</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param red the <tt>integer</tt> red value.
	 * @return a new color with an injected <tt>red</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectRed(@Nonnull Color color, int red) {
		Objects.requireNonNull(color);
		return new Color(normInt(red), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	/**
	 * Injects a <tt>red</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param red the <tt>float</tt> red value.
	 * @return a new color with an injected <tt>red</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectRed(@Nonnull Color color, float red) {
		Objects.requireNonNull(color);
		return new Color(normInt((int)(red * 255F)), color.getGreen(), color.getBlue(), color.getAlpha());
	}
	
	/**
	 * Injects a <tt>green</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param green the <tt>integer</tt> green value.
	 * @return a new color with an injected <tt>green</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectGreen(@Nonnull Color color, int green) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), normInt(green), color.getBlue(), color.getAlpha());
	}
	
	/**
	 * Injects a <tt>green</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param green the <tt>float</tt> green value.
	 * @return a new color with an injected <tt>green</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectGreen(@Nonnull Color color, float green) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), normInt((int)(green * 255F)), color.getBlue(), color.getAlpha());
	}
	
	/**
	 * Injects a <tt>blue</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param blue the <tt>integer</tt> blue value.
	 * @return a new color with an injected <tt>blue</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectBlue(@Nonnull Color color, int blue) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getGreen(), normInt(blue), color.getAlpha());
	}
	
	/**
	 * Injects a <tt>blue</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param blue the <tt>float</tt> blue value.
	 * @return a new color with an injected <tt>blue</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectBlue(@Nonnull Color color, float blue) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getBlue(), normInt((int)(blue * 255F)), color.getAlpha());
	}
	
	/**
	 * Injects a <tt>alpha</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param alpha the <tt>integer</tt> alpha value.
	 * @return a new color with an injected <tt>alpha</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectAlpha(@Nonnull Color color, int alpha) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), normInt(alpha));
	}
	
	/**
	 * Injects a <tt>alpha</tt> value into the specified <tt>color</tt>.
	 * @param color the color.
	 * @param alpha the <tt>float</tt> alpha value.
	 * @return a new color with an injected <tt>alpha</tt> value.
	 * @throws NullPointerException if <tt>color</tt> is null.
	 */
	public static @Nonnull Color injectAlpha(@Nonnull Color color, float alpha) {
		Objects.requireNonNull(color);
		return new Color(color.getRed(), color.getGreen(), color.getBlue(), normInt((int)(alpha * 255F)));
	}
	
	/**
	 * Constructs a new {@link Color} with the specified <tt>rgb</tt> value.
	 * @param rgb A combined RGB value consisting of the red component in
	 * bits 16-23, the green component in bits 8-15, and the blue component
	 * in bits 0-7.
	 * @return a new {@link Color} with the specified <tt>rgb</tt> value.
	 */
	public static @Nonnull Color fromRgb(int rgb) {
		return new Color(rgb, false);
	}
	
	/**
	 * Constructs a new {@link Color} with the specified <tt>argb</tt> value.
	 * @param argb A combined ARGB value consisting of the alpha component
	 * in bits 24-31, the red component in bits 16-23, the green component
	 * in bits 8-15, and the blue component in bits 0-7.
	 * @return a new {@link Color} with the specified <tt>argb</tt> value.
	 */
	public static @Nonnull Color fromArgb(int argb) {
		return new Color(argb, true);
	}
	
	/**
	 * Returns a normalized <tt>value</tt>.
	 * @param value a value that must be normalized.
	 * @return a normalized <tt>value</tt>.
	 */
	private static int normInt(int value) {
		return Meth.clamp(value, 0, 255);
	}
	
	/**
	 * Returns a normalized <tt>value</tt>.
	 * @param value a value that must be normalized.
	 * @return a normalized <tt>value</tt>.
	 */
	private static float normFloat(float value) {
		return Meth.clamp(value, 0F, 1F);
	}
	
}
