// Classe d'output pour le labyrinthe

import java.util.*;
import java.lang.*;
import java.io.File;
import Parser.java;
import Chemin.java;

public class OutputF{ // on va devoir mettre en argument la classe labyrinthe, afin de get toutes les infos nécessaires à l'output
    // espace attributs ==> to see later
    File f = new File("Output_LABY"); // output file
    private chemin object;
    int i = 1; // compteur d'emplacements, incrémenté à chaque impression
    
    // Constructeur avec argument :
    public static void main(chemin toOut){ // prend le chemin (préalablement traité par dijkstra) en paramètre afin de l'outputer dans un fichier
        object = toOut; // copie inutile non ? argument private ???
    }
    public makeOutput(){
        System.out.println("Le labyrinthe à une dimension de : " + "8x8"); // get la dimension
        System.out.println(" Il contient" + "3"+"monstres et " + "4"+ "bonbons"); // get monstres et bonbons
        System.out.println("Monsieur Pakkuman se trouve en position" + "position"); // get position
        System.out.println("Le monstre se trouve en position ..."); // dois je faire une boucle qui parcous chaque emplacement du labyrinthe, trouve ceux qui contiennetn un monstre, et les affiche ? ça n'est pas très efficaces non? y-a-t'il un endroit où sont stockés toutes ces fameuses cases ? ==> à investiguer
        System.out.print("Les bonbons en positions ..."); // même questionnement que pour les monstres
        System.out.print("Déplacements de M.Pakkuman :");
        // Suivi de la liste des déplacements, à get dans historic ...
        // Donc normalement, je choppe la liste d'emplacements contenu dans la classe labyrinthe, et je la print, tout simplement
        for emplacement in object.emplacements {
            System.out.println(i +". "+ "(" + emplacement.getX + ", " +emplacement.getY + ") " + emplacement.getDirection);
            ++i; // incrémentation du compteur d'emplacements (simple norme de l'output)
        }

    }
}