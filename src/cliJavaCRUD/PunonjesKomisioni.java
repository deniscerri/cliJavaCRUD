package cliJavaCRUD;/* Klasa konkrete PunonjesKomisioni e derivuar nga klasa abstrakte Punonjes */
public class PunonjesKomisioni extends Punonjes{
	private double shitjet;
	private double komisioni;
	
	/* konstruktori */
	public PunonjesKomisioni(String i, String e, String m, int vL, int prv, double sh, double k){
		super(i,e,m,vL,prv);
		shitjet = sh;
		komisioni = k;
	}
	
	/* metodat merr dhe cakto */
	public double merrShitjet(){
		return shitjet;
	}
	
	public void caktoShitjet(double sh){
		shitjet = sh;
	}
	
	public double merrKomisionin(){
		return komisioni;
	}
	
	public void caktoKomisionin(double k){
		komisioni = k;
	}
	
	/* rideklarimi konkret i metodes abstrakte paga() */
	public double paga(){
		return shitjet * komisioni;
	}
	
	public String toString(){
		String rez;
		rez = super.toString();
		rez += "Shitjet: " + shitjet + "\n";
		rez += "Komisioni: " + komisioni + "\n";
		return rez;
	}
}