
public class Minge {
	
	private int X, Y;

	public Minge(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
	
	public void suteaza() throws ExceptieOut, ExceptieCorner, ExceptieGol{
		CoordinateGenerator cg = new CoordinateGenerator();
		
		this.X = cg.generateX();
		this.Y = cg.generateY();
		
		if(Y == 0 || Y == 50) {
			throw new ExceptieOut("Out!");
		}
		if(X == 0 || X == 100) {
			if(Y < 20 || Y > 30) {
				throw new ExceptieCorner("Corner!");
			}
		}
		else {
			throw new ExceptieGol("Gol");
		}
		
	}
}
