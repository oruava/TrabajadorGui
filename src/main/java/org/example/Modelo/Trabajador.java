package org.example.Modelo;

public class Trabajador extends Persona {

	public String getIsapre() {
		return isapre;
	}

	public void setIsapre(String isapre) {
		this.isapre = isapre;
	}

	private String isapre;

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	private String afp;

	@Override
	public String toString() {
		return super.toString();
	}
}