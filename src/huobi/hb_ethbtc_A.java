package huobi;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

// java-json.jar required;

public class hb_ethbtc_A extends exAPI{
    public hb_ethbtc_A() throws IOException, JSONException {
    	fee = +0.2/100;
        exchange = "HB_A";
        base = "ETH";
        counter = "BTC";
        link = "https://api.huobi.pro/market/detail/merged?symbol=ethbtc";
        data = getStr(link);;
        amount = getData(data);
        date = getDate();
        time = getTime();
    }
    
    //huobi get data method, not using json;
    public String getData (String str) {

    	String[] arr = str.split(",\"");
//    	int count = 0;
//    	for(String str2 : arr) {
//    		System.out.println(count++ +" "+str2);
//    		
//    	}
    	int index = 11; // change this one;
    	String ask = arr[index];
    	arr = arr[index].split("\\[|,");
    	return arr[1];
    }
    
    
    public static void main(String[] args) {
    	exAPI test = null;
		try {
			test = new hb_ethbtc_A();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(test);
    }
}
