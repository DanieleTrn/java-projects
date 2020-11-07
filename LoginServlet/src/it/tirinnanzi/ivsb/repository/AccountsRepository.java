package it.tirinnanzi.ivsb.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import it.tirinnanzi.ivsb.entity.Account;

public class AccountsRepository {
	
	private final static String FILE_NAME = "accounts.txt";
	private String pathName;
	
	public AccountsRepository(String pathName) {
		this.pathName = pathName;
	}
	
	public void salvaAccount(Account account) throws IOException {
		
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(this.pathName+FILE_NAME,true));
		bWriter.write(account.toArchive());
		bWriter.newLine();
		bWriter.flush();
		bWriter.close();
	}
	
	public boolean ricerca(Account account) throws IOException {
		
		BufferedReader bReader = new BufferedReader(new FileReader(this.pathName+FILE_NAME));
		
		String data = bReader.readLine();
		if(null == data) {
			bReader.close();
			return false; //DA MODIFICARE
		}else {
			while(null != data) {
				String[] splitData = data.split("~");
				if(splitData[0].equals(account.getId()) && splitData[1].equals(account.getPassword())) {
					bReader.close();
					return true;
				}
				data = bReader.readLine();
			}
		}
		bReader.close();
		return false;
	}
	
	public ArrayList<String> ricercaContatti(String id) throws IOException{
		
		String formatSearch = id.toLowerCase();
		BufferedReader bReader = new BufferedReader(new FileReader(this.pathName+FILE_NAME));
		String data = bReader.readLine();
		ArrayList<String> contatti = new ArrayList<>();
		if(null == data){
			bReader.close();
			return null; //DA MODIFICARE
		}else{
			while(data != null){
				String[] dataSplit = data.split("~");
				String formatId = dataSplit[0].toLowerCase();
				if (formatId.contains(formatSearch)) {
					contatti.add(dataSplit[0]);
				}			
				data = bReader.readLine();
			}
		}
		bReader.close();
		return contatti;
	}
	
}
