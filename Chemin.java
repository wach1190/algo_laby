/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;
public class Chemin
{
	//compteurs pour les vecteurs pre et post 
	/*private int id=0;
	private int cnt=0 ;
	private int nbrCycle = 0 ; //nombre de cercle détecté*/
	private	List<Emplacement> graphe = new ArrayList<Emplacement> ();
	private int size ;  // taille de la liste 
	private int nbrMontreTotal ;
	private int nbrBonbonTotal ;
	private Emplacement pakkuman ;
	private	List<Emplacement> prec = new ArrayList<Emplacement> ();
	private	List<Integer> dist = new ArrayList<Integer> ();
	 // vecteurs de traitement complet
	
	public Chemin(List<Emplacement> e,int monstre,int bonbon ){
		this.graphe = e ;
		this.size = graphe.size();
		this.nbrMontreTotal=monstre;
		this.nbrBonbonTotal=bonbon;
		for(Emplacement c : this.graphe){
			if(c.estPakkuman() ){
				pakkuman = c;
			} 
		}
		for(int i=0; i< this.size;++i){
			dist.add(1000);
			prec.add(graphe.get(0));
		}
	}
	
	public void Dijkstra(){
		List<Emplacement> M = new ArrayList<Emplacement> ();
		for(int i=0; i< this.size;++i){
			if(pakkuman.estConnecte(graphe.get(i))>0 ){	
				System.out.println(i + "yey")	;
				dist.set(i,1);
				prec.set(i,pakkuman );
				M.add(graphe.get(i) );
			}
		}
		M.remove(pakkuman);
		int distanceMinimum = 1000;
		int save=0;
		while(M.size() != 0){
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
				for(Emplacement c : (M.get(save)).getSuccesseurList()){
					if(M.contains(c) ){
						if(m.estConnecte(c) >0){
							if((dist.get(save)+1)<dist.get(	graphe.indexOf(c))){
								dist.set(graphe.indexOf(c),dist.get(save)+1);
								prec.set(graphe.indexOf(c),m);
								System.out.println(dist.get(graphe.indexOf(c)));
								System.out.println(prec.get(graphe.indexOf(c)));				
							}				
						}
					}
				} 
			
			}
		}
		for(int j=0 ; j< graphe.size() ; ++j){
			System.out.println(dist.get(j));
			System.out.println(prec.get(j));
		}
	}
}






