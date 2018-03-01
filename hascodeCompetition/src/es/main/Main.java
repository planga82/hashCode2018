package es.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		String a_example = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/a_example.in";
		String b_should_be_easy = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/b_should_be_easy.in";
		String c_no_hurry = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/c_no_hurry.in";
		String d_metropolis = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/d_metropolis.in";
		String e_high_bonus = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/e_high_bonus.in";
		
		
		

		
		String fichEntr = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/a_example.in";
		String fichSal = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/a_example.ou";
		procesar(fichEntr, fichSal);
		
		fichEntr = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/b_should_be_easy.in";
		fichSal = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/b_should_be_easy.ou";
		procesar(fichEntr, fichSal);

		fichEntr = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/c_no_hurry.in";
		fichSal = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/c_no_hurry.ou";
		procesar(fichEntr, fichSal);
		
		fichEntr = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/d_metropolis.in";
		fichSal = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/d_metropolis.ou";
		procesar(fichEntr, fichSal);
		
		fichEntr = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/e_high_bonus.in";
		fichSal = "/home/pablo/EntornosTrabajo/hashcode2018/hascodeCompetition/e_high_bonus.ou";
		procesar(fichEntr, fichSal);
		
		

	}
	
	public static void procesar(String fichEntr, String fichSal) throws Exception {
		//[Escenario, List<Ride>]
//		Object[] a = leeFicheroOrigen.lecturaOrigen(a_example);
//		Object[] a = leeFicheroOrigen.lecturaOrigen(b_should_be_easy);
//		Object[] a = leeFicheroOrigen.lecturaOrigen(c_no_hurry);
//		Object[] a = leeFicheroOrigen.lecturaOrigen(d_metropolis);
//		Object[] a = leeFicheroOrigen.lecturaOrigen(e_high_bonus);
		Object[] a = leeFicheroOrigen.lecturaOrigen(fichEntr);

		Escenario escen = ((Escenario)a[0]);
		
		ArrayList<Ride> listaViajes = ((ArrayList<Ride>)a[1]);
		ArrayList<Car> coches = new ArrayList<>();
		
		Collections.sort(listaViajes);
		
		
		for (int i = 0; i < escen.numVehicles; i++) {
			coches.add(new Car(i));
		}
		
		
		for (int tiempo = 0; tiempo < escen.steps; tiempo++) {
			//Por cada coche
			for (Car car : coches) {
				if(car.estado==0) {
					//Asignar
					//Comprobar si la distancia al inicio es menor que el tiempo que tenemos para llegar
					ArrayList<Ride> posibles = new ArrayList<Ride>();
					for (Ride viaje : listaViajes) {
//						if(comprobarDaTiempoALlegar(car, viaje, tiempo)) {
//							car.viajesPlanificados.add(viaje);
//							if(car.actual.distance(viaje.start) == 0) {
//								car.estado = 2;
//								car.destino = viaje.finish;
//							}else {
//								car.estado = 1;
//								car.destino = viaje.start;
//							}
//							break;							
//						}
						if(comprobarDaTiempoALlegar(car, viaje, tiempo)) {
							posibles.add(viaje);
						}
					}
					if (posibles!=null && posibles.size()>0) {
						Collections.sort(posibles,new RideComp(car));
						Ride viaje = posibles.get(0);
						
						car.viajesPlanificados.add(viaje);
						if(car.actual.distance(viaje.start) == 0) {
						car.estado = 2;
							car.destino = viaje.finish;
						}else {
							car.estado = 1;
							car.destino = viaje.start;
						}
						listaViajes.removeAll(car.viajesPlanificados);					
					}
				}
				if(car.estado==1) {
					//Avanzar al inicio
					car.avanzarAInicio();
				}else if (car.estado==2){
					//Avanzar a destino
					car.avanzarADestino();
				}
			}
		}
		EscribeAFicheroResultado.escribe(fichSal, coches);

	}
	
	
	
	public static boolean comprobarDaTiempoALlegar(Car coche, Ride viaje, int tiempoActual) {
		//Comprobar si la distancia al inicio es menor que el tiempo que tenemos para llegar
		
		int distancia = coche.actual.distance(viaje.start);
		
		return (tiempoActual + distancia < viaje.latestFinish - viaje.start.distance(viaje.finish));
	}

}
