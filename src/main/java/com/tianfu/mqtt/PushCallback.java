package com.tianfu.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;
import com.tianfu.dao.LightOnDao;
import com.tianfu.dao.MqttSaveDao;
import com.tianfu.dao.SportDataDao;
import com.tianfu.po.mqtt_save;
import com.tianfu.util.JsonBean;
import com.tianfu.util.JsonTransfer;
import com.tianfu.util.LightOnBean;
import com.tianfu.util.SportDataBean;

public class PushCallback implements MqttCallback {

	public void connectionLost(Throwable cause) {
		// 连接丢失后，一般在这里面进行重连
		System.out.println("连接断开，可以做重连111111");
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("deliveryComplete---------" + token.isComplete());
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// subscribe后得到的消息会执行到这里面
		System.out.println("接收消息主题 : " + topic);
		System.out.println("接收消息Qos : " + message.getQos());
		System.out.println("接收消息内容 : " + new String(message.getPayload()));
		
		String messageInfo = new String(message.getPayload());
		/* System.out.println("messageInfo:"+messageInfo); */

		/*
		 * int user_mac; String createtime; float tmp; int hr;
		 */
		if (!messageInfo.equalsIgnoreCase("close")) {

			/*
			 * MqttSaveDao mqttSaveDao = new MqttSaveDao(); for (int i = 0; i < 2; i++) {
			 * mqttSaveDao.addMqttSave(topic, message.getQos(), messageInfo); }
			 */

			Gson gson = new Gson();
			LightOnDao lightOnDao = new LightOnDao();
			LightOnBean lightOnBean = gson.fromJson(messageInfo, LightOnBean.class);
			System.out.println("转化后的数据："+lightOnBean.toString());
			lightOnDao.addLightOn(lightOnBean.getTreet_number(), lightOnBean.getLight_content().get(0).getLight_number(), 
					lightOnBean.getLight_content().get(0).getAcquisition_time(),
					lightOnBean.getLight_content().get(0).getLight_intensity(), 
					lightOnBean.getLight_content().get(0).getTurnonoff());
			/*
			 * SportDataDao sportDataDao = new SportDataDao();
			 * System.out.println(messageInfo); SportDataBean sportDataBean =
			 * gson.fromJson(messageInfo, SportDataBean.class);
			 * 
			 * System.out.println("转化后的数据："+sportDataBean.toString());
			 * System.out.println("dfsdjfdskl");
			 * System.out.println("GetSportContent:"+sportDataBean.getSportcontents().
			 * toString()); System.out.println("why");
			 * 
			 * 
			 * for (int i = 0; i < sportDataBean.getSportcontents().size(); i++) { user_mac
			 * = sportDataBean.getUser_mac(); System.out.println(user_mac); createtime =
			 * sportDataBean.getSportcontents().get(i).getCreate_time();
			 * System.out.println(createtime); tmp =
			 * sportDataBean.getSportcontents().get(i).getTmp(); System.out.println(tmp); hr
			 * = sportDataBean.getSportcontents().get(i).getHr(); System.out.println(hr);
			 * sportDataDao.addSportData(user_mac, createtime, tmp, hr);
			 * System.out.println("success"); }
			 */

		}

	}
}
