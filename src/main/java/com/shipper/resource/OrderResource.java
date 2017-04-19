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

import com.shipper.model.OrderFull;
import com.shipper.util.LoggerUtil;

@Path("/order")
public class OrderResource {
	
	public static Logger logger = LoggerUtil.getDailyLogger("NewsResource_log");
	
	
	public OrderResource() {
		
		
	}

	@Path("/create_order")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response createOrder(String info, @Context HttpServletRequest req) {
		String userName = null;
		String receiveAddress = null;
		String customerName = null;
		String customerPhone = null;

		int deliveryType = -1;
		long deliveryPrice = -1;
		long productPrice = -1;

		String timeNote = null;
		String productNote = null;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			receiveAddress = data.getString("receiveAddress");
			customerName = data.getString("customerName");
			customerPhone = data.getString("customerPhone");
			
			deliveryType = data.getInt("deliveryType");
			productPrice = data.getLong("productPrice");
			deliveryPrice = data.getLong("deliveryPrice");
			
			timeNote = data.getString("timeNote");
			productNote = data.getString("productNote");
			
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/cancel_order")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response cancelOrder(String info, @Context HttpServletRequest req) {
		String userName = null;
		long orderId = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			orderId = data.getLong("orderId");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/update_order_status")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updateOrderStatus(String info, @Context HttpServletRequest req) {
		String userName = null;
		long orderId = -1;
		int orderStatus = -1;
		int role = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			orderId = data.getInt("orderId");
			orderStatus = data.getInt("orderStatus");
			role = data.getInt("role");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/confirm_order_status")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response confirmOrderStatus(String info, @Context HttpServletRequest req) {
		String userName = null;
		long orderId = -1;
		int role = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			orderId = data.getInt("orderId");
			role = data.getInt("role");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/bid_order")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response bidOrder(String info, @Context HttpServletRequest req) {
		String userName = null;
		long orderId = -1;
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			userName = data.getString("userName");
			orderId = data.getInt("orderId");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		String result = "";
		JSONObject res = new JSONObject(result);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_order_list")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrderList(
			@QueryParam("cid") @DefaultValue("1795") int cid, 
			@QueryParam("start") @DefaultValue("0") int start, 
			@QueryParam("end") @DefaultValue("1") int end, 
			@Context HttpServletRequest req) {
		
		
		List<OrderFull> data = null;//_dbUtils.getArticleFromDB(cid, start, end);
		logger.info(data.size());
		JSONArray res = new JSONArray(data);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_order")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrder(
			@QueryParam("orderId") @DefaultValue("-1") int orderId,
			@Context HttpServletRequest req) {
		
		
		List<OrderFull> data = null;//_dbUtils.getArticleFromDB(cid, start, end);
		logger.info(data.size());
		JSONArray res = new JSONArray(data);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_order_status")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrderStatus(
			@QueryParam("cid") @DefaultValue("1795") int cid, 
			@QueryParam("start") @DefaultValue("0") int start, 
			@QueryParam("end") @DefaultValue("1") int end, 
			@Context HttpServletRequest req) {
		
		
		List<OrderFull> data = null;//_dbUtils.getArticleFromDB(cid, start, end);
		logger.info(data.size());
		JSONArray res = new JSONArray(data);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
}
