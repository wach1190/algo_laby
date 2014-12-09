// Classe d'output pour le labyrinthe

import java.util.*;
import java.lang.*;
import java.io.File;
import parser.java;

public class Main{
    // espace attributs ==> to see later
    File f = new File("Output_LABY");
    List<Emplacement> historic; // historique des emplacements à renvoyer
    public makeOutput(){
        System.out.print("Le labyrinthe à une dimension de : " + "8x8"); // get la dimension
        System.out.print(" Il contient" + "3"+"monstres et " + "4"+ "bonbons"); // get monstres et bonbons
        System.out.print("Monsieur Pakkuman se trouve en position" + "position"); // get position
        System.out.print("Le monstre se trouve en position ...");
        System.out.print("Les bonbons en positions ...");
        System.out.print("Déplacements de M.Pakkuman :");
        // Suivi de la liste des déplacements, à get dans historic ...
        
//        historic = Parser.getListEmplacements(); // on get cette fameuse liste
//        // Maintenant on doit print une ligne par emplacement.
//        for(int i = 0; i < 10; ++i){
//            System.out.println()historic[i]
        }
    }
}