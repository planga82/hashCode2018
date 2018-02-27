package es.main;

import java.util.ArrayList;
import java.util.List;

public class EvolucionPizza {

	int rows;
	int cols;
	Celda[][] base;
	List<Slice> slicesSeleccionados;
	
	public EvolucionPizza(){
		super();
	}
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
	
	public EvolucionPizza clone(){
		EvolucionPizza ev = new EvolucionPizza();
		ev.cols = this.cols;
		ev.rows = this.rows;
		ev.base = this.base.clone();
		ev.slicesSeleccionados =  (ArrayList)((ArrayList<Slice>)this.slicesSeleccionados).clone();
		return ev;
	}
	
	public void actualiza(Slice s){
		this.slicesSeleccionados.add(s);
		for (int i = s.posRowIni; i < s.posRowIni + s.rows; i++) {
			for (int j = s.posColIni; j < s.posColIni + s.cols; j++) {
				this.base[i][j].withSlice = true;
			}
		}
	}
	
}
