/*
Ferdous Juena - Info2 - 000294645
Infof203 - Algorithmique 2
*/
import java.util.*;
import java.lang.*;
import java.io.* ;
public class Parser
{
	
	private String fileName ;
	private ArrayList<Emplacement> listEmplacements = new ArrayList<Emplacement>();
	private int nbrMonstreTotal =0;
	private int nbrBonbonTotal =0;
	
	public Parser (String name) {			//contructeur
		this.fileName = name ;
	}
	
	public void readInputFile() {			//lit le fichier
		boolean t;
  		String[] values ;
		String values1 ;
		FileReader file = null;
		int i = 0 ;
		String line = "";
		int ligne=0,col=0;
  		try {
			
			file = new FileReader(this.fileName);
			BufferedReader input = new BufferedReader(file);
			if((line = input.readLine()) != null) {
				values=line.split(" ");
				ligne = Integer.parseInt(values[1]);
				col = Integer.parseInt(values[3]);
				//on recupere le nombre de ligne et colone
			}
			//tant qu'on a ligne contenant le labyrinth
			while((line = input.readLine())!= null && i<((ligne*2)+1)){
				values = line.split("");
				
				for(int k =0;k<9;++k){
					System.out.print(values[k]);
				}
				System.out.println();
				//on ajoute dans la liste de cercles
				++i;
			}
			/*//tant qu'on a ligne contenant les dettes
			while (line != null  ) {
				//on ajoute des successeurs et les dettes
				values1 = line.split(" ");
				Cercle c1 = findCercle(values1[0]);
				Cercle c2 = findCercle(values1[1]);
				c1.setSuccessor(c2) ;
				c1.setLoan(values1[2]);
				line = input.readLine();
			}*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
				}
			}
		}
		




		int x=3;
		int y=3;
		char[][] lab=new char[x][y];		
		this.nbrMonstreTotal = 2 ;
		this.nbrBonbonTotal = 1;
		
		
		Emplacement e0= new Emplacement(Character.forDigit(0, 10));
		
		e0.addEmplacement(0,0);

		Emplacement e1= new Emplacement(Character.forDigit(1, 10));
		e1.addEmplacement(0,1);
		e1.addEmplacement(0,2);
		e1.addEmplacement(0,3);
			


		Emplacement e2= new Emplacement(Character.forDigit(2, 10));
		
		e2.addEmplacement(1,0);
		e2.addEmplacement(1,1);
		e2.addEmplacement(1,2);
		e2.addEmplacement(1,3);

		

		Emplacement e3= new Emplacement(Character.forDigit(3, 10));
		
		e3.addEmplacement(1,3);

		Emplacement e4= new Emplacement(Character.forDigit(4, 10));
		
		e4.addEmplacement(2,3);	
		e4.addEmplacement(2,2);
		e4.addEmplacement(2,1);
		e4.addEmplacement(2,0);
		e4.addEmplacement(3,0);
		e4.addEmplacement(3,1);
		e4.addEmplacement(3,0);
		e4.addEmplacement(3,1);
		e4.addEmplacement(3,2);

		Emplacement e5= new Emplacement(Character.forDigit(5, 10));
		
		e5.addEmplacement(3,3);

		e0.addSuccesseur(e2);
		e2.addSuccesseur(e0);

		e1.addSuccesseur(e3);
		e3.addSuccesseur(e1);

		e2.addSuccesseur(e3);
		e3.addSuccesseur(e2);

		e4.addSuccesseur(e3);
		e3.addSuccesseur(e4);

		e4.addSuccesseur(e5);
		e5.addSuccesseur(e4);

		e1.setPakkuman();
		e2.setMonstre();
		e4.setMonstre();
		
		e1.setBonbon();	

		listEmplacements.add(e0);
		listEmplacements.add(e1);
		listEmplacements.add(e2);
		listEmplacements.add(e3);
		listEmplacements.add(e4);
		listEmplacements.add(e5);
		
	}
	public List<Emplacement> getListEmplacements(){  //renvoie le liste des emplacements
		return this.listEmplacements;
	}
	public int getNbrMonstreTotal(){
		return this.nbrMonstreTotal ;
	}
	public int getNbrBonbonTotal(){
		return this.nbrBonbonTotal ;
	}	
}
