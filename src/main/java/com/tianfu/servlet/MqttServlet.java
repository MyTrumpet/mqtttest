package com.tianfu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.tianfu.dao.MqttSaveDao;
import com.tianfu.po.mqtt_save;
import com.tianfu.util.Content;
import com.tianfu.util.JsonBean;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class MqttServlet
 */
@WebServlet("/MqttServlet")
public class MqttServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MqttServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * response.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html;charset=utf-8"); MqttSaveDao mqttSaveDao =
		 * new MqttSaveDao();
		 * 
		 * try { List<mqtt_save> mqtt_saves = mqttSaveDao.getAllMqtt_saves();
		 * PrintWriter out = response.getWriter();
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		MqttSaveDao mqttSaveDao = new MqttSaveDao();
		String title = "mqtt_data";
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset=\"utf-8\">");
		out.println("<title>" + title + "</title>");
		out.println("</head><body>");

		try {
			List<mqtt_save> mqtt_saves = mqttSaveDao.getAllMqtt_saves();

			System.out.println("查询到的数据：" + mqtt_saves.toString());
			PrintWriter writer = response.getWriter();
			writer.print(mqtt_saves);
			writer.flush();
			writer.close();

			for (int i = 0; i < mqtt_saves.size(); i++) {

				out.print("<table border=\"1\" align=\"left\">");
				out.println("<tr><th colspan=\"2\">mqtt传输的数据</th></tr>");
				out.println("<tr><th>messageid</th><th>message</th></tr>");
				int jsonid = mqtt_saves.get(i).getMessageid();

				String json = mqtt_saves.get(i).getMessage();
				out.println("<tr><td>" + jsonid + "</td>");
				out.println("<td>" + json + "</td></tr>");

				Gson gson = new Gson();
				JsonBean jsonBean = gson.fromJson(json, JsonBean.class);

				String gateway_mac = jsonBean.getGateway_mac();
				out.print("<table border=\"1\" align=\"left\">");
				out.println("<tr><th colspan=\"2\">解析后的数据</th></tr>");
				out.println("<tr>" + "<th>gateway_mac</th>" + "<td>" + gateway_mac + "</td>" + "</tr>");
				List<Content> contents = jsonBean.getContent();
				for (int j = 0; j < contents.size(); j++) {
					String tag_mac = contents.get(j).getTag_mac();
					float tmp = contents.get(j).getTmp();
					String rssi = contents.get(j).getRssi();

					out.println("<tr>" + "<th>tag_mac</th>" + "<td>" + tag_mac + "</td>" + "</tr>");
					out.println("<tr>" + "<th>tmp</th>" + "<td>" + tmp + "</td>" + "</tr>");
					out.println("<tr>" + "<th>rssi</th>" + "<td>" + rssi + "</td>" + "</tr>");
				}
				out.println("</table>");

			}
			out.println("</table>");

			out.println("</body></html>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
