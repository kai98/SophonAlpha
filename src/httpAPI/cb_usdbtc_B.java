package httpAPI;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import comp.exAPI;

// java-json.jar required;

public class cb_usdbtc_B extends exAPI{
    public cb_usdbtc_B() throws IOException, JSONException {
        exchange = "CB-B";
        base = "BTC";
        counter = "USD";
        link = "https://api.coinbase.com/v2/prices/BTC-USD/sell";
        JSONObject json = getInfo(link);
        data = getData(json);
        amount = getAmount((JSONObject) json.get("data"),"amount");
        date = getDate();
        time = getTime();
    }
}