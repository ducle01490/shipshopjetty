package com.shipper.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;


public class HttpConnection {

	public static Logger log = LoggerUtil.getDailyLogger("HttpConnection_error");
	
	private static final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) {
//		for(int i = 0 ; i < 5000 ; i ++) {
//			HttpThread thread = new HttpThread(i + "", 10);
//			thread.start();
//		}
		
		postExample();
		
	}
	
	public static class HttpThread extends Thread {
		public int loop = 1;
		public String name;
		public HttpThread(String name, int loop) {
			this.loop = loop;
			this.name = name;
		}
		
		public void run() {
			for(int i = 0 ; i < loop ; i ++) {
				
				int result = HttpConnection.postExample();
				System.out.println(name + " -- " + i + " :: " + result);
			}
		}
	}
	
	public static int postExample() {
		HttpConnection http = new HttpConnection();
		long time = CommonUtil.time() % 10000;
		String url = "https://grabyo.com/ws/shares/g6ZkGkUOjZo/event";
				//"http://5play.me:8892/WebDirectory-0.0.1-SNAPSHOT/directory/football_video";
		String body = "{\"cid\":90948, \"start\":0, \"end\":1}"; 
				//"{\"os\":\"android\" , \"appid\":\"xocdia\" , \"did\":\"" + time + "\" }";
		try {
			HttpResponse result = http.sendPost(url, body);
			log.info(result);
			return result.code;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}


	/**
	 * HTTP GET request
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static HttpResponse sendGet(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int code = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + code);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Return
		HttpResponse result = new HttpResponse();
		result.code = code;
		result.data = response.toString();
		
		
		return result;

	}
	
 
	/**
	 * HTTP POST request
	 * @param url
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public HttpResponse sendPost(String url, String body) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		System.out.println(url + " " + body);
		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(body);
		wr.flush();
		wr.close();

		int code = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		// Return
		HttpResponse result = new HttpResponse();
		result.code = code;
		result.data = response.toString();
		System.out.println(result);
		return result;

	}
	
	public static class HttpResponse {
		public int code;
		public String data;
		
		@Override
		public String toString(){
			String result = "";
			try {
				result = CommonUtil.toString(this);
			} catch (Exception e) {
				
			}
			return result;
		}
	}

}