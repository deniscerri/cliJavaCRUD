package cliJavaCRUD;
/* Klasa konkrete PunonjesMePageBaze e derivuar nga klasa abstrakte Punonjes */
public class PunonjesMePageBaze extends Punonjes{
	private double pagaBaze;
	
	/* konstruktori */
	public PunonjesMePageBaze(String i,String e, String m, int vL, int prv, double pg){
		super(i,e,m,vL,prv);
		pagaBaze = pg;
	}
	
	/* metodat merr dhe cakto */
	public double merrPageBaze(){
		return pagaBaze;
	}
	
	public void caktoPageBaze(double pg){
		pagaBaze = pg;
	}
	
	/* rideklarimi konkret i metodes abstrakte paga() */
	public double paga(){
		return pagaBaze;
	}
	
	public String toString(){
		String rez;
		rez = super.toString();
		rez += "Paga baze: " + pagaBaze + "\n";
		return rez;
	}
}