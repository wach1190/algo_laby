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
	
	
	public void addSuccesseur(Emplacement s){
		successeurList.add(s);
	}
		
	public char getEmplacementNom(){
		return this.name;
	}

	public int estConnecte(Emplacement s) {
		boolean existe = false ;
		int somme = 1000;
		if(this.successeurList.contains(s)){
			existe = true ;
			somme=1;
		} 
		else {
			for(Emplacement c : this.successeurList){
				System.out.println("jata");
				int r = c.estConnecte(s);
				if(r<1000){
					System.out.println("jata");
					existe=true;
					somme = 1+r;				
				}
			}
				
			
		}
		return somme ; 
	}
	public int succeseurConnecte(Emplacement pred , Emplacement s) {
		boolean existe = false ;
		int somme = 1000;
		if(this.successeurList.contains(s)){
			existe = true ; 
			somme=1;
		} 
		
		else {
			ArrayList<Emplacement> temp= this.successeurList ;
			temp.remove(pred);
			int i =0;
			while(i<temp.size() && !existe ){
				Emplacement c = temp.get(i);
				int r = c.succeseurConnecte(this,s);
				if(r<1000){
					existe=true;
					somme = 1+r;				
				}
				
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
	
	public void setDirection(String s){
		this.direction = s;
	}
    
    public String getDirection(){
        return this.direction
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
        // on à un problème ici, car dans tous les cas, la ligne ci dessous s'éxécute, et remplace donc le contenu de s (qui pourrait être bonbon/pakku/ etc) par sa coordonnée et direction, donc les clauses au dessus sont obselètes 
		s = "(" + coordonnee[0] + ","+ coordonnee[1] + ")  "+ direction + "  "+ s +" \n";
		return s;
	}
	
}
