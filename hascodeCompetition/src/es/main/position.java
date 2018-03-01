package es.main;

public class position {

	int x;
	int y;
	
	public position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int distance(position p) {
		return  Math.abs(this.x - p.x) + Math.abs(this.y - p.y); 
	}
	
	public void acercarse(position dest) {
		
		if(this.x > dest.x) {
			this.x--;
		}else if(this.x < dest.x) {
			this.x++;
		}else {
			if(this.y > dest.y) {
				this.y--;
			}else if(this.y < dest.y) {
				this.y++;
			}
		}
		
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		position other = (position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}
