package com.shipper.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.shipper.util.LoggerUtil;


@Path("/account")
public class AccountResource {
	public static Logger logger = LoggerUtil.getDailyLogger("NewsResource_log");
	
	
	public AccountResource() {
		
		
	}
	
	
	@Path("/register")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response register(String info, @Context HttpServletRequest req) {
		String userName = null;
		String passWord = null;
		int role = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			passWord = data.getString("passWord");
			role = data.getInt("role");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		
		JSONObject res = new JSONObject();
		res.put("userName", userName + " - registered");
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	

	@Path("/login")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response login(String info, @Context HttpServletRequest req) {
		String userName = null;
		String passWord = null;
		int role = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			passWord = data.getString("passWord");
			role = data.getInt("role");
			logger.info("login: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/reset_password")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response resetPassword(String info, @Context HttpServletRequest req) {
		String userName = null;
		int userType = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			userType = data.getInt("userType");
			logger.info("reset_password: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/update_password")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updatePassword(String info, @Context HttpServletRequest req) {
		String userName = null;
		String newPassword = null;
		String verifiedCode = null;
		int userType = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			newPassword = data.getString("newPassword");
			verifiedCode = data.getString("verifiedCode");
			userType = data.getInt("userType");
			logger.info("update_password: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	

	
	@Path("/update_phone")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updatePhone(String info, @Context HttpServletRequest req) {
		String userName = null;
		String phone = null;
		int role = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			phone = data.getString("phone");
			role = data.getInt("role");
			
			logger.info("update_phone: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/verify_phone")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response verifyPhone(String info, @Context HttpServletRequest req) {
		String userName = null;
		String verifiedCode = null;
		int role = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			verifiedCode = data.getString("phone");
			role = data.getInt("role");
			
			logger.info("verify_phone: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/shop/update_profile")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updateShopProfile(String info, @Context HttpServletRequest req) {
		String userName = null;
		String shopName = null;
		String address = null;
		String facebook = null;
		String zalo = null;
		String bankInfo = null;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			shopName = data.getString("shopName");
			address = data.getString("address");
			facebook = data.getString("facebook");
			zalo = data.getString("zalo");
			bankInfo = data.getString("bankInfo");
			
			logger.info("shop_update_profile: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	

	@Path("/shipper/update_profile")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updateShipperProfile(String info, @Context HttpServletRequest req) {
		String userName = null;
		String shipperName = null;
		String motorNumber = null;
		String birthday = null;
		String idNumber = null;
		String address = null;
		
		
		
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			shipperName = data.getString("shipperName");
			address = data.getString("address");
			motorNumber = data.getString("motorNumber");
			idNumber = data.getString("idNumber");
			birthday = data.getString("birthday");
			
			logger.info("shipper_update_profile: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	

	
	
	
}