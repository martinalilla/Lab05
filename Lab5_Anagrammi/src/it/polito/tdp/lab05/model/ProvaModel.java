package it.polito.tdp.lab05.model;

import java.util.LinkedList;

public class ProvaModel {

	public static void main(String[] args) {
		LinkedList <String> soluzioni=new LinkedList <String>();
		String s="mamma";
		Model p=new Model();
		p.trova(s);
		soluzioni.addAll(p.listaparole);
		for(String st: soluzioni) {
		System.out.println(st);
		}

	}

}
