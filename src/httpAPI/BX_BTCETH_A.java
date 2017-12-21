package httpAPI;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

public class BX_BTCETH_A extends exAPI{
	public BX_BTCETH_A() throws IOException, JSONException{
	        exchange = "BP-A";
	        base = "BTC";
	        counter = "USD";
	        link = "https://bittrex.com/api/v1.1/public/getticker?market=BTC-ETH";
	        JSONObject json = getInfo(link);
	        data = getData(json);
	        amount = getAmount(json,"Ask");
	        date = getDate();
	        time = getTime();
	}
}