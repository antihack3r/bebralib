/*
 * This file is a part of bebralib -- you can get yo copy at https://github.com/antihack3r/bebralib
 */

package ru.antihack3r.bebralib.math;

/**
 * The {@code Math} class name is already taken, so this one is named {@code Meth}.<br>
 * <br>
 * {@code Meth} is a collection of utilities that will help dealing with {@code float}s, {@code double}s, {@code int}s
 * and {@code long}s. Very effective :thumbsup:
 */
public class Meth {
	
	/**
	 * Super-long {@code pi}.
	 * @see <a href="https://www.piday.org/million/">this page</a>
	 */
	public static final double PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132000568127145263560827785771342757789609173637178721468440901224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595024459455346908302642522308253344685035261931188171010003137838752886587533208381420617177669147303598253490428755468731159562863882353787593751957781857780532171226806613001927876611195909216420198938095257201065485863278865936153381827968230301952035301852968995773622599413891249721775283479131515574857242454150695950829533116861727855889075098381754637464939319255060400927701671139009848824012858361603563707660104710181942955596198946767837449448255379774726847104047534646208046684259069491293313677028989152104752162056966024058038150193511253382430035587640247496473263914199272604269922796782354781636009341721641219924586315030286182974555706749838505494588586926995690927210797509302955321165344987202755960236480665499119881834797753566369807426542527862551818417574672890977772793800081647060016145249192173217214772350141441973568548161361157352552133475741849468438523323907394143334547762416862518983569485562099219222184272550254256887671790494601653466804988627232791786085784383827967976681454100953883786360950680064225125205117392984896084128488626945604241965285022210661186306744278622039194945047123713786960956364371917287467764657573962413890865832645995813390478027590099465764078951269468398352595709825822620522489407726719478268482601476990902640136394437455305068203496252451749399651431429809190659250937221696461515709858387410597885959772975498930161753928468138268683868942774155991855925245953959431049972524680845987273644695848653836736222626099124608051243884390451244136549762780797715691435997700129616089441694868555848406353422072225828488648158456028506016842739452267467678895252138522549954666727823986456596116354886230577456498035593634568174324112515076069479451096596094025228879710893145669136867228748940560101503308617928680920874760917824938589009714909675985261365549781893129D;
	public static final float _PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132000568127145263560827785771342757789609173637178721468440901224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595024459455346908302642522308253344685035261931188171010003137838752886587533208381420617177669147303598253490428755468731159562863882353787593751957781857780532171226806613001927876611195909216420198938095257201065485863278865936153381827968230301952035301852968995773622599413891249721775283479131515574857242454150695950829533116861727855889075098381754637464939319255060400927701671139009848824012858361603563707660104710181942955596198946767837449448255379774726847104047534646208046684259069491293313677028989152104752162056966024058038150193511253382430035587640247496473263914199272604269922796782354781636009341721641219924586315030286182974555706749838505494588586926995690927210797509302955321165344987202755960236480665499119881834797753566369807426542527862551818417574672890977772793800081647060016145249192173217214772350141441973568548161361157352552133475741849468438523323907394143334547762416862518983569485562099219222184272550254256887671790494601653466804988627232791786085784383827967976681454100953883786360950680064225125205117392984896084128488626945604241965285022210661186306744278622039194945047123713786960956364371917287467764657573962413890865832645995813390478027590099465764078951269468398352595709825822620522489407726719478268482601476990902640136394437455305068203496252451749399651431429809190659250937221696461515709858387410597885959772975498930161753928468138268683868942774155991855925245953959431049972524680845987273644695848653836736222626099124608051243884390451244136549762780797715691435997700129616089441694868555848406353422072225828488648158456028506016842739452267467678895252138522549954666727823986456596116354886230577456498035593634568174324112515076069479451096596094025228879710893145669136867228748940560101503308617928680920874760917824938589009714909675985261365549781893129F;
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code integer} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code integer} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isInteger(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code float} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code float} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isFloat(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Float.parseFloat(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code double} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code double} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isDouble(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code long} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code long} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isLong(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Long.parseLong(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code short} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code short} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isShort(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Short.parseShort(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Tests and determines whether the string specified contains a parsable {@code byte} value.
	 * @param s The string in question.
	 * @return true if the string specified contains a parsable {@code byte} value, false otherwise.
	 * @throws NullPointerException if {@code s} is {@code null}.
	 */
	public static boolean isByte(String s) {
		if (s == null)
			throw new NullPointerException("the argument is null");
		
		try {
			Byte.parseByte(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Returns an {@code integer} value that is the highest of
	 * those which are lower than or equal to {@code value}.
	 * @param value The value to be floored.
	 * @return An {@code integer} value that is the highest of
	 * those which are lower or equal to {@code value}
	 */
	public static int floor(float value) {
		if (Float.isNaN(value) || value == 0F) return 0;
		if (value == Float.POSITIVE_INFINITY || value == Float.MAX_VALUE) return Integer.MAX_VALUE;
		if (value == Float.NEGATIVE_INFINITY || value == Float.MIN_VALUE) return Integer.MIN_VALUE;

		int intValue = (int) value;
		return intValue > value? intValue - 1: intValue;
	}
	
	/**
	 * Returns an {@code integer} value that is the highest of
	 * those which are lower than or equal to {@code value}.
	 * @param value The value to be floored.
	 * @return An {@code integer} value that is the highest of
	 * those which are lower or equal to {@code value}
	 */
	public static int floor(double value) {
		if (Double.isNaN(value) || value == 0F) return 0;
		if (value == Double.POSITIVE_INFINITY || value == Double.MAX_VALUE) return Integer.MAX_VALUE;
		if (value == Double.NEGATIVE_INFINITY || value == Double.MIN_VALUE) return Integer.MIN_VALUE;
		
		int intValue = (int) value;
		return intValue > value? intValue - 1: intValue;
	}
	
	/**
	 * Returns an {@code integer} value that is the lowest of
	 * those which are higher or equal to {@code value}.
	 * @param value The value to be floored.
	 * @return An {@code integer} value that is the lowest of
	 * those which are higher or equal to {@code value}
	 */
	public static int ceil(float value) {
		if (Float.isNaN(value) || value == 0F) return 0;
		if (value == Float.POSITIVE_INFINITY || value == Float.MAX_VALUE) return Integer.MAX_VALUE;
		if (value == Float.NEGATIVE_INFINITY || value == Float.MIN_VALUE) return Integer.MIN_VALUE;
		
		int intValue = (int) value;
		return intValue < value? intValue + 1: intValue;
	}
	
	/**
	 * Returns an {@code integer} value that is the lowest of
	 * those which are higher or equal to {@code value}.
	 * @param value The value to be floored.
	 * @return An {@code integer} value that is the lowest of
	 * those which are higher or equal to {@code value}
	 */
	public static int ceil(double value) {
		if (Double.isNaN(value) || value == 0D) return 0;
		if (value == Double.POSITIVE_INFINITY || value == Double.MAX_VALUE) return Integer.MAX_VALUE;
		if (value == Double.NEGATIVE_INFINITY || value == Double.MIN_VALUE) return Integer.MIN_VALUE;
		
		int intValue = (int) value;
		return intValue < value? intValue + 1: intValue;
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static int clamp(int value, int minValue, int maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static float clamp(float value, float minValue, float maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static double clamp(double value, double minValue, double maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Returns a value that is clamped between {@code minValue} and {@code maxValue}.
	 * @param value The value to be clamped.
	 * @param minValue The minimum result value.
	 * @param maxValue The maximum result value.
	 * @return The clamped value.
	 */
	public static long clamp(long value, long minValue, long maxValue) {
		return Math.max(minValue, Math.min(value, maxValue));
	}
	
	/**
	 * Converts an angle measured in degrees to an approximately
	 * equivalent angle measured in radians.  The conversion from
	 * degrees to radians is generally inexact.
	 *
	 * @param   angdeg   an angle, in degrees
	 * @return  the measurement of the angle {@code angdeg}
	 *          in radians.
	 */
	public static float toRadians(float angdeg) {
		return angdeg / 180F * _PI;
	}

	/**
	 * Converts an angle measured in radians to an approximately
	 * equivalent angle measured in degrees.  The conversion from
	 * radians to degrees is generally inexact; users should
	 * <i>not</i> expect {@code cos(toRadians(90F))} to exactly
	 * equal {@code 0F}.
	 *
	 * @param   angrad   an angle, in radians
	 * @return  the measurement of the angle {@code angrad}
	 *          in degrees.
	 */
	public static float toDegrees(float angrad) {
		return angrad * 180F / _PI;
	}
	
	/**
	 * Returns the trigonometric sine of an angle.  Special cases:
	 * <ul><li>If the argument is NaN or an infinity, then the
	 * result is NaN.
	 * <li>If the argument is zero, then the result is a zero with the
	 * same sign as the argument.</ul>
	 *
	 * <p>The computed result must be within 1 ulp of the exact result.
	 * Results must be semi-monotonic.
	 *
	 * @param   a   an angle, in radians.
	 * @return  the sine of the argument.
	 */
	public static float sin(float a) {
		return (float)StrictMath.sin(a);
	}
	
	/**
	 * Returns the trigonometric cosine of an angle. Special cases:
	 * <ul><li>If the argument is NaN or an infinity, then the
	 * result is NaN.</ul>
	 *
	 * <p>The computed result must be within 1 ulp of the exact result.
	 * Results must be semi-monotonic.
	 *
	 * @param   a   an angle, in radians.
	 * @return  the cosine of the argument.
	 */
	public static float cos(float a) {
		return (float)StrictMath.cos(a);
	}
	
	/**
	 * Returns the trigonometric tangent of an angle.  Special cases:
	 * <ul><li>If the argument is NaN or an infinity, then the result
	 * is NaN.
	 * <li>If the argument is zero, then the result is a zero with the
	 * same sign as the argument.</ul>
	 *
	 * <p>The computed result must be within 1 ulp of the exact result.
	 * Results must be semi-monotonic.
	 *
	 * @param   a   an angle, in radians.
	 * @return  the tangent of the argument.
	 */
	public static float tan(float a) {
		return (float)StrictMath.tan(a);
	}
	
	/**
	 * Returns the arc sine of a value; the returned angle is in the
	 * range -<i>pi</i>/2 through <i>pi</i>/2.  Special cases:
	 * <ul><li>If the argument is NaN or its absolute value is greater
	 * than 1, then the result is NaN.
	 * <li>If the argument is zero, then the result is a zero with the
	 * same sign as the argument.</ul>
	 *
	 * <p>The computed result must be within 1 ulp of the exact result.
	 * Results must be semi-monotonic.
	 *
	 * @param   a   the value whose arc sine is to be returned.
	 * @return  the arc sine of the argument.
	 */
	public static float asin(float a) {
		return (float)StrictMath.asin(a);
	}
	
	/**
	 * Returns the arc cosine of a value; the returned angle is in the
	 * range 0.0 through <i>pi</i>.  Special case:
	 * <ul><li>If the argument is NaN or its absolute value is greater
	 * than 1, then the result is NaN.</ul>
	 *
	 * <p>The computed result must be within 1 ulp of the exact result.
	 * Results must be semi-monotonic.
	 *
	 * @param   a   the value whose arc cosine is to be returned.
	 * @return  the arc cosine of the argument.
	 */
	public static float acos(float a) {
		return (float)StrictMath.acos(a);
	}
	
	/**
	 * Returns the arc tangent of a value; the returned angle is in the
	 * range -<i>pi</i>/2 through <i>pi</i>/2.  Special cases:
	 * <ul><li>If the argument is NaN, then the result is NaN.
	 * <li>If the argument is zero, then the result is a zero with the
	 * same sign as the argument.</ul>
	 *
	 * <p>The computed result must be within 1 ulp of the exact result.
	 * Results must be semi-monotonic.
	 *
	 * @param   a   the value whose arc tangent is to be returned.
	 * @return  the arc tangent of the argument.
	 */
	public static float atan(float a) {
		return (float)StrictMath.atan(a);
	}

}
