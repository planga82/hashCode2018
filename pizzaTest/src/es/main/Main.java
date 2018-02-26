package es.main;

import java.util.List;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		Pizza p = new Pizza(Utils.readFromFile("/home/pablo/EntornosTrabajo/hashcode2018/pizzaTest/small.in"));
		p.toString();
		//List<Slice> g = GeneradorSlice.generaSlice(6,1);
		//g.toString();

	}
}
