package it.tirinnanzi.ivsb.entity;

public class Appuntamento {
	
	private String id;
	private String data;
	private String ora;
	private String luogo;
	
	public Appuntamento(String data, String ora, String luogo) {
		this.data = data;
		this.ora = ora;
		this.luogo = luogo;
	}
	
	public Appuntamento(String id, String data, String ora, String luogo) {
		this.id = id;
		this.data = data;
		this.ora = ora;
		this.luogo = luogo;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	public String toArchive(String id) {
		return id + "~" + this.data + "~" + this.ora + "~" + this.luogo;
	}
	
	@Override
	public String toString() {
		return this.data + "~" + this.ora + this.luogo;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Appuntamento)) {
			return false;
		}
		
		Appuntamento oggetto = (Appuntamento)o;
		
		return this.data.equals(oggetto.getData()) && this.luogo.equals(oggetto.getLuogo()) && this.ora.equals(oggetto.getOra());
		
	}
	
}

