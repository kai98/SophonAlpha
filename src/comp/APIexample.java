package comp;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// java-json.jar required;

public class APIexample extends exAPI{
    public APIexample() throws IOException, JSONException {
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
