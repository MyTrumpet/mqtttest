package com.tianfu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.tianfu.dao.LightOnDao;
import com.tianfu.dao.SportDataDao;
import com.tianfu.mqtt.ClientMQTT;
import com.tianfu.mqtt.ServerMQTT;
import com.tianfu.po.LightOn;
import com.tianfu.po.SportData;
import com.tianfu.util.LightContent;
import com.tianfu.util.LightOnBean;


@WebServlet("/LightOnServlet")
public class LightOnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LightOnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.getParameter("lightString");
		
		ClientMQTT client = new ClientMQTT();
		 client.start(); 
		
		
		LightOnDao lightOnDao = new LightOnDao();
		try {
			Gson gson = new Gson();	
			LightOn lightOn = lightOnDao.getLatestLight();
			System.out.println("get中的数据："+lightOn.toString());
			String jString = gson.toJson(lightOn);

			/*
			 * JSONArray.fromObject(list).toString()
			 */
			response.getWriter().print(jString.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* doGet(request, response); */
	
	     response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=utf-8");
		  
		 String results = request.getParameter("result");
		 System.out.println("我们从按钮收到的数据："+results);
		 Gson gson = new Gson();
		 LightOnBean lightOn = gson.fromJson(results, LightOnBean.class);
		 System.out.println(lightOn);
		 
		 try {
			ServerMQTT server = new ServerMQTT();
			server.message = new MqttMessage();
			server.message.setQos(2);
	        server.message.setRetained(true);
	        server.message.setPayload(results.getBytes("UTF-8"));
	        server.publish(server.topic11, server.message);
	        System.out.println(server.message.isRetained() + "------ratained状态");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     

		 
		
	}

}
