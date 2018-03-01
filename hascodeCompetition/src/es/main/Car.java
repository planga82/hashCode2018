package es.main;

import java.util.ArrayList;

public class Car {

	int id;
	position actual;
	position destino;
	
	ArrayList<Ride> viajesPlanificados;
	ArrayList<Integer> idViajesCompletados;
	
	
	//0 libre 
	//1 en camino
	//2 ocupado
	int estado;


	public Car(int id) {
		super();
		this.id = id;
		this.actual = new position(0, 0);
		this.destino = new position(0, 0);;
		this.viajesPlanificados = new ArrayList<>();
		this.idViajesCompletados = new ArrayList<>();
		this.estado = 0;
	}
	
	public void avanzarADestino() {
		this.actual.acercarse(destino);
		if(this.actual.equals(destino)) {
			idViajesCompletados.add(viajesPlanificados.get(0).id);
			viajesPlanificados.remove(0);
			this.estado = 0;
		}
		
	}
	
	public void avanzarAInicio() {
		this.actual.acercarse(destino);
		if(this.actual.equals(destino)) {
			this.destino = viajesPlanificados.get(0).finish;
			this.estado = 2;
		}
	}
	
	

	

}
