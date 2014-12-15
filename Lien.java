/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;

public class Lien
{
	private ArrayList<Emplacement> listEmplacements = new ArrayList<Emplacement>();
	int size;
	public Lien(Emplacement a,Emplacement b){
		listEmplacements.add(a);
		listEmplacements.add(b);
	}
	public boolean lienExiste(Emplacement a,Emplacement b){
		if(listEmplacements.contains(a) && listEmplacements.contains(b) ){
			return true;
		}
		else{
			return false ;
		}
	}
	public Emplacement getExtrimite(Emplacement e){
		ArrayList<Emplacement> temp = listEmplacements;
		temp.remove(e);
		return temp.get(0);
	}
	
}
