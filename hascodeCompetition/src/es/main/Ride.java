package es.main;

public class Ride implements Comparable<Ride>{

	int id;
	
	position start;
	position finish;
	int earlyStart;
	int latestFinish;
	
	public Ride(int id, int rowStart, int colStart, int rowFinish, int colFinish, int earlyStart, int latestFinish) {
		super();
		this.id=id;
		this.start =new position(rowStart,colStart);
		this.finish = new position(rowFinish, colFinish);
		this.earlyStart = earlyStart;
		this.latestFinish = latestFinish;
	}

//	@Override
//	public int compareTo(Ride o) {
//		int p1 = this.earlyStart;
//		int p2 = o.earlyStart;
//		return p1 - p2;
//	}
	@Override
	public int compareTo(Ride o) {
		int p1 = this.latestFinish - this.finish.distance(this.start);
		int p2 = o.latestFinish - o.finish.distance(o.start);
		return p1 - p2;
	}
	
	
	
}
