package system;

import java.io.IOException;
import java.util.*;

public class Farmacie {
	private String numeFarmacie;
	private ArrayList<Farmacist> listaFarmacist;
	private ArrayList<Medicamente> listaMedicamente;
	
	public Farmacie() {
		super();
	}

	public Farmacie(String numeFarmacie, ArrayList<Farmacist> listaFarmacist, ArrayList<Medicamente> listaMedicamente) {
		super();
		this.numeFarmacie = numeFarmacie;
		this.listaFarmacist = listaFarmacist;
		this.listaMedicamente = listaMedicamente;
	}

	public String getNumeFarmacie() {
		return numeFarmacie;
	}

	public void setIdFarmacie(String numeFarmacie) {
		this.numeFarmacie = numeFarmacie;
	}

	public ArrayList<Farmacist> getListaFarmacist() {
		return listaFarmacist;
	}

	public void setListaFarmacist(ArrayList<Farmacist> listaFarmacist) {
		this.listaFarmacist = listaFarmacist;
	}

	public ArrayList<Medicamente> getListaMedicamente() {
		return listaMedicamente;
	}

	public void setListaMedicamente(ArrayList<Medicamente> listaMedicamente) {
		this.listaMedicamente = listaMedicamente;
	}

	@Override
	public String toString() {
		return numeFarmacie + ", " + listaFarmacist;
	}
	
	public void afisareStoc() {
		listaMedicamente.stream().forEach(System.out::println);
	}
	
	public void afisareFarmacist() {
		listaFarmacist.stream().forEach(System.out::println);
	}
	
	public void vanzari( HashMap<String, ArrayList<String>> medicamenteVandute) throws IOException {
		double vanzari = 0;
		
		for(Farmacist f : listaFarmacist) {
			if(medicamenteVandute.containsKey(f.getNumeFarmacist())) {
				ArrayList<String> als = medicamenteVandute.get(f.getNumeFarmacist());
				for(String str : als) {
					for(Medicamente m : listaMedicamente) {
						if(m.getNumeMedicament().equals(str)) {
							vanzari += f.vanzareMedicament(m.getNumeMedicament());
						}
					}
				}
		    }
		}
		
		System.out.println("Farmacia a vandut medicamente in valoare de " + vanzari + " ron!");
	}
	
}
