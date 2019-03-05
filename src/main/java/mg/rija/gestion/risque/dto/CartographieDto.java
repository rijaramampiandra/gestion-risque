package mg.rija.gestion.risque.dto;

import java.io.Serializable;

public class CartographieDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String firstValue;
	private String secondValue;
	private String thirdValue;
	private String fourthValue;
	private String fifthValue;
	private String classe1;
	private String classe2;
	private String classe3;
	private String classe4;
	private String classe5;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}

	public String getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}

	public String getThirdValue() {
		return thirdValue;
	}

	public void setThirdValue(String thirdValue) {
		this.thirdValue = thirdValue;
	}

	public String getFourthValue() {
		return fourthValue;
	}

	public void setFourthValue(String fourthValue) {
		this.fourthValue = fourthValue;
	}

	public String getFifthValue() {
		return fifthValue;
	}

	public void setFifthValue(String fifthValue) {
		this.fifthValue = fifthValue;
	}

	public String getClasse1() {
		return classe1;
	}

	public void setClasse1(String classe1) {
		this.classe1 = classe1;
	}

	public String getClasse2() {
		return classe2;
	}

	public void setClasse2(String classe2) {
		this.classe2 = classe2;
	}

	public String getClasse3() {
		return classe3;
	}

	public void setClasse3(String classe3) {
		this.classe3 = classe3;
	}

	public String getClasse4() {
		return classe4;
	}

	public void setClasse4(String classe4) {
		this.classe4 = classe4;
	}

	public String getClasse5() {
		return classe5;
	}

	public void setClasse5(String classe5) {
		this.classe5 = classe5;
	}

}
