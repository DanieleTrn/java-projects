package it.tirinnanzi.ivsb.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import it.tirinnanzi.ivsb.entity.Appuntamento;

public class AppuntamentiRepository {
	
	private final static String FILE_NAME = "appuntamenti.txt";
	private String pathName;
	
	public AppuntamentiRepository(String pathName) {
		this.pathName = pathName;
	}
	
	
	//Formato dati: Id~Data~Inizio~Luogo
	public void addAppuntamento(Appuntamento app, String id) throws IOException {
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(pathName+FILE_NAME,true));
		bWriter.write(app.toArchive(id));
		bWriter.newLine();
		bWriter.flush();
		bWriter.close();
	}
	
	public ArrayList<Appuntamento> ricerca(String id) throws IOException{
		BufferedReader bReader = new BufferedReader(new FileReader(pathName+FILE_NAME));
		
		ArrayList<Appuntamento> listaApp = new ArrayList<>();
		String data = bReader.readLine();
		
		while(null != data) {
			String[] splitData = data.split("~");
			if(splitData[0].equals(id)) {
				listaApp.add(new Appuntamento(splitData[1],splitData[2],splitData[3]));
			}
			data = bReader.readLine();
		}
		//...
		bReader.close();
		return listaApp;
	}
	
	public boolean modApp(Appuntamento toMod, Appuntamento newApp) throws IOException {
		
		//Variabile booleana per determinare l'esito dell'operazione
		boolean isMod = false;
		
		BufferedReader bReader = new BufferedReader(new FileReader(pathName+FILE_NAME));
		ArrayList<Appuntamento> appuntamenti = new ArrayList<>();
		String data = bReader.readLine();
		while(null != data) {
			String[] splitData = data.split("~");
			Appuntamento appuntamento = new Appuntamento(splitData[0],splitData[1],splitData[2],splitData[3]);
			if(!appuntamento.equals(toMod)) {
				appuntamenti.add(appuntamento);
			}else{
				appuntamenti.add(newApp);
				isMod = true;
			}
			data = bReader.readLine();
			System.out.println(data);
		}
		bReader.close();
		
		//Riscrivo il file di testo con gli appuntamenti
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(pathName+FILE_NAME));
				
		for(Appuntamento a : appuntamenti) {
				String id = a.getId();
				bWriter.write(a.toArchive(id));
				bWriter.newLine();
		}
		//...
		bWriter.flush();
		bWriter.close();
				
		return isMod; // Tornerà l'esito della cancellazione
	}
	
	public boolean deleteApp(Appuntamento app) throws IOException {
		
		boolean isDeleted = false; //variabile booleana ritornata una volta finito il metodo
		
		//Popolo un'array con gli appuntamenti.
		BufferedReader bReader = new BufferedReader(new FileReader(pathName+FILE_NAME));
		ArrayList<Appuntamento> listaApp = new ArrayList<>();
		String data = bReader.readLine();
		
		while(null != data) {
			
			String[] splitData = data.split("~");
			Appuntamento appuntamento = new Appuntamento(splitData[0],splitData[1],splitData[2],splitData[3]);
			
			//!appuntamento.getData().equals(app.getData()) && !appuntamento.getOra().equals(app.getOra()) && !appuntamento.getLuogo().equals(app.getLuogo())
			
			if(!appuntamento.equals(app)) {
				listaApp.add(appuntamento);		
			}else {
				//Se l'algoritmo passa di qui significa che ha trovato qualcosa da eliminare, dunque isDeleted sarà vero
				isDeleted = true;
			}
			data = bReader.readLine();
		}
		bReader.close();
		
		//Riscrivo il file di testo con gli appuntamenti
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(pathName+FILE_NAME));
		
		for(Appuntamento a : listaApp) {
			String id = a.getId();
			bWriter.write(a.toArchive(id));
			bWriter.newLine();
		}
		//...
		bWriter.flush();
		bWriter.close();
		
		return isDeleted; // Tornerà l'esito della cancellazione
	}
}
