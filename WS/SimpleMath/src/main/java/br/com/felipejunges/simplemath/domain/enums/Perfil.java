package br.com.felipejunges.simplemath.domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	public int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(int cod) {
		
		if(cod == 0) {
			return null;
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod == x.getCod()) {
				return x;
			} 
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
