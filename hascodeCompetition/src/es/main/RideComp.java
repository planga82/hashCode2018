package es.main;

import java.util.Comparator;

public class RideComp implements Comparator<Ride> {

	Car car;
	
	public RideComp (Car car) {
	 this.car=car;	
	}
	
	@Override
	public int compare(Ride o1, Ride o2) {
//		if (o1.earlyStart < o2.earlyStart) {
//			return -1;
//		} else if (o1.earlyStart > o2.earlyStart) {
//			return 1;
//		}

		int d1 = car.actual.distance(o1.start);
		int d2 = car.actual.distance(o2.start);
		return d1-d2; 
	}
	
	

}
