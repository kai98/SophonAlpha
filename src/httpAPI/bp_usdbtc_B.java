package httpAPI;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

public class bp_usdbtc_B extends exAPI{
	public bp_usdbtc_B() throws IOException, JSONException{
	        exchange = "BP-B";
	        base = "BTC";
	        counter = "USD";
	        link = "https://www.bitstamp.net/api/v2/ticker/btcusd";
	        JSONObject json = getInfo(link);
	        data = getData(json);
	        amount = getAmount(json,"bid");
	        date = getDate();
	        time = getTime();
	}
}
