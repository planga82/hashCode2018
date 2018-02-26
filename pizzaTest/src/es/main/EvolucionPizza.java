package es.main;

import java.util.ArrayList;
import java.util.List;

public class EvolucionPizza {

	int rows;
	int cols;
	Celda[][] base;
	List<Slice> slicesSeleccionados;
	
	public EvolucionPizza(Pizza pizza) {
		this.cols = pizza.cols;
		this.rows = pizza.rows;
		base = new Celda[this.rows][this.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				base[i][j] = new Celda(pizza.base[i][j],false);
			}
		}
		this.slicesSeleccionados = new ArrayList<>();
	}
	
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public Celda[][] getBase() {
		return base;
	}
	public void setBase(Celda[][] base) {
		this.base = base;
	}
	
	
}
