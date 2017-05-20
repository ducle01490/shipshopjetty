package com.shipper.resource;

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
import org.json.JSONObject;

import com.shipper.logic.account.AccountLogic;
import com.shipper.logic.order.OrderLogic;
import com.shipper.model.User;
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
		String orderTitle = null;
		String userName = null;
		
		String receiveAddress = null;
		String customerAddress = null;
		String customerName = null;
		String customerPhone = null;

		int deliveryType = -1;
		long deliveryPrice = -1;
		long productPrice = -1;

		String timeNote = null;
		String productNote = null;
		
		String sessionKey = req.getHeader("sessionKey");
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");

			orderTitle = data.getString("orderTitle");
			userName = data.getString("userName");
			receiveAddress = data.getString("receiveAddress");
			customerAddress = data.getString("customerAddress");
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
		boolean authen = AccountLogic.checkUserSession(userName, User.role_shop, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.createOrder(orderTitle, userName, receiveAddress, customerAddress, customerName, customerPhone, deliveryType, deliveryPrice, productPrice, timeNote, productNote);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		//JSONObject res = OrderLogic.createOrder(orderTitle, userName, receiveAddress, customerAddress, customerName, customerPhone, deliveryType, deliveryPrice, productPrice, timeNote, productNote);
		String resLog = "" + userName + " " + receiveAddress 
				+ " " + customerAddress + " " + customerName 
				+ " " + customerPhone 
				+ " " + deliveryType + " " + productPrice + " " + deliveryPrice
				+ " " + timeNote + " " + productNote;
		res.put("log", resLog);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/cancel_order")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response cancelOrder(String info, @Context HttpServletRequest req) {
		String shopUserName = null;
		int orderId = -1;
		
		String sessionKey = req.getHeader("sessionKey");
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			shopUserName = data.getString("userName");
			orderId = data.getInt("orderId");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		boolean authen = AccountLogic.checkUserSession(shopUserName, User.role_shop, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.synCancelOrder(orderId, shopUserName);
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/update_order_status")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updateOrderStatus(String info, @Context HttpServletRequest req) {
		String userName = null;
		int orderStatus = -1;
		int orderId = -1;
		int role = -1;
		
		String sessionKey = req.getHeader("sessionKey");
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");

			userName = data.getString("userName");
			orderStatus = data.getInt("status");
			orderId = data.getInt("orderId");
			role = data.getInt("role");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		boolean authen = AccountLogic.checkUserSession(userName, role, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.updateOrderStatus(orderId, orderStatus, role);
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/confirm_order_status")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response confirmOrderStatus(String info, @Context HttpServletRequest req) {
		String userName = null;
		int orderStatus = -1;
		int orderId = -1;
		int role = -1;
		
		String sessionKey = req.getHeader("sessionKey");
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");

			userName = data.getString("userName");
			orderStatus = data.getInt("status");
			orderId = data.getInt("orderId");
			role = data.getInt("role");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		boolean authen = AccountLogic.checkUserSession(userName, role, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.confirmOrderStatus(orderId, orderStatus, role);
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	@Path("/update_order_paid")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updateOrderPaid(String info, @Context HttpServletRequest req) {
		String userName = null;
		long orderPaid = 0;
		int orderId = -1;
		int role = -1;
		
		String sessionKey = req.getHeader("sessionKey");
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");

			userName = data.getString("userName");
			orderPaid = data.getLong("orderPaid");
			orderId = data.getInt("orderId");
			role = data.getInt("role");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		boolean authen = AccountLogic.checkUserSession(userName, role, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.updateOrderPaid(orderId, orderPaid, role);
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Path("/bid_order")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response bidOrder(String info, @Context HttpServletRequest req) {
		String shipperUserName = null;
		int orderId = -1;
		
		String sessionKey = req.getHeader("sessionKey");
		try {
			JSONObject jsonObject = new JSONObject(info);
			JSONObject data = jsonObject.getJSONObject("data");
			JSONObject log = jsonObject.getJSONObject("log");


			shipperUserName = data.getString("userName");
			orderId = data.getInt("orderId");
			
			logger.info("register: " + log);
		} catch (Exception e) { 
			logger.error(e);
		}
		
		boolean authen = AccountLogic.checkUserSession(shipperUserName, User.role_shipper, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.synBidOrder(orderId, shipperUserName);
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_order_list")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrderList(
			@QueryParam("shopUserName") @DefaultValue("") String userName, 
			@QueryParam("status") @DefaultValue("-1") int status, 
			@QueryParam("offset") @DefaultValue("-1") int offset, 
			@QueryParam("numb") @DefaultValue("-1") int numb,
			@Context HttpServletRequest req) {
		
		String sessionKey = req.getHeader("sessionKey");
		boolean authen = AccountLogic.checkSession(sessionKey);
		JSONObject res;
		if(authen) {
			if(status >=0 && status <= 6)
				res = OrderLogic.getOrderFullList(userName, status, offset, numb);
			else 
				res = OrderLogic.getOrderFullList(userName, offset, numb);
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_order_list_by_time")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrderListByTime(
			@QueryParam("shopUserName") @DefaultValue("") String userName, 
			@QueryParam("status") @DefaultValue("-1") int status, 
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@QueryParam("offset") @DefaultValue("0") int offset, 
			@QueryParam("numb") @DefaultValue("10") int numb,
			@Context HttpServletRequest req) {
		
		String sessionKey = req.getHeader("sessionKey");
		boolean authen = AccountLogic.checkSession(sessionKey);
		JSONObject res;
		if(authen) {
			if(status >=0 && status <= 6)
				res = OrderLogic.getOrderFullByTime(userName, status, startTime, endTime, offset, numb);
			else 
				res = OrderLogic.getOrderFullByTime(userName, startTime, endTime, offset, numb);
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/get_order_info")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrderInfo(
			@QueryParam("orderId") @DefaultValue("-1") int orderId,
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		boolean authen = AccountLogic.checkSession(sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.getOrder(orderId);
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_order")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getOrder(
			@QueryParam("orderId") @DefaultValue("-1") int orderId,
			@Context HttpServletRequest req) {
		
		String sessionKey = req.getHeader("sessionKey");
		boolean authen = AccountLogic.checkSession(sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.getOrderFull(orderId);
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Path("/shipper_aggregate")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipperAggregate(
			@QueryParam("shipperUserName") @DefaultValue("") String shipperUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shipperUserName, User.role_shipper, sessionKey);
		JSONObject res;
		if(authen) {
			
			res = OrderLogic.getShipperAggregate(shipperUserName, orderStatus);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/shop_aggregate")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShopAggregate(
			@QueryParam("shopUserName") @DefaultValue("") String shopUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shopUserName, User.role_shop, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.getShopAggregate(shopUserName, orderStatus);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	
	
	
	

	
	
	@Path("/shipper_aggregate_time")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipperAggregateTime(
			@QueryParam("shipperUserName") @DefaultValue("") String shipperUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shipperUserName, User.role_shipper, sessionKey);
		JSONObject res;
		if(authen) {
			
			res = OrderLogic.getShipperAggregateByTime(shipperUserName, orderStatus, startTime, endTime);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/shop_aggregate_time")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShopAggregateTime(
			@QueryParam("shopUserName") @DefaultValue("") String shopUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shopUserName, User.role_shop, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.getShopAggregateByTime(shopUserName, orderStatus, startTime, endTime);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Path("/shipper_date_aggregate")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipperDateAggregate(
			@QueryParam("shipperUserName") @DefaultValue("") String shipperUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shipperUserName, User.role_shipper, sessionKey);
		JSONObject res;
		if(authen) {
			
			res = OrderLogic.getShipperDateAggregate(shipperUserName, orderStatus, startTime, endTime);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/shop_date_aggregate")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShopDateAggregate(
			@QueryParam("shopUserName") @DefaultValue("") String shopUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shopUserName, User.role_shop, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.getShopDateAggregate(shopUserName, orderStatus, startTime, endTime);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	
	
	
	

	
	
	@Path("/shipper_date_aggregate_time")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipperDateAggregateTime(
			@QueryParam("shipperUserName") @DefaultValue("") String shipperUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shipperUserName, User.role_shipper, sessionKey);
		JSONObject res;
		if(authen) {
			
			res = OrderLogic.getShipperAggregateByTime(shipperUserName, orderStatus, startTime, endTime);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	@Path("/shop_date_aggregate_time")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShopDateAggregateTime(
			@QueryParam("shopUserName") @DefaultValue("") String shopUserName,
			@QueryParam("orderStatus") @DefaultValue("-1") int orderStatus,
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@Context HttpServletRequest req) {
		String sessionKey = req.getHeader("sessionKey");
		
		boolean authen = AccountLogic.checkUserSession(shopUserName, User.role_shop, sessionKey);
		JSONObject res;
		if(authen) {
			res = OrderLogic.getShopAggregateByTime(shopUserName, orderStatus, startTime, endTime);
			
		} else {
			res = AccountLogic.genErrorSession();
		}
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Path("/get_ship_order_list")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipOrderList(
			@QueryParam("shipperUserName") @DefaultValue("") String userName, 
			@QueryParam("status") @DefaultValue("-1") int status, 
			@QueryParam("offset") @DefaultValue("-1") int offset, 
			@QueryParam("numb") @DefaultValue("-1") int numb,
			@Context HttpServletRequest req) {
		
		String sessionKey = req.getHeader("sessionKey");
		boolean authen = AccountLogic.checkSession(sessionKey);
		JSONObject res;
		if(authen) {
			if(status >=0 && status <= 6)
				res = OrderLogic.getShipperOrderFullList(userName, status, offset, numb);
			else 
				res = OrderLogic.getShipperOrderFullList(userName, offset, numb);
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_ship_order_list_by_time")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipOrderListByTime(
			@QueryParam("shipperUserName") @DefaultValue("") String userName, 
			@QueryParam("status") @DefaultValue("-1") int status, 
			@QueryParam("startTime") @DefaultValue("0000-00-00 00:00:00") String startTime, 
			@QueryParam("endTime") @DefaultValue("0000-00-00 00:00:00") String endTime, 
			@QueryParam("offset") @DefaultValue("0") int offset, 
			@QueryParam("numb") @DefaultValue("10") int numb,
			@Context HttpServletRequest req) {
		
		String sessionKey = req.getHeader("sessionKey");
		boolean authen = AccountLogic.checkSession(sessionKey);
		JSONObject res;
		if(authen) {
			if(status >=0 && status <= 6)
				res = OrderLogic.getShipperOrderFullByTime(userName, status, startTime, endTime, offset, numb);
			else 
				res = OrderLogic.getShipperOrderFullByTime(userName, startTime, endTime, offset, numb);
		} else {
			res = AccountLogic.genErrorSession();
		}
		
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	
	@Path("/update_config")
	@POST
	@Produces("text/plain;charset=utf-8")
	public Response updateConfig(String info, @Context HttpServletRequest req) {
		String key = "";
		String value = "";
		
		try {
			JSONObject data = new JSONObject(info);


			key = data.getString("key");
			value = data.getString("value");
			
		} catch (Exception e) { 
			logger.error(e);
		}
		
		boolean r = OrderLogic.updateConfig(key, value);
		
		return Response.ok(r).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	
	
	@Path("/get_config")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getConfig(@Context HttpServletRequest req) {
		
		JSONObject res = OrderLogic.getConfig();
		
		
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}

	
}
