/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;
public class Chemin
{
	
	private	List<Emplacement> graphe = new ArrayList<Emplacement> ();
	private	List<Lien> arcs = new ArrayList<Lien> ();
	private int size ;  // taille de la liste 
	private int nbrMontreTotal ;
	private int nbrBonbonTotal ;
	private Emplacement pakkuman ;
	private Emplacement sortie ;
	private List<Emplacement> listMonstre = new ArrayList<Emplacement> ();
	private List<Emplacement> listBonbon = new ArrayList<Emplacement> ();
	private	List<Emplacement> prec = new ArrayList<Emplacement> ();
	private	List<Integer> dist = new ArrayList<Integer> ();
	 // vecteurs de traitement complet
	
	public Chemin(List<Emplacement> e,List<Lien> l ){
		this.graphe = e ;
		this.arcs=l;
		this.size = graphe.size();
		for(Emplacement c : this.graphe){
			if(c.estPakkuman() ){
				pakkuman = c;
			}
			else if(c.estSortie() ){
				sortie = c;
			} 
			else if(c.estMonstre() ){
				listMonstre.add(c);
				nbrMontreTotal+=1;
			}
			else if(c.estBonbon() ){
				listBonbon.add(c);
				nbrBonbonTotal +=1;
			}
		}
		for(int i=0; i< this.size;++i){
			dist.add(1000);
			prec.add(null);
		}
	}
	
	public void Dijkstra(){
		List<Emplacement> M = new ArrayList<Emplacement> ();
		int distance = 0;
		for(int i=0; i< this.size;++i){
			distance = tailleLien(pakkuman , graphe.get(i));			
			if(distance > 0 ){
				dist.set(i,distance);
				prec.set(i,pakkuman );				
				M.add(graphe.get(i) );
			}
			
		}
		M.remove(pakkuman);
		int distanceMinimum = 1000;
		while(M.size() != 0){
			int save=0;
			for(int j=0 ; j< M.size() ; ++j){
				if(distanceMinimum < dist.get(j)){
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
				for(Lien a : m.getLienList()){
					Emplacement y= a.getExtrimite(m);
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
		for(int j=0 ; j< graphe.size() ; ++j){
			System.out.println(j + " "+ dist.get(j));
			System.out.println(prec.get(j));
		}
	}
	public int tailleLien(Emplacement e, Emplacement f){
		Lien l = new Lien (e,f);
		if(arcs.contains(l)){
			return 1;
		}
		else {
			return 0;
		}
	}
	
}






