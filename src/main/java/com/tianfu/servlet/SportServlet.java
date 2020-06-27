package com.tianfu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tianfu.dao.MqttSaveDao;
import com.tianfu.dao.SportDataDao;
import com.tianfu.po.SportData;
import com.tianfu.po.Sys;
import com.tianfu.po.mqtt_save;

import net.sf.json.JSONObject;

@WebServlet("/SportServlet")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		request.getParameter("user_mac");
		SportDataDao sportDataDao = new SportDataDao();
		try {
			Gson gson = new Gson();

			List<SportData> sportDatas = sportDataDao.getAllSportDatas();
			System.out.println(sportDatas);
			String jString = gson.toJson(sportDatas);

			/*
			 * JSONArray.fromObject(list).toString()
			 */
			response.getWriter().print(jString.toString());
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
