/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;
public class Labyrinthe
{
	public static void main (String[] args) {
		String s ;
		if (args.length > 0) {       //on regarde si on a donne le nom
			s = args[0] ;
		}
		else{
			s = "Labyrinthe.txt" ;
		}
		Parser p = new Parser(s);    //On créé un objet parser
		p.readInputFile(); // lecture du fichier texte labyrinthe
		List<Emplacement> emplacements =  p.getListEmplacements(); //recupere la list
		Chemin c = new Chemin(emplacements);
		c.Dijkstra();		//effectue la detection sur ces cercles
	}
}		
