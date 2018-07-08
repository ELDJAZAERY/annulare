package traitement;

import java.util.*;

public class Annuaire {
	
	private HashMap<String,Fiche> associative = new HashMap<String,Fiche>();
	
	/*boolean containsKey(Object key)
	Object get(Object key)
	boolean isEmpty()
	put(Object key, Object value)
	remove(Object key)
	int size()*/

	public void Add_fiche(Fiche f){
		associative.put(f.getNom(),f);
	}

	public void remove_fich(Fiche f){
		associative.remove(f.getNom());
	}
	
	public void remove_fich(String nom){
		associative.remove(nom);
	}
	
	public Fiche get_Fiche(Fiche f){
		return associative.get(f.getNom());
	}
	
	public Fiche get_fich(String nom){
		return associative.get(nom) ;
	}

	public ArrayList<Fiche> List_fiche(){
		//collection.sort(list)
		/*Set set = associative.entrySet();
		
		Iterator i = set.iterator();*/
		ArrayList<Fiche> list = new ArrayList<>();
		
		for(String key:associative.keySet()){
			Fiche f = associative.get(key);
			list.add(f);
		}
		
		Collections.sort(list);
		return list;
	}

	
	public void affiche_List_Fiche(){
		ArrayList<Fiche> list = List_fiche();
		if(list.isEmpty()) {System.out.println("Fiche vide !!");}
		for(Fiche f:list){
			System.out.println(f);
		}
	}



}


