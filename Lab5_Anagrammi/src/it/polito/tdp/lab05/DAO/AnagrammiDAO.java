package it.polito.tdp.lab05.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AnagrammiDAO {
	List <String> parole=new LinkedList <String>();
	
	public List<String> getParole(){
		final String sql = "SELECT * FROM parola";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String parola = rs.getString("nome");
							
				parole.add(parola);
			}

			return parole;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	public boolean isCorrect(String anagramma) {
		boolean b=false;
		if(parole.contains(anagramma)) {
			b=true;
		}
		return b;
	}

}
