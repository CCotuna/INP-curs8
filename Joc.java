
public class Joc {
	
	private String numeEchipa1, numeEchipa2;
	
	private int goluriEchipa1 = 0, goluriEchipa2 = 0;
	private int numarTotalOut = 0;
	private int numarTotalCornere = 0;
	
	
	public Joc(String numeEchipa1, String numeEchipa2) {
		this.numeEchipa1 = numeEchipa1;
		this.numeEchipa2 = numeEchipa2;
	}
	
	@Override
	public String toString() {
		return "Joc [numeEchipa1=" + numeEchipa1 + ", numeEchipa2=" + numeEchipa2 + ", goluriEchipa1=" + goluriEchipa1
				+ ", goluriEchipa2=" + goluriEchipa2 + ", numarTotalOut=" + numarTotalOut + ", numarTotalCornere="
				+ numarTotalCornere + "]";
	}

	public void simuleaza() {
		Minge minge = new Minge(50, 25);
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("Nume echipa 1:" + this.numeEchipa1 + " | Nume echipa2: " + this.numeEchipa2 + " | Mingea se afla la coordonatele ("+minge.getX()+","+minge.getY()+").");
			try{
				minge.suteaza();
			}
			catch(ExceptieOut e) {
				numarTotalOut++;
				minge = new Minge(minge.getX(), minge.getY());
			} 
			catch (ExceptieCorner e) {
				numarTotalCornere++;
				if(minge.getX() == 0) {
					if(minge.getY() > 30) {
						minge = new Minge(0, 50);
					}
					else {
						minge = new Minge(0,0);
					}
				}
				else if(minge.getX() == 100){
					if(minge.getY() > 30) {
						minge = new Minge(100, 50);
					}
					else {
						minge = new Minge(100,0);
					}
				}
				
			} 
			catch (ExceptieGol e) {
				if(minge.getX() == 0) {
					goluriEchipa1++;
				}
				else {
					goluriEchipa2++;
				}
				minge = new Minge(50, 25);
			}
		}
	}
}
