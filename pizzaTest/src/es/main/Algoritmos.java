package es.main;

import java.util.ArrayList;
import java.util.List;

public class Algoritmos {

	public EvolucionPizza fuerzaBruta(Pizza pizza) {
		EvolucionPizza evolucion = new EvolucionPizza(pizza);
		ArrayList<EvolucionPizza> arbolEvoluciones = new ArrayList<>();
		arbolEvoluciones.add(evolucion);
		int rows = evolucion.rows;
		int cols = evolucion.cols;
		ArrayList<EvolucionPizza> arbolEvoluciones2 = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (EvolucionPizza evolucionPizza : arbolEvoluciones) {
					List<Slice> slices = GeneradorSlice.generaSlice(pizza.maxCells, i, j);
					arbolEvoluciones2.add(evolucionPizza);
					for (Slice slice : slices) {
						if(CompruebaRestricciones.comprueba(evolucionPizza, slice, pizza.numIngrdientsPerSlice)){
							EvolucionPizza next = evolucionPizza.clone();
							next.actualiza(slice);
							arbolEvoluciones2.add(next);
						}
					}				
				}
				arbolEvoluciones = (ArrayList)arbolEvoluciones2.clone();
			}			
		}
		
		return maximaPuntuacion(arbolEvoluciones);	
		
	}
	
	private EvolucionPizza maximaPuntuacion(List<EvolucionPizza> resultados){
		EvolucionPizza rfinal = resultados.get(0);
		int puntos = rfinal.damePuntuacion();
		for (EvolucionPizza evolucionPizza : resultados) {
			int puntos1 = evolucionPizza.damePuntuacion();
			if(puntos1 > puntos){
				rfinal = evolucionPizza;
				puntos = puntos1;
			}
		}
		return rfinal;
	}
}
