package cliJavaCRUD;
/* Klasa konkrete PunonjesMeOre e derivuar nga klasa abstrakte Punonjes */
public class PunonjesMeOre extends Punonjes{
	private double pagaPerOre;
	private int oret;
	
	/* konstruktori */
	public PunonjesMeOre(String i,String e, String m, int vL, int prv, double pO, int or){
		super(i,e,m,vL,prv);
		pagaPerOre = pO;
		oret = or;
	}
	
	/* metodat merr dhe cakto */
	public double merrPagePerOre(){
		return pagaPerOre;
	}
	
	public void caktoPagaPerOre(double pO){
		pagaPerOre = pO;
	}
	
	public double merrOret(){
		return oret;
	}
	
	public void caktoOret(int or){
		oret = or;
	}
	
	/* rideklarimi konkret i metodes abstrakte paga() */
	public double paga(){
		return pagaPerOre * oret;
	}
	
	public String toString(){
		String rez;
		rez = super.toString();
		rez += "Paga per ore " + pagaPerOre + "\n";
		rez += "Oret: " + oret + "\n";
		return rez;
	}
}