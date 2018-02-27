package es.main;

public class CompruebaRestricciones {

	
	
	public static boolean comprueba(EvolucionPizza estadoPizza, Slice slice, int numIngrdientsPerSlice) {
		
		return !seSalePizza(estadoPizza, slice) && 
				!pisaOtroSlice(estadoPizza, slice) &&
				contieneIngredientesAdecuados(estadoPizza, slice, numIngrdientsPerSlice);		
	}
	
	//comprueba que no se sale de la pizza
	private static boolean seSalePizza(EvolucionPizza estadoPizza, Slice slice) {
		return (slice.posRowIni + slice.rows > estadoPizza.rows) ||
				(slice.posColIni + slice.cols > estadoPizza.cols); 
	}
	//comprueba que no pisa otro slice
	private static boolean pisaOtroSlice(EvolucionPizza estadoPizza, Slice slice) {
		for (int i = 0; i < slice.rows; i++) {
			for (int j = 0; j < slice.cols; j++) {
				int row = slice.posRowIni+i;
				int col = slice.posColIni+j;
				if(estadoPizza.base[row][col].withSlice) {
					return true;
				}				
			}
		} 
		return false;
	}
	
	//Contiene el numero de ingredientes adecuado
		private static boolean contieneIngredientesAdecuados(EvolucionPizza estadoPizza, Slice slice, int numIngrdientsPerSlice) {
			
			int tomato =0;
			int mushroom=0;
			for (int i = 0; i < slice.rows; i++) {
				for (int j = 0; j < slice.cols; j++) {
					int row = slice.posRowIni+i;
					int col = slice.posColIni+j;
					if(estadoPizza.base[row][col].getIngrediente() == 'T') {
						tomato++;
					}else {
						mushroom++;
					}
				}
			} 
			return tomato>=numIngrdientsPerSlice && mushroom>=numIngrdientsPerSlice;
			
		}
	
}
