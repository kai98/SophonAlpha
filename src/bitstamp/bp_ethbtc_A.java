package bitstamp;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

public class bp_ethbtc_A extends exAPI{
	public bp_ethbtc_A() throws IOException, JSONException{
	        exchange = "BP-A";
	        base = "ETH";
	        counter = "BTC";
	        link = "https://www.bitstamp.net/api/v2/ticker/ethbtc";
	        JSONObject json = getInfo(link);
	        data = getData(json);
	        amount = getAmount(json,"ask");
	        date = getDate();
	        time = getTime();
	}
}

