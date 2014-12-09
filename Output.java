// Classe d'output pour le labyrinthe

import java.util.*;
import java.lang.*;
import java.io.File;
import parser.java;

public class OutputF{ // on va devoir mettre en argument la classe labyrinthe, afin de get toutes les infos nécessaires à l'output
    // espace attributs ==> to see later
    File f = new File("Output_LABY"); // output file
    Labyrinthe object;
    int i = 1; // compteur d'emplacements, incrémenté à chaque impression
    
    List<Emplacement> historic; // historique des emplacements à renvoyer
    
    // Constructeur avec argument :
    public static void main(Labyrinthe toOut){
        object = toOut; // le laby passé en argument est celui qu'on analysera pour l'output
    }
    public makeOutput(){
        System.out.print("Le labyrinthe à une dimension de : " + "8x8"); // get la dimension
        System.out.print(" Il contient" + "3"+"monstres et " + "4"+ "bonbons"); // get monstres et bonbons
        System.out.print("Monsieur Pakkuman se trouve en position" + "position"); // get position
        System.out.print("Le monstre se trouve en position ...");
        System.out.print("Les bonbons en positions ...");
        System.out.print("Déplacements de M.Pakkuman :");
        // Suivi de la liste des déplacements, à get dans historic ...
        // Donc normalement, je choppe la liste d'emplacements contenu dans la classe labyrinthe, et je la print, tout simplement
        for emplacement in object.emplacements {
            System.out.print(i +". "+ "(" + emplacement.getX + ", " +emplacement.getY + ")" + "get direction");
        }
//        historic = Parser.getListEmplacements(); // on get cette fameuse liste
//        // Maintenant on doit print une ligne par emplacement.
//        for(int i = 0; i < 10; ++i){
//            System.out.println()historic[i]
        }
    }
}