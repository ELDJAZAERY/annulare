package App;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


import traitement.*;


public class Application {

	private static Scanner sc;
	private static String regex_Ajouter="\\+[A-Za-z]+[ ][0-9]+[ ]+[A-Za-z0-9[ ]]+";
    private static String regex_Rechercher="\\?[A-Za-z]+";
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	private static Annuaire annuaire=new Annuaire();

	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        sc = new Scanner(System.in);
        String command ;
        charger_Objets();
        
        while(true){
			System.out.print(">>> ");
			command=sc.nextLine();
			charger_Objets();
			
			switch (command) {
				case "!":
					annuaire.affiche_List_Fiche();
					break;
				case ".":
					sauvgarder();
					System.out.println();
					System.out.println("**********************************");
			        System.out.println("*****        Merci !!!       *****");
			        System.out.println("**********************************");
					System.exit(0);
					break;
				case "help":
					System.out.println("");
					break;
				default:
					if(!traitement_ajouter_recherche(command)){
					System.out.println("Commande non valide !!! ,, tappez help pour plus d'inforamtion ");
					}
				 break;
			}
		}
        
	
	}
	
	
	
	private static void charger_Objets() throws FileNotFoundException, IOException, ClassNotFoundException {
	
		in = new ObjectInputStream(new FileInputStream("annuaire.obj"));
		Fiche ob = new Fiche();
		
		while(in.available()!=-1){
			try{ob = (Fiche)in.readObject();}catch(EOFException e){
				break;
			}catch(FileNotFoundException e1){break;}catch(IOException e2){break;}catch(ClassNotFoundException e3){break;}
			annuaire.Add_fiche(ob);
		}
		
	}



	static public void sauvgarder() throws FileNotFoundException, IOException{
		out = new ObjectOutputStream(new FileOutputStream("annuaire.obj"));
		//in = new ObjectInputStream(new FileInputStream("annuaire.obj"));
		
		for(Fiche f:annuaire.List_fiche()){
			out.writeObject(f);
		}
	}

	
	
	
	static public boolean traitement_ajouter_recherche(String command){
		
		if (command.matches(regex_Ajouter)) {
			
			String[] parts = command.split(" ");
			String nom = parts[0].substring(1); //enlever le '+'
			String numero = parts[1];
			String adress = command.substring(3+nom.length()+numero.length()); // 3=  + et deux espaces
			
		    
			    annuaire.Add_fiche( new Fiche(nom,numero,adress));
			   
		   return true;
		 }
		    
		
		if (command.matches(regex_Rechercher)) {
	    	
	    	String[] str=command.split("\\?");
		    Fiche f=annuaire.get_fich(str[1]);
		    if (f!=null){
		    	System.out.println(f.toString());	
		    }else {
		    	System.out.println("Nom inexiste ...");
		    }

		return true;
		}
	
	
	return false;
	}




}