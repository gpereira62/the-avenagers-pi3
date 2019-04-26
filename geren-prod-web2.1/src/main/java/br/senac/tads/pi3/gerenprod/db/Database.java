package br.senac.tads.pi3.gerenprod.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tades_ltda";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	private static Connection connection = null;
	
	public static Connection getConnection(){
		if(connection==null){
			try{
				//Loading The Driver Class
				Class.forName(DRIVER);
				
				//Getting the connection Object
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return connection;
	}
}

/*
        Use tades_ltda;
        CREATE TABLE produtos(
	idProduto BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
	NomeProduto VARCHAR(50),
	Ano VARCHAR(50),
	Modelo VARCHAR(50) UNIQUE NOT NULL,
	Marca VARCHAR(50),
	PRIMARY KEY(idProduto))
*/
