package httpAPI;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

public class bx_btceth_B extends exAPI{
	public bx_btceth_B() throws IOException, JSONException{
	        exchange = "BP-A";
	        base = "BTC";
	        counter = "USD";
	        link = "https://bittrex.com/api/v1.1/public/getticker?market=BTC-ETH";
	        JSONObject json = getInfo(link);
	        data = getData(json);
	        amount = getAmount(json,"Bid");
	        date = getDate();
	        time = getTime();
	}
}