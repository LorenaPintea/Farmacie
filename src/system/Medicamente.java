package system;

import java.util.*;

public class Medicamente {
	private String idMedicament;
	private String numeMedicament;
	private String categorieMedicament;
	private String infoMedicament;
	private double pretMedicament;
	private String infoPacient;
	private String infoFurnizor;
	private Date dataAchizitie;
	private Date dataExpirare;
	private int nrMedicamente;
	

	public Medicamente(String idMedicament, String numeMedicament, String categorieMedicament, String infoMedicament,
			double pretMedicament, String infoPacient, String infoFurnizor, Date dataAchizitie, Date dataExpirare,
			int nrMedicamente) {
		super();
		this.idMedicament = idMedicament;
		this.numeMedicament = numeMedicament;
		this.categorieMedicament = categorieMedicament;
		this.infoMedicament = infoMedicament;
		this.pretMedicament = pretMedicament;
		this.infoPacient = infoPacient;
		this.infoFurnizor = infoFurnizor;
		this.dataAchizitie = dataAchizitie;
		this.dataExpirare = dataExpirare;
		this.nrMedicamente = nrMedicamente;
	}

	public String getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(String idMedicament) {
		this.idMedicament = idMedicament;
	}

	public String getNumeMedicament() {
		return numeMedicament;
	}

	public void setNumeMedicament(String numeMedicament) {
		this.numeMedicament = numeMedicament;
	}

	public String getCategorieMedicament() {
		return categorieMedicament;
	}

	public void setCategorieMedicament(String categorieMedicament) {
		this.categorieMedicament = categorieMedicament;
	}

	public String getInfoMedicament() {
		return infoMedicament;
	}

	public void setInfoMedicament(String infoMedicament) {
		this.infoMedicament = infoMedicament;
	}

	public double getPretMedicament() {
		return pretMedicament;
	}

	public void setPretMedicament(double pretMedicament) {
		this.pretMedicament = pretMedicament;
	}

	public String getInfoPacient() {
		return infoPacient;
	}

	public void setInfoPacient(String infoPacient) {
		this.infoPacient = infoPacient;
	}

	public String getInfoFurnizor() {
		return infoFurnizor;
	}

	public void setInfoFurnizor(String infoFurnizor) {
		this.infoFurnizor = infoFurnizor;
	}

	public Date getDataAchizitie() {
		return dataAchizitie;
	}

	public void setDataAchizitie(Date dataAchizitie) {
		this.dataAchizitie = dataAchizitie;
	}

	public Date getDataExpirare() {
		return dataExpirare;
	}

	public void setDataExpirare(Date dataExpirare) {
		this.dataExpirare = dataExpirare;
	}

	public int getNrMedicamente() {
		return nrMedicamente;
	}

	public void setNrMedicamente(int nrMedicamente) {
		this.nrMedicamente = nrMedicamente;
	}

	@Override
	public String toString() {
		return idMedicament + "," + numeMedicament + "," + categorieMedicament + "," + infoMedicament
				+ "," + pretMedicament + "," + infoPacient + "," + infoFurnizor + "," 
				+ dataAchizitie + "," + dataExpirare + "," + nrMedicamente + "\n";
	}
	
	
}
