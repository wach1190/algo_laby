/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;
public class Chemin
{
	
	private	List<Emplacement> graphe = new ArrayList<Emplacement> (); // Est-ce la matrice du labyrinthe ? ==> voir type ArrayList ...
	private int size ;  // taille de la liste 
	private int nbrMonstreTotal ;
	private int nbrBonbonTotal ;
	private Emplacement pakkuman ;
	private Emplacement sortie ;
	private List<Emplacement> listMonstre = new ArrayList<Emplacement> (); // intéressant, pas besoin de refaire la boucle pour l'output
	private List<Emplacement> listBonbon = new ArrayList<Emplacement> (); // idem
	private	List<Emplacement> prec = new ArrayList<Emplacement> (); // usage ?
	private	List<Integer> dist = new ArrayList<Integer> ();
	 // vecteurs de traitement complet
	
	public Chemin(List<Emplacement> e ){ // constructeur
		this.graphe = e ; // est-ce véritablement utile/nécessaire de recopier la liste ?
		this.size = e.size(); // surtout qu'on utilise e au final ...
		for(Emplacement c : this.graphe){ // synthaxe ? ==> voir google (on boucle tous les emplacement du graphe j'imagine
			if(c.estPakkuman() ){
				pakkuman = c;
			}
			else if(c.estSortie() ){ // comment on set l'attribut estSortie dans le parser ? ==> voir parser.java
				sortie = c;
			} 
			else if(c.estMonstre() ){ // intéressant
				listMonstre.add(c);
				nbrMonstreTotal+=1;
			}
			else if(c.estBonbon() ){
				listBonbon.add(c);
				nbrBonbonTotal +=1;
			}
		}
		for(int i=0; i< this.size;++i){ // que fait cette boucle ???
			dist.add(1000);
			prec.add(null);
		}
	}
	
	public void Dijkstra(){ //==> voir Dijkstra syllabus ( :) )
		List<Emplacement> M = new ArrayList<Emplacement> ();
		int distance = 0;
		for(int i=0; i< this.size;++i){
			distance = tailleLien(pakkuman , graphe.get(i));			
			dist.set(i,distance);
			prec.set(i,pakkuman );				
			M.add(graphe.get(i) );
			System.out.println(graphe.get(i) + " "+ dist.get(i) +" "+prec.get(i) );
						
		}
		M.remove(pakkuman);
		int distanceMinimum = 1000;
		while(M.size() != 0){
			int save=0;
			for(int j=0 ; j< M.size() ; ++j){
				if(distanceMinimum > dist.get(j)){
					distanceMinimum = dist.get(j);
					save=j; 
				}
			}
			Emplacement m = M.get(save);
			M.remove(m);
			if(dist.get(save)==1000){
				M.clear();
			}
			else{
				for(Emplacement y : m.getSuccesseurList()){
					if(M.contains(y) ){
						distance= dist.get(save) + tailleLien(m,y);
						if( distance  < dist.get(graphe.indexOf(y))){
							dist.set(graphe.indexOf(y),distance);
							prec.set(graphe.indexOf(y),m);			
						}
					}
				} 
			
			}
		}
		
	}
	public int tailleLien(Emplacement e, Emplacement f){
		return e.estConnecte(f);

	}
	
}






