package es.main;

import java.util.ArrayList;
import java.util.List;

public class Algoritmos {

	public void fuerzaBruta(Pizza pizza) {
		EvolucionPizza evolucion = new EvolucionPizza(pizza);
		List<EvolucionPizza> arbolEvoluciones = new ArrayList<>();
		arbolEvoluciones.add(evolucion);
		int rows = evolucion.rows;
		int cols = evolucion.cols;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				List<EvolucionPizza> arbolEvoluciones2 = new ArrayList<>();
				for (EvolucionPizza evolucionPizza : arbolEvoluciones) {
					List<Slice> slices = GeneradorSlice.generaSlice(pizza.maxCells, i, j);
					for (Slice slice : slices) {
						if(CompruebaRestricciones.comprueba(evolucion, slice, pizza.numIngrdientsPerSlice)){
							EvolucionPizza next = evolucionPizza.clone();
							next.actualiza(slice);
							arbolEvoluciones2.add(evolucionPizza);
						}
					}
				}
				arbolEvoluciones = arbolEvoluciones2;				
			}			
		}
		
		
		
	}
}
