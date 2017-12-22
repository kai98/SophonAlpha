package comp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;

import bitstamp.*;
import coinbase.*;
import bittrex.*;
import huobi.*;

public class ListenerDemo {
	public static int sleepTime = 5000;
	
	public static exAPI[] getCombo() throws IOException, JSONException {
		// Listening API array: 
		
    	exAPI[] combo = new exAPI[4]; 
    	combo[0] = new bp_ethbtc_A();
    	combo[1] = new bp_ethbtc_B();
    	combo[2] = new hb_ethbtc_A();
    	combo[3] = new hb_ethbtc_B();
    	
    	return combo;
    }
	
	
	public static void main(String [] args) throws IOException, JSONException, InterruptedException {
		System.out.println("--------------------SophonAlpha--------------------");
		double time = System.currentTimeMillis();
		exAPI[] combo;
		while(true) {
			//combo version:
//			System.out.print (getTime());
//			combo = getCombo();
//			for(exAPI api : combo) 
//				System.out.print(api+"  ");
//			for(exAPI api : combo)
//				api.save();
//			System.out.println();
//			
//			//simpleSynpase
//			simpleSynapse(combo[0],combo[3]);
//			simpleSynapse(combo[2],combo[1]);
//			
//			metronome(time);
//			time = System.currentTimeMillis();
			//String Version:
			String str = "\n";
			str += (getTime());
			combo = getCombo();
			for(exAPI api : combo) 
				str+=(api+"  ");
			for(exAPI api : combo)
				api.save();
			System.out.print(str);
			
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
		double askPrice = Double.parseDouble(ask.amount)*(1+ask.fee);
		double bidPrice = Double.parseDouble(bid.amount)*(1+bid.fee);
		double diff = bidPrice - askPrice;
		System.out.print(" Diff: " + diff);
		
		// gap should be a percentage that diff have with ask;
		double gap = 0/diff;
		if(bidPrice - askPrice > gap) {
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
