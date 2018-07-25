package com.power.saas.common;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public final class CommonUtil {

	private CommonUtil() {
	}

	/**利用MD5进行加密
	 * @param str  	待加密的字符串
	 * @return  	加密后的字符串
	 * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
	 * @throws UnsupportedEncodingException
	 */
	public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//确定计算方法
		MessageDigest md5=MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		//加密后的字符串
		String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}

	/**
	 * 随机生成32位字符串
	 * @return
	 */
	public static String random32(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}

	/**
	 * 获取IP
	 * 
	 * @return
	 */
	public static String getCurrentIp() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return isEmpty(addr) ? "0.0.0.0" : addr.getHostAddress().toString();
	}

	/**
	 * 判断空值
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof String) {
			String s = (String) obj;
			return s.trim().length() == 0 || "null".equals(s) || "NULL".equals(s) || "undefined".equals(s);
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof Collection) {
			@SuppressWarnings("rawtypes")
			Collection c = (Collection) obj;
			return c.isEmpty();
		}
		if (obj instanceof Map) {
			@SuppressWarnings("rawtypes")
			Map m = (Map) obj;
			return m.isEmpty();
		}
		return false;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 产生一个6位随机验证码
	 * 
	 * @return
	 */
	public static int getRandom6() {
		return (int) ((Math.random() * 9 + 1) * 100000);
	}

	/**
	 * 产生一个固定长度的数字字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomNumberStr(int length) {
		StringBuffer b = new StringBuffer("1");
		for (int i = 0; i < length - 1; i++) {
			b.append("0");
		}
		long p = Long.parseLong(b.toString());
		return String.valueOf((long) ((Math.random() * 9 + 1) * p));
	}

	/**
	 * 8位随机字符串
	 * 
	 * @return
	 */
	public static String generateShortUuid() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		Random r = new Random();
		int nextInt = r.nextInt(7);
		return uuid.substring(nextInt, nextInt + 8);
	}

	/**
	 * 8位随机数字
	 * 
	 * @return
	 */
	public static String generateRandomNumber() {
		return generateRandomNumber(8);
	}

	public static String generateRandomNumber(int length) {
		StringBuilder str = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			str.append(random.nextInt(9));
		}
		return str.toString();
	}

	public static void main(String[] args) {
		try {
			System.out.println(encoderByMd5("asdfasdfas"));
			System.out.println(random32());
			System.out.println(random32().length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
