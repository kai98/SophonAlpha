package comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Saver {
	public static String path = "data";
	public static void Save(String fileName, String content) throws FileNotFoundException {
		// check if the file exist.
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("Make a file");
			file.mkdir();
		}
		String dataPath = path+"/"+fileName+".txt";
		
		File dir = new File(dataPath);
		PrintWriter out = null;
		if(dir.exists()) {
			try {
				out = new PrintWriter(new FileWriter(dataPath, true));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("new File created");
			out = new PrintWriter(dataPath);
		}

		out.println(content);
		out.close();
	}
	
	public static void main(String[] args) {
		Saver saver = new Saver();
		try {
			saver.Save("coinbase", "Meh");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
