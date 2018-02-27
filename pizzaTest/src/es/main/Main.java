package es.main;

import java.util.List;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		//Pizza p = new Pizza(Utils.readFromFile("/home/pablo/EntornosTrabajo/hashcode2018/pizzaTest/example.in"));
		Pizza p = new Pizza(Utils.readFromFile("D:\\EntornosDesarrollo\\WorkspaceHashcode\\hashCode2018\\pizzaTest\\small.in"));
		
		new Algoritmos().fuerzaBruta(p);

	}
}
