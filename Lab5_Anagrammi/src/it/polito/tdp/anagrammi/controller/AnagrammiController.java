

	package it.polito.tdp.anagrammi.controller;

import it.polito.tdp.lab05.model.*;
import it.polito.tdp.lab05.DAO.*;

	import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.TextField;
	import javafx.scene.control.TextArea;

	public class AnagrammiController {
		private Model model;

	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="inserisci"
	    private TextField inserisci; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="corretti"
	    private TextArea risultato; // Value injected by FXMLLoader
	    
	    @FXML // fx:id="sbagliati"
	    private TextArea sbagliati; // Value injected by FXMLLoader



	    @FXML // fx:id="errati"
	    private TextField errati; // Value injected by FXMLLoader

	    @FXML
	    void doCalcola(ActionEvent event) {
	    	LinkedList <String> soluzioni=new LinkedList <String>();
	    	
	    	String s=inserisci.getText();
	    	model.trova(s);
	    	soluzioni.addAll(model.listaparole);
	    	String stringa="";
			for(String st: soluzioni) {
			stringa+=st+"\n";
			}
			risultato.appendText(model.corrette(soluzioni));
			sbagliati.appendText(model.errate(soluzioni));
			
	    	

	    }

	    @FXML
	    void doReset(ActionEvent event) {

	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert inserisci != null : "fx:id=\"inserisci\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert errati != null : "fx:id=\"errati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert sbagliati != null : "fx:id=\"sbagliati\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	    }
	    
	    public void setModel(Model model) {
			this.model=model;
	    }
	}


	


