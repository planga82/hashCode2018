package es.main;

import java.util.ArrayList;
import java.util.List;

public class GeneradorSlice {

	public static List<Slice> generaSlice(int maxCells, int posXIni, int posYIni) {
		
		List<Slice> salida = new ArrayList<>();
		if(maxCells==0) {
			return salida;
		}else {		
			salida.addAll(generaSlice(maxCells-1,posXIni, posYIni));
			for (int i = 1; i <= maxCells; i++) {
				for (int j = 1; j <= maxCells; j++) {
					if(i*j == maxCells) {
						Slice l = new Slice(i, j, posXIni, posYIni);
						salida.add(l);
					}
				}			
			}
			return salida;			
		}
		
		
	}
}
