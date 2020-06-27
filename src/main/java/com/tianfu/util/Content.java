package com.tianfu.util;

public class Content {
	
		private String tag_mac;
		private float tmp;
		private String rssi;
		public String getTag_mac() {
			return tag_mac;
		}
		public void setTag_mac(String tag_mac) {
			this.tag_mac = tag_mac;
		}
		public float getTmp() {
			return tmp;
		}
		public void setTmp(float tmp) {
			this.tmp = tmp;
		}
		public String getRssi() {
			return rssi;
		}
		public void setRssi(String rssi) {
			this.rssi = rssi;
		}
		@Override
		public String toString() {
			return "Content [tag_mac=" + tag_mac + ", tmp=" + tmp + ", rssi=" + rssi + "]";
		}
	
}
