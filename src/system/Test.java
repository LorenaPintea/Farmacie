package system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException {
		
		Medicamente m1 = new Medicamente("1023","Dulcolax","OTC (eliberare fara prescriptie medicala)","infomed1",14,"infopacient1","infofurnizor1",
				convertStringToDate("2020-11-30"),convertStringToDate("2021-11-30"),5);
		
//		System.out.println("\n-----------AFISARE MEDICAMENT-----------\n");
//		System.out.print(m1);
		
		ArrayList<Medicamente> listaMedicamente = creareListaMedicamente();
		
//		System.out.println("\n-----------AFISARE LISTA MEDICAMENTE-----------\n");
//		listaMedicamente.stream().forEach(System.out::print);
		
		Farmacist f1 = new Farmacist("Alexandra Pintea", listaMedicamente);
		
//		System.out.println("\n-----------AFISARE FARMACIST-----------\n");
//		System.out.println(f1);
		
		Farmacist f2 = new Farmacist("Andreea Pop", listaMedicamente);
		Farmacist f3 = new Farmacist("Laura Voiculescu", listaMedicamente);
		
		ArrayList<Farmacist> listaFarmacist = new ArrayList<Farmacist>();
		listaFarmacist.add(f1);
		listaFarmacist.add(f2);
		listaFarmacist.add(f3);
		
//		f1.cautaMedicamentDenumire("Anaftin");
//		f2.adaugareMedicament(m1);
//		f3.modificaInfoMedicament("Dulcolax", "laxativ");
//		System.out.println(f3.vanzareMedicament("Dulcolax"));
	
		Farmacie farma1 = new Farmacie("HelpNet", listaFarmacist, listaMedicamente);
		
//		farma1.afisareStoc();
//		farma1.afisareFarmacist();
		
		HashMap<String,ArrayList<String>> set = new HashMap<String,ArrayList<String>>();
		ArrayList<String> als1= new ArrayList<String>();
		als1.add("Otipax");
		als1.add("Algocalmin");
		als1.add("Moxifloxacina");
		set.put("Alexandra Pintea", als1);
		
		farma1.vanzari(set);
	}

	public static ArrayList<Medicamente> creareListaMedicamente() throws NumberFormatException, FileNotFoundException, IOException {
		ArrayList<Medicamente> lista = new ArrayList<Medicamente>();
		String line = "";
		String splitBy = ",";  
		BufferedReader br = new BufferedReader(new FileReader("medicamente.csv"));
		try { 
			
			while ((line = br.readLine()) != null)  {
				
				String[] meds = line.split(splitBy);
				double pret = Double.parseDouble(meds[4]);
				int nr = Integer.parseInt(meds[9]);
				
				Medicamente m = new Medicamente(meds[0], meds[1], meds[2], meds[3], pret, 
						meds[5], meds[6], convertStringToDate(meds[7]), convertStringToDate(meds[8]), nr);  
				 
				lista.add(m);
				}  
			}catch (NumberFormatException e) {  
				e.printStackTrace();  
			}catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch(IOException e2) {
				e2.printStackTrace();
			}
		
		br.close();
		return lista;
	}
	
	public static Date convertStringToDate(String dateString) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateObj = null;
	    
	    try {
	    	dateObj = simpleDateFormat.parse(dateString);
	    }catch ( Exception ex ){
	        ex.printStackTrace();
	    }
	    
	    return dateObj;
	}
	
}
