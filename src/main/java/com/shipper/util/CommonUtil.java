package com.shipper.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	public static String toString(Object o) throws Exception {
		return ResourceUtil.getObjectMapper().writeValueAsString(o);
	}
	
	
	public static String timeStamp() {
		return (new Date()).toString();
	}
	
	public static long currentHourTime() {
		Calendar c = Calendar.getInstance();
		// System.out.println(c.getTimeInMillis());
		// c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		//System.out.println(c.toString());
		long time = c.getTimeInMillis();
		
		//Date date = new Date(time);
		//System.out.println(date.toString());
		return time;
	}
	
	public static long currentDayTime() {
		Calendar c = Calendar.getInstance();
		//System.out.println(c.getTimeInMillis());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		//System.out.println(c.toString());
		long time = c.getTimeInMillis();
		
		//Date date = new Date(time);
		//System.out.println(date.toString());
		return time;
	}
	
	public static long time() {
		return System.currentTimeMillis();
	}
	
	public static long duration(long start) {
		return System.currentTimeMillis() - start;
	}
	
	public static byte[] stringToBytes(String input) {
		return input.getBytes();
	}
	
	public static String bytesToString(byte[] input) {
		return new String(input);
	}
	
	public static String bytes(byte[] input) {
		String result = "";
		for(int i = 0 ; i < input.length ; i ++) {
			result += input[i];
		}
		
		return result;
	}
	
	public static String readFile(String path) {
		BufferedReader br = null;
		String data = "";
		try {

			String line;

			br = new BufferedReader(new FileReader(path));

			
			while ((line = br.readLine()) != null) {
				//System.out.println(sCurrentLine);
				data += line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return data;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(readFile("./homepage.json"));
		long a = -13;
		a = a ^ (-1L) + 1L;
		System.out.println(a);
	}


}
