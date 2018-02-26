package es.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	
	public static List<String> readFromFile(String file) throws IOException {
		List<String> lineas = new ArrayList<>();
		String cadena;
	    FileReader f = new FileReader(file);
	    BufferedReader b = new BufferedReader(f);
	    while((cadena = b.readLine())!=null) {
	        lineas.add(cadena);
	    }
	    b.close();
	    return lineas;
	}
}
