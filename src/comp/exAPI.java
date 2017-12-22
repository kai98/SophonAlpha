package comp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class exAPI {

	public String date;
	public String exchange = "default exchange";
	public String base = "default base";
	public String counter = "default counter";
	public String amount; // price
	public String link;
	public String data;
	public String time;
	public double fee; // fee is a double. + if it's Ask, - if it's Bid
	

	public String toString() {
		return exchange + "_" + base + "/" + counter + ": " + amount;
	}

	public static String getTime() {
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return "(" + df.format(day) + ")";
	}
	
	public static String getDate() {
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "(" + df.format(day) + ")";
	}

	public static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	
	//old get info
//	public JSONObject getInfo(String url) throws IOException, JSONException {
//			InputStream is = null; 
//		try {
//			//moved to try
//			is = new URL(url).openStream();
//			
//			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//			String jsonText = readAll(rd);
//			if(!isJSON(jsonText))
//				return null;
//			JSONObject json = new JSONObject(jsonText);
//			return json;
//		} 
//		catch(IOException e){
//			e.printStackTrace();
//			return null;
//		}
//		catch(JSONException e) {
//			e.printStackTrace();
//			return null;
//		}
//		finally {
//			is.close();
//		}
//	}
	
	// not yet used
	public String getStr (String address) throws IOException{
		URL url = new URL(address);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setConnectTimeout(2000);
		conn.connect();
		InputStream is = conn.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		String strText = readAll(rd);
		return strText;
		}
	
	//enhanced get info.
	public JSONObject getInfo(String address) throws IOException{
		URL url = new URL(address);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setConnectTimeout(2000);
		conn.connect();
		InputStream is = conn.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		String strText = readAll(rd);
		if(!isJSON(strText))
			return null;
		JSONObject json = null;
		try {
			json = new JSONObject(strText);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public boolean isJSON(String jsonText) {
		if(jsonText.isEmpty() || jsonText.charAt(0) != '{') {
			return false;
		}
		return true;
	}
	
	public static String getAmount(JSONObject json, String key) throws JSONException {
		if (json == null) {
			return "NoAmount";
		}
		return json.getString(key);
	}
	
	public static String getData(JSONObject json) {
		if (json == null) {
			return "NoData";
		}
		return json.toString();
	}
	
	public void save() {
		String fileName = date + " " + exchange + "_" + base + "$" + counter;
		String content = time+" "+amount;
		try {
			Saver.Save(fileName, content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
