package todfresser.lobby.main;


public class Example {
	/***
	 * Variablen:
	 * Modifier(static,public,private,abstract,final,protected,...) + ObjectArt(String,int,Rank,...) + Name;
	 */
	public final int ichbineinInteger;
	
	/***
	 * Methoden(Funktion):
	 * Modifier(static,public,private,final,...) + Rückgabe(void oder eine ObjectArt(String, int, Rank, List<>,...)) + Name der Funktion + (Objecte die übergeben werden sollen: ObjectArt(String, Rank,...) + Name) + ;
	 */
	public int getMyInteger(String s){
		return ichbineinInteger;
	}
	
	/***
	 * Constructor:
	 * Modifier(static,public,private,final,...) + KlassenName + ( Objecte die zum erstellen der Objectes benötigt werden: ObjectArt(String, Rank,...)) ){
	 * 
	 * }
	 */
	
	public Example(int newint){
		this.ichbineinInteger = newint;
	}
	

}
