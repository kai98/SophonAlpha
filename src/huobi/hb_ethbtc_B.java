package huobi;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

// java-json.jar required;

public class hb_ethbtc_B extends exAPI{
    public hb_ethbtc_B() throws IOException, JSONException {
        exchange = "HB_B";
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
    	String bid = arr[13];
    	arr = arr[13].split("\\[|,");
    	return arr[1];
    }
}
