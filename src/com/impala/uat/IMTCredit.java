/**
 * 
 */
package com.impala.uat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author fred
 *
 */
public class IMTCredit {

	//private static final String USER_AGENT = null;
	private final String USER_AGENT = "Mozilla/5.0";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		IMTCredit http = new IMTCredit();

		//System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet();

		System.out.println("\nTesting Fusion - Send Http POST request");
		http.sendPost();

	}
	
	// HTTP POST request
		private void sendPost() throws Exception {

			String url = "http://portals.nsano.com:9000/api/fusion_dev/thirdParty/IMT/";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "tag=3rdpartycredit&"
					+ "apikey=d7dd4c4982494701a8491c5180fe2bea&"
					+ "refID=TRANS12345678&"
					+ "sender=PeterAlexandre&"
					+ "sender_country=GH&"
					+ "receiver=KofiSarpong&"
					+ "receiver_msisdn=233276819324&"
					+ "receiver_country=GH&"
					+ "amount=0.80&"
					+ "mno=TIGO"
					;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());
			
//			JSONParser parser = new JSONParser();
//
//	        try {
//
//	            Object obje = parser.parse(new Response<T>() {
//				});
//
//	            JSONObject jsonObject = (JSONObject) obje;
//	            System.out.println(jsonObject);
//
//	            String name = (String) jsonObject.get("name");
//	            System.out.println(name);
//
//	            long age = (Long) jsonObject.get("age");
//	            System.out.println(age);
//
//	            // loop array
//	            JSONArray msg = (JSONArray) jsonObject.get("messages");
//	            Iterator<String> iterator = msg.iterator();
//	            while (iterator.hasNext()) {
//	                System.out.println(iterator.next());
//	            }
//
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	        }


}
		}
