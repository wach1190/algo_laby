/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;

public class Emplacement
{
	
	private ArrayList<int[]> list = new ArrayList<int[]>() ;
	public ArrayList<Emplacement> successeurList = new ArrayList<Emplacement>() ;
	char name;
	boolean pakkuman = false;
	boolean monstre  = false;
	boolean bonbon  = false;
	boolean sortie  = false;
	int nbrMonstre=0;
	int nbrBonbon=0;
	String direction ; 

	public Emplacement(char l){
		this.name = l;
		
	}
	public void addEmplacement(int x,int y){
		int e[] = new int[2];
		e[0]=x;
		e[1]=y;
		list.add(e);

	}

	public void addSuccesseur(Emplacement s){
		successeurList.add(s);
	}
		
	public char getEmplacementNom(){
		return this.name;
	}

	public int estConnecte(Emplacement s) {
		int distance = 0;
		boolean existe = false ;
		/*if(this.successeurList.contains(s)){
			distance=1;
		}
		else{
			for(Emplacement c : this.successeurList){
			
			if(c.successeurList.contains(s)){
				distance =1+1;break;
			}}
		}*/
		
		if(this.successeurList.contains(s)){ 
				existe=true;
				distance +=1;
			}
			else{
			 	if (successeurConnecte(s)){
					existe=true;
					distance +=1;			
				}
				
			}
		
		return  distance; 
	}


	public boolean successeurConnecte(Emplacement s){
		boolean existe =false;
		int i =0;
		while(i<this.successeurList.size() && !existe){
			 if ((this.successeurList.get(i)).successeurList.contains(s)){
				existe=true;
				//distance +=1;			
			}
			i+=1;
		}
		
		return existe;
	}

	
	public void setPakkuman(){
		this.pakkuman = true ;	
	}
	
	public boolean estPakkuman(){
		return this.pakkuman ;	
	}

	public void setMonstre(){
		this.monstre = true ;
		this.nbrMonstre += 1; 	
	}
	
	public boolean estMonstre(){
		return this.monstre ;	
	}

	public void setBonbon(){
		this.bonbon = true ;
		this.nbrBonbon += 1; 	
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
	public int getNbrMonstre(){
		return this.nbrMonstre ;
	}
	public int getNbrBonbon(){
		return this.nbrBonbon ;
	}
	public ArrayList<Emplacement> getSuccesseurList(){

		return this.successeurList;
	}
	
	public void setDirection(String s){
		this.direction = s;
	}
	public  String toString(){
		String s = new String("")  ;
		String t = new String("")  ;
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
		}
		return s;
	}
	
}
