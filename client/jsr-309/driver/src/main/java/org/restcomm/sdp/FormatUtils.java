/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
 * by the @authors tag. 
 *  
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *  
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.restcomm.sdp;




public class FormatUtils {

	
	/**
	 * Is a a subclass of b? Strict.
	 */
	public static boolean isSubclass(Class a, Class b) {
		if (a == b)
			return false;
		if (!(b.isAssignableFrom(a)))
			return false;
		return true;
	}

	public static boolean isOneAssignableFromTheOther(Class a, Class b) {
		return a == b || b.isAssignableFrom(a) || a.isAssignableFrom(b);
	}

	public static long stringEncodingCodeVal(String s) {
		long result = 0;
		for (int i = 0; i < s.length(); ++i) {
			final char c = s.charAt(i);
			result *= 64;
			result += charEncodingCodeVal(c);

		}
		return result;
	}

	private static int charEncodingCodeVal(char c) {

		if (c <= (char) 95)
			return c - 32;
		if (c == 96)
			return -1;
		if (c <= 122)
			return c - 64;
		if (c <= 127)
			return -1;
		if (c <= 191)
			return -94;
		if (c <= 255)
			return -93;

		return -1;

	}

	public static boolean specified(Object o) {
		return o != null;
	}

	public static boolean specified(int v) {
		return v != Format.NOT_SPECIFIED;
	}

	public static boolean specified(float v) {
		return v != Format.NOT_SPECIFIED;
	}

	public static boolean specified(double v) {
		return v != Format.NOT_SPECIFIED;
	}

	public static boolean byteArraysEqual(byte[] ba1, byte[] ba2) {
		if (ba1 == null && ba2 == null)
			return true;
		if (ba1 == null || ba2 == null)
			return false;

		if (ba1.length != ba2.length)
			return false;
		for (int i = 0; i < ba1.length; ++i) {
			if (ba1[i] != ba2[i])
				return false;
		}
		return true;
	}

	public static boolean nullSafeEquals(Object o1, Object o2) {
		if (o1 == null && o2 == null)
			return true;
		if (o1 == null || o2 == null)
			return false;
		return o1.equals(o2);
	}

	public static boolean nullSafeEqualsIgnoreCase(String o1, String o2) {
		if (o1 == null && o2 == null)
			return true;
		if (o1 == null || o2 == null)
			return false;
		return o1.equalsIgnoreCase(o2);
	}

	public static boolean matches(Object o1, Object o2) {
		if (o1 == null || o2 == null)
			return true;
		return o1.equals(o2);
	}

	// public static boolean matchesIgnoreCase(String o1, String o2)
	// { if (o1 == null || o2 == null)
	// return true;
	// return o1.equalsIgnoreCase(o2);
	// }

	public static boolean matches(int v1, int v2) {
		if (v1 == Format.NOT_SPECIFIED || v2 == Format.NOT_SPECIFIED)
			return true;
		return v1 == v2;
	}

	public static boolean matches(float v1, float v2) {
		if (v1 == Format.NOT_SPECIFIED || v2 == Format.NOT_SPECIFIED)
			return true;
		return v1 == v2;
	}

	public static boolean matches(double v1, double v2) {
		if (v1 == Format.NOT_SPECIFIED || v2 == Format.NOT_SPECIFIED)
			return true;
		return v1 == v2;
	}

	public static String frameRateToString(float frameRate) {
		// hack to get frame rates to print out same as JMF: 1 decimal place,
		// but NO rounding.
		frameRate = (((long) (frameRate * 10))) / 10.f;
		String s = "" + frameRate;

		return s;
	}

}
