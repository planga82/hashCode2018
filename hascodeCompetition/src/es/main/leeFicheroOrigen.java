package es.main;

import java.util.ArrayList;
import java.util.List;

public class leeFicheroOrigen {

	public static Object[] lecturaOrigen(String file) throws Exception {
		List<String> lines =Utils.readFromFile(file);
		String linea1 = lines.get(0);
		String[] campos = linea1.split(" ");
		
		Object[] ret = new Object[2];
		
		Escenario escenario = new Escenario(Integer.parseInt(campos[0]),
				Integer.parseInt(campos[1]),
				Integer.parseInt(campos[2]),
				Integer.parseInt(campos[3]),
				Integer.parseInt(campos[4]),
				Integer.parseInt(campos[5]));
		
		ArrayList<Ride> rides = new ArrayList<>();
		
		for (int i = 1; i < lines.size(); i++) {
			campos = lines.get(i).split(" ");
			Ride ride = new Ride(i-1,Integer.parseInt(campos[0]),
					Integer.parseInt(campos[1]),
					Integer.parseInt(campos[2]),
					Integer.parseInt(campos[3]),
					Integer.parseInt(campos[4]),
					Integer.parseInt(campos[5]));
			rides.add(ride);
		}
		
		ret[0] = escenario;
		ret[1] = rides;
		
		return ret;
		
	}
}
