package httpAPI;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

// java-json.jar required;

public class hb_ethbtc_A extends exAPI{
    public hb_ethbtc_A() throws IOException, JSONException {
        exchange = "CB-B";
        base = "ETH";
        counter = "BTC";
        link = "https://api.huobi.pro/market/detail/merged?symbol=ethbtc";
        
        JSONObject json = getInfo(link);
 //       String str = enhancedInfo(link);
   //     System.out.println(str);
        data = getData(json);
 //       amount = getAmount((JSONObject) json.get("tick"),"bid");
        System.out.println(((JSONObject) json.get("tick")).get("bid"));
        date = getDate();
        time = getTime();
    }
    
    public static void main(String[] args) {
    	try {
			hb_ethbtc_A test = new hb_ethbtc_A();
			System.out.println(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
