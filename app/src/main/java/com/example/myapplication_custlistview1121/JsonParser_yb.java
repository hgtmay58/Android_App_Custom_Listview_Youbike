package com.example.myapplication_custlistview1121;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class JsonParser_yb {
	MainActivity m;
	// constructor
	public JsonParser_yb(MainActivity c) {
      m=c;
	}

	/**
	 * Getting XML from URL making HTTP request
	 * @param url string
	 * */
	public void  getjsonFromUrl(final String url) {

			//http
			Thread okHttpExecuteThread = new Thread() {
				@Override
				public void run() {
					final String xml;
			       okhttp_util linkweb=new okhttp_util();
	         		xml=linkweb.urlget(url);
					Log.d(" TAG ", xml);
					m.runOnUiThread(new Runnable() {
										@Override
										public void run() {
											//
											try {

												JSONArray warray = new JSONArray(xml);
												//
												for (int i = 0; i < warray.length(); i++) {
													// creating new HashMap
													HashMap<String, String> map = new HashMap<String, String>();
													JSONObject jsonObject = warray.getJSONObject(i);
													String locationName = jsonObject.getString("sna");
													String lat = jsonObject.getString("lat");
													String lon = jsonObject.getString("lng");
													String sno = jsonObject.getString("sno");
													String sbi = jsonObject.getString("sbi");
													String bemp = jsonObject.getString("bemp");
													String sarea = jsonObject.getString("sarea");
													String tot = jsonObject.getString("tot");
													String addr = jsonObject.getString("ar");
													// adding each child node to HashMap key => value
													map.put(m.KEY_ID, sno);
													map.put(m.KEY_TITLE, locationName+"-"+sarea);
													map.put(m.KEY_lat, lat);
													map.put(m.KEY_lon, lon);
													map.put(m.KEY_DURATION,sno );
													map.put(m.KEY_addr,addr );
													map.put(m.KEY_ARTIST, "容量:"+tot+",目前可借:" + sbi + "台,可還:" + bemp + "台");


													// /
													// adding HashList to ArrayList
													m.bList.add(map);

												}
												//

												// Getting adapter by passing xml data ArrayList
												m.adapter = new LazyAdapter(m, m.bList);
												m.list.setAdapter(m.adapter);


											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
										}
									});
							//


							}

		};                    // Start the child thread.
		okHttpExecuteThread.start();





	}
	
   //計算出距離
	public double Distance(double latitude1,double longitude1, double latitude2, double longitude2)
	{
		double radLatitude1 = latitude1 * Math.PI / 180;
		double radLatitude2 = latitude2 * Math.PI / 180;
		double l = radLatitude1 - radLatitude2;
		double p = longitude1 * Math.PI / 180 - longitude2 * Math.PI / 180;
		double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(l / 2), 2)
				+ Math.cos(radLatitude1) * Math.cos(radLatitude2)
				* Math.pow(Math.sin(p / 2), 2)));
		distance = distance * 6378137.0;
		distance = Math.round(distance * 10000) / 10000;

		return distance ;
	}



}
