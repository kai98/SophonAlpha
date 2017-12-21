package httpAPI;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;

public class ListenerDemo {
	public static int sleepTime = 5000;
	
	public static exAPI[] getCombo() throws IOException, JSONException {
		// Listening API array: 
		
    	exAPI[] combo = new exAPI[4]; 
    	combo[0] = new BP_USDBTC_A();
    	combo[1] = new BP_USDBTC_B();
    	combo[2] = new CB_USDBTC_A();
    	combo[3] = new CB_USDBTC_B();
    	
    	return combo;
    }
	
	
	public static void main(String [] args) throws IOException, JSONException, InterruptedException {
		double time = System.currentTimeMillis();
		exAPI[] combo;
		while(true) {
			//combo version:
			System.out.print (getTime());
			combo = getCombo();
			for(exAPI api : combo) 
				System.out.print(api+"  ");
			for(exAPI api : combo)
				api.save();
			System.out.println();
			
			//simpleSynpase
			simpleSynapse(combo[0],combo[3]);
			simpleSynapse(combo[2],combo[1]);
			
			metronome(time);
			time = System.currentTimeMillis();
		}
	}
	
	public static boolean simpleSynapse(exAPI ask, exAPI bid) {
		// if no data recive from json, return false;
		if(ask.amount.compareTo("NoAmount") == 0 || bid.amount.compareTo("NoAmount") == 0)
			return false;
		double askPrice = Double.parseDouble(ask.amount);
		double bidPrice = Double.parseDouble(bid.amount);
		if(askPrice < bidPrice) {
			System.out.println("WOW");
			System.out.println("Ask: "+ask);
			System.out.println("Bid: "+bid);
			System.out.println("Diff: " + (bidPrice - askPrice));
			return true;
		}
		return false;
	}
	
    public static String getTime() {
    	Date day=new Date();    
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	return  "("+ df.format(day)+")  ";   
    }
    
    public static void metronome( double prevTime) throws InterruptedException {
    	double time = System.currentTimeMillis();
    	double inteval = sleepTime - (time - prevTime);
    	if(inteval > 0)
    	Thread.sleep((long) inteval);
    }
}
