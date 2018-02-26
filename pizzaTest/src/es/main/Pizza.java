package es.main;

import java.util.List;

public class Pizza {

	
	int rows;
	int cols;
	char[][] base;
	
	int numIngrdientsPerSlice;
	int maxCells;
	
	public Pizza(List<String> lineasFichero) {
		super();
		String cabecera = lineasFichero.get(0);
		String[] c = cabecera.split(" ");
		this.rows = Integer.parseInt(c[0]);
		this.cols = Integer.parseInt(c[1]);
		this.numIngrdientsPerSlice = Integer.parseInt(c[2]);
		this.maxCells = Integer.parseInt(c[3]);
		base = new char[this.rows][this.cols];
		
		for (int i = 1; i < lineasFichero.size(); i++) {
			char[] lin = lineasFichero.get(i).toCharArray();
			for (int j = 0; j < lin.length; j++) {
				this.base[i-1][j] = lin[j];
			}
		}
		
	}
	
	
	
}
