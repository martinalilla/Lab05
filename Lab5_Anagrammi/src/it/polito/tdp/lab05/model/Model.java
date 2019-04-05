package it.polito.tdp.lab05.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab05.DAO.AnagrammiDAO;

public class Model {
	public LinkedList <String> listaparole;
	LinkedList <String> copia=new LinkedList <String>();
	private AnagrammiDAO dao=new AnagrammiDAO();
		
		public void trova(String s){
			String parziale="";
			this.listaparole=new LinkedList<String>();
			this.recursive(s, 0, parziale, listaparole);
		}
		
		

	public void recursive(String iniziale, int level, String parziale, LinkedList <String> soluzioni){
		
		
		if(level==iniziale.length()) {
			if(!soluzioni.contains(parziale)) {
			soluzioni.add(parziale);
			}
			
			return;
		}
		
		for(int i=0; i<iniziale.length(); i++) {
			char c=iniziale.charAt(i);
			
			if(contaLettera(c,iniziale)>contaLettera(c,parziale)) {
				parziale+=c;
				
				recursive(iniziale, level+1, parziale, soluzioni);
				
				parziale =parziale.substring(0, parziale.length()-1); //BACKTRACKING
				
			}
			
			
		}
		
	}
		
	public int contaLettera(char c, String iniziale) {
		int count =0;
		for (int i=0; i<iniziale.length(); i++) {
			if(iniziale.charAt(i)==c) {
				 count++;
			}
		}
		return count;
	}
	
	public List<String> getParole(){
		return dao.getParole();
	}
	
	public String corrette(List <String> lista){
		String corrette="";
		for(String s:lista) {
			if(dao.isCorrect(s)==true) {
				corrette+=s+"\n";
			}
		}
		return corrette;
	}
	
	public String errate(List <String> lista) {
		String errate="";
		for(String s:lista) {
			if(dao.isCorrect(s)==false) {
				errate+=s+"\n";
			}
		}
		return errate;
	}


}
