package cliJavaCRUD;
/* Klasa abstrakte Punonjes */
public abstract class Punonjes{
        private String id;
	private String emri;
	private String mbiemri;
	private int vitiLindjes;
	private int pervoja;
	
	// konstruktori
	public Punonjes(String i, String e, String m, int vL, int p){
                id = i;
                emri = e;
	 	mbiemri=m;
	 	vitiLindjes=vL;
	 	pervoja=p;
        }

        /* metodat merr dhe cakto */
        public String merrId(){
               return id;
        }

        public String merrEmrin(){
               return emri;
        }

        public void caktoEmrin(String e){
               emri=e;
        }

        public String merrMbiemrin(){
               return mbiemri;
        }

        public void caktoMbiemrin(String m){
               mbiemri=m;
        }

        public int merrVitinELindjes(){
               return vitiLindjes;
        }

        public void caktoVitinELindjes(int v){
               vitiLindjes = v;
        }

        public int merrPervojen(){
               return pervoja;
        }

        public void caktoPervojen(int p){
               pervoja = p;
        }

        /* metoda abstrakte paga() */
        public abstract double paga();

        public String toString(){
               String rez="";
               rez+="Emri: "+emri+"\n";
               rez+="Mbiemri: "+mbiemri+"\n";
               rez+="Viti i lindjes: "+vitiLindjes+"\n";
               rez+="Pervoja: "+pervoja+"\n";
               return rez;
        }
}