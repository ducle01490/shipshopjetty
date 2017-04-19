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
import com.shipper.model.Shipper;
import com.shipper.util.LoggerUtil;

public class ShipperResource {
	public static Logger logger = LoggerUtil.getDailyLogger("ShopResource_log");
	
	
	public ShipperResource() {
		
		
	}
	
	@Path("/get_shipper_list")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipperList(
			@QueryParam("start") @DefaultValue("0") int start, 
			@QueryParam("number") @DefaultValue("1") int number, 
			@Context HttpServletRequest req) {
		
		
		List<Shipper> data = null;//_dbUtils.getArticleFromDB(cid, start, end);
		logger.info(data.size());
		JSONArray res = new JSONArray(data);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
	@Path("/get_shipper")
	@GET
	@Produces("text/plain;charset=utf-8")
	public Response getShipper(
			@QueryParam("userName") @DefaultValue("") String userName, 
			@Context HttpServletRequest req) {
		
		
		List<Shipper> data = null;//_dbUtils.getArticleFromDB(cid, start, end);
		logger.info(data.size());
		JSONArray res = new JSONArray(data);
		return Response.ok(res.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "PUT, GET, POST, DELETE, OPTIONS").build();
	}
	
}
