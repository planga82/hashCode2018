package es.main;

import java.util.List;

import javax.rmi.CORBA.Util;

public class Main {

	
	public static void main(String[] args) throws Exception {
		
		//Pizza p = new Pizza(Utils.readFromFile("/home/pablo/EntornosTrabajo/hashcode2018/pizzaTest/example.in"));
		Pizza p = new Pizza(Utils.readFromFile("D:\\EntornosDesarrollo\\WorkspaceHashcode\\hashCode2018\\pizzaTest\\big.in"));
		
		EvolucionPizza e = new Algoritmos().fuerzaBrutaConPoda(p);
		
		List<String> l = e.toLineasFichero();
		for (String string : l) {
			System.out.println(string);
		}
		
		Utils.writeFile("D:\\EntornosDesarrollo\\WorkspaceHashcode\\hashCode2018\\pizzaTest\\big.ou", l);

	}
}
