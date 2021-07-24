package cliJavaCRUD;
public class PunonjesKomisioniMePageBaze extends PunonjesKomisioni{
	private double pagaBaze;
	
	//konstruktori
	public PunonjesKomisioniMePageBaze(String i, String e,String m,int vL,int p, double sh, double k, double pB){
		super(i,e,m,vL,p,sh,k); //thirrja e konstruktorit te klases meme
		pagaBaze=pB;
	}
	
	public double merrPageBaze(){
		return pagaBaze;
	}
	
	public void caktoPageBaze(double pB){
		if(pB>0){
			pagaBaze=pB;
		}
	}
	
	public double paga(){
		return pagaBaze+super.paga(); //thirrja e metodes paga() ne klasen meme
	}
	
	public String toString(){
		String rez;
		rez=super.toString(); // thirrja e metodes toString() ne klasen meme
		rez+="Paga Baze:"+pagaBaze+"\n";
		return rez;
	}
}