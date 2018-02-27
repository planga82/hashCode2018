package es.main;

import java.util.ArrayList;
import java.util.List;

public class Algoritmos {
	
	int limiteMax = 5;
	int poda = 1;
	int saltoColumnas = 20;
	int limiteSlices = 10;

	public EvolucionPizza fuerzaBrutaConPoda(Pizza pizza) {
		EvolucionPizza evolucion = new EvolucionPizza(pizza);
		ArrayList<EvolucionPizza> arbolEvoluciones = new ArrayList<>();
		arbolEvoluciones.add(evolucion);
		int rows = evolucion.rows;
		int cols = evolucion.cols;
		ArrayList<EvolucionPizza> arbolEvoluciones2 = new ArrayList<>();
		for (int i = 0; i < rows; i = i+saltoColumnas) {
			System.out.println("row " + String.valueOf(i) + " de " + String.valueOf(rows));
			for (int j = 0; j < cols; j = j+saltoColumnas) {
				//System.out.println("col " + String.valueOf(j) + " de " + String.valueOf(rows));
				for (EvolucionPizza evolucionPizza : arbolEvoluciones) {
					List<Slice> slices = GeneradorSlice.generaSlice(pizza.maxCells, i, j);
					List<Slice> slices2;
					if(slices.size()>limiteSlices){
						slices2 = new ArrayList<>();
						for (Slice slice : slices) {
							slices2.add(slice);
						}
					}else{
						slices2 = slices;
					}
					//System.out.println(slices.size());
					arbolEvoluciones2.add(evolucionPizza);
					for (Slice slice : slices2) {
						
						if(CompruebaRestricciones.comprueba(evolucionPizza, slice, pizza.numIngrdientsPerSlice)){
							EvolucionPizza next = evolucionPizza.clone();
							next.actualiza(slice);
							arbolEvoluciones2.add(next);
						}
					}				
				}
				arbolEvoluciones = null;
				arbolEvoluciones = poda(arbolEvoluciones2);
				arbolEvoluciones2 =null;
				arbolEvoluciones2 = new ArrayList<>();
				//System.out.println(arbolEvoluciones.size());
			}			
		}
		
		return maximaPuntuacion(arbolEvoluciones);	
		
	}
	
	private ArrayList<EvolucionPizza> poda(ArrayList<EvolucionPizza> arbolEvoluciones){
		if(arbolEvoluciones.size()>limiteMax){
			ArrayList<EvolucionPizza> retorno = new ArrayList<>();
			for (int i = 0; i < poda; i++) {
				EvolucionPizza max = maximaPuntuacion(arbolEvoluciones);
				retorno.add(max);
				arbolEvoluciones.remove(max);
			}
			return retorno;
		}else{
			return (ArrayList)arbolEvoluciones.clone();
		}
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
