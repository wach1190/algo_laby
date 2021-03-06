/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;

public class Emplacement
{
	
	int[]  coordonnee = new int[2] ;
	private ArrayList<Emplacement> successeurList = new ArrayList<Emplacement>() ;
	private ArrayList<Lien> lienList = new ArrayList<Lien>() ;
	char name;
	boolean pakkuman = false;
	boolean monstre  = false;
	boolean bonbon  = false;
	boolean sortie  = false;
	String direction ; 

	public Emplacement(char l, int x,int y){
		this.name = l;
		coordonnee[0]=x;
		coordonnee[1]=y;
		
	}
	public boolean egale(int x,int y){
		if((coordonnee[0]==x) && (coordonnee[1]==y)){
			return true;
		} 
		else{
			return false;
		}
	}
	public int getX(){
		return coordonnee[0];
		
	}

	public int getY(){
		return coordonnee[1];
		
	}
	public void addLien(Lien s){
		lienList.add(s);
	}
	public void addSuccesseur(Emplacement s){
		successeurList.add(s);
	}
		
	public char getEmplacementNom(){
		return this.name;
	}

	public int estConnecte(Emplacement s) {
		boolean existe = false ;
		int somme = 0;
		if(this.successeurList.contains(s)){
			existe = true ; 
			somme=1;
		} 
		else {
			for(Emplacement c : this.successeurList ){
				somme =c.succeseurConnecte(this,s);
				if(somme>0){ somme+=1;}
			}
		}
		return somme ; 
	}
	public int succeseurConnecte(Emplacement pred , Emplacement s) {
		boolean existe = false ;
		int somme = 0;
		if(this.successeurList.contains(s)){
			existe = true ; 
			somme=1;
		} 
		else if (name == s.name){
			somme=0;
		}
		else {
			ArrayList<Emplacement> temp= this.successeurList ;
			temp.remove(pred);
			for(Emplacement c : temp ){
				somme =1 + c.succeseurConnecte(this,s);
			}
		}
		return somme ; 
	}
	
	public void setPakkuman(){
		this.pakkuman = true ;	
	}
	
	public boolean estPakkuman(){
		return this.pakkuman ;	
	}

	public void setMonstre(){
		this.monstre = true ;
	}
	
	public boolean estMonstre(){
		return this.monstre ;	
	}

	public void setBonbon(){
		this.bonbon = true ;
	}
	
	public boolean estBonbon(){
		return this.bonbon ;	
	}

	public void setSortie(){
		this.sortie = true ;	
	}
	
	public boolean estSortie(){
		return this.sortie ;	
	}
	
	public ArrayList<Emplacement> getSuccesseurList(){

		return this.successeurList;
	}
	public ArrayList<Lien> getLienList(){

		return this.lienList;
	}
	public void setDirection(String s){
		this.direction = s;
	}
	public  String toString(){
		String s = new String("")  ;
		/*String t = new String("")  ;
		int e[] = new int[2];
		int f[] = new int[2];
		e = list.get(0);
		s = 1 + ". (" + e[0] + ","+ e[1] + ")  "+ direction +"\n";
		String d = new String("") ;  
		for(int i = 1; i< list.size() ; ++i){
			f=e;
			e = list.get(i);			
			if(e[0]==f[0]){
				if(e[1]>f[1]){
					d="est" ;
				}	
				else {
					d="ouest";
				}
			}
			else if(e[1]==f[1]){
				if(e[1]>f[1]){
					d="sud" ;
				}	
				else {
					d="nord";
				}
			}
	
			t = i+1 + ". (" + e[0] + ","+ e[1] + ")  "+d+"\n" ;
			s+=t;
		}*/
		if(bonbon){
			s="bonbon";
		}
		else if(monstre){
			s="monstre";
		} 
		else if(sortie){
			s="sortie";
		} 
		else if(pakkuman){
			s="pakkuman";
		} 
		s = "(" + coordonnee[0] + ","+ coordonnee[1] + ")  "+ direction + "  "+ s+"\n";
		return s;
	}
	
}
