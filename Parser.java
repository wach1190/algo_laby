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
	
	public Parser (String name) {			//constructeur
		this.fileName = name ;
	}
	
	public void readInputFile() {			//lit le fichier

		String [][] labyrinthe;
  		String[] values ;	
		char [] values1 ;
		char [] temp;
		String str=" -";
		char [] test =str.toCharArray();
		FileReader file = null;
		int i = 0 ;
		String line = "";
		int ligne=0,col=0;
		int px,py;
		int [][] monstre=new int[0][0];
		int [][]bonbon=new int[0][0];
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
			labyrinthe = new String [(ligne*2)+1][(col*2)+1];
			values =new String[(col*2)+1];
			while((line = input.readLine())!= null && i<((ligne*2)+1)){
				str="";
				values1 = line.toCharArray();
				for(int h =0;h<values1.length;++h){
					str+=values1[h]; 
					if(values1[h]==test[1] ){
						h+=2;						
					}
					else if(values1[h]==test[0] && ((h%4)!=0) ){
						h+=2;
					}
					
				}
				labyrinthe[i]=str.split("");
				++i;
			}
			for(int v=0;v<(ligne*2)+1;++v){
				for(int w=0;w<(col*2)+1;++w){
					System.out.print(labyrinthe[v][w]);				
				}
				System.out.println();
			}
			
			line = input.readLine();
			values=line.split(" ");
			this.nbrMonstreTotal = Integer.parseInt(values[1]);
			line = input.readLine();
			values=line.split(" ");
			this.nbrBonbonTotal= Integer.parseInt(values[1]);
			line = input.readLine();
			line = input.readLine();
			values=line.split(" ");
			px=Character.getNumericValue(values[1].charAt(1));
			py=Character.getNumericValue(values[1].charAt(3));
			line = input.readLine();
			values=line.split(" ");
			monstre = new int[this.nbrMonstreTotal][2];
			for(int w=1;w<values.length;++w){
				monstre[w-1][0]	=Character.getNumericValue(values[w].charAt(1));
				monstre[w-1][1]	=Character.getNumericValue(values[w].charAt(3));		
			}
			line = input.readLine();
			values=line.split(" ");
			bonbon = new int[this.nbrBonbonTotal][2];
			for(int w=1;w<values.length;++w){
				bonbon[w-1][0]	=Character.getNumericValue(values[w].charAt(1));
				bonbon[w-1][1]	=Character.getNumericValue(values[w].charAt(3));		
			}
			
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
		int [] sorti=new int [2];
		//int h=1;
		int a;
		char xx = Character.forDigit(0, 10);
		int q=0;
		for(int g=1;g<(ligne*2); g+=2){
			for(int h=1; h<(col*2) ; h+=2){
				Emplacement e = new Emplacement(Character.forDigit(q, 10),g/2,h/2);
				listEmplacements.add(e);	
				if(e.egale(px,py)){
					e.setPakkuman();				
				}
				else{
					for (int ii =0 ; ii<this.nbrMonstreTotal;++ii){
						if(e.egale(monstre[ii][0],monstre[ii][1])){
							e.setMonstre();				
						}
					}
					for (int iii =0 ; iii<this.nbrBonbonTotal;++iii){
						if(e.egale(bonbon[iii][0],bonbon[iii][1])){
							e.setBonbon();				
						}
					}
									
				}			
			}
		}
		Emplacement sommet1=new Emplacement(Character.forDigit(0, 10),0,0) ;
		Emplacement sommet2=new Emplacement(Character.forDigit(1, 10),0,0) ;
		for(int g=0;g<(ligne*2)+1; ++g){
			for(int h=0; h<(col*2)+1 ; ++h){
				if((labyrinthe[g][h]).equals(" ")){
					if(g==0 || g==ligne*2 || h == 0 || h==col*2){
							sorti[0]=(g-1)/2;sorti[1]=(h-1)/2;
							for (Emplacement e : listEmplacements){
								if(e.egale(sorti[0],sorti[1])){
										e.setSortie();	System.out.println("coucou");			
								}
							}

					}
					
					else if((g%2)==0){
							int o =0;
							int b=0;
							for (Emplacement e : listEmplacements){
								if(e.egale((g-1)/2,h/2)){
									o= listEmplacements.indexOf(e);
								}
								else if(e.egale((g+1)/2,h/2)){
									b= listEmplacements.indexOf(e);
								}
							}
							(listEmplacements.get(o)).addSuccesseur(listEmplacements.get(b));
							//(listEmplacements.get(b)).addSuccesseur(listEmplacements.get(o));
							
						
					}	
					else if((h%2)==0){
						int o =0;
							int b=0;
							for (Emplacement e : listEmplacements){
								if(e.egale(g/2,(h-1)/2)){
									o= listEmplacements.indexOf(e);
								}
								else if(e.egale(g/2,(h+1)/2)){
									b= listEmplacements.indexOf(e);
								}
							}
							(listEmplacements.get(o)).addSuccesseur(listEmplacements.get(b));
							//(listEmplacements.get(b)).addSuccesseur(listEmplacements.get(o));
					}
				}								
			}
		}	
	}
	
	public List<Emplacement> getListEmplacements(){  //renvoie le liste des emplacements
		return this.listEmplacements;
	}
	
	
}
