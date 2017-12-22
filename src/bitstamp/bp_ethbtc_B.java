package bitstamp;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

public class bp_ethbtc_B extends exAPI {
	public bp_ethbtc_B() throws IOException, JSONException {
		fee = -0.25 / 100;
		exchange = "BP-A";
		base = "ETH";
		counter = "BTC";
		link = "https://www.bitstamp.net/api/v2/ticker/ethbtc";
		JSONObject json = getInfo(link);
		data = getData(json);
		amount = getAmount(json, "bid");
		date = getDate();
		time = getTime();
	}
}
