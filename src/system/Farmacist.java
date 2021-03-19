package system;

import java.io.*;
import java.util.*;

public class Farmacist {
	private String numeFarmacist;
	private ArrayList<Medicamente> medicamente;
	
	public Farmacist(String numeFarmacist, ArrayList<Medicamente> medicamente) {
		super();
		this.numeFarmacist = numeFarmacist;
		this.medicamente = medicamente;
	}

	public String getNumeFarmacist() {
		return numeFarmacist;
	}

	public void setNumeFarmacist(String numeFarmacist) {
		this.numeFarmacist = numeFarmacist;
	}

	public ArrayList<Medicamente> getMedicamente() {
		return medicamente;
	}

	public void setMedicamente(ArrayList<Medicamente> medicamente) {
		this.medicamente = medicamente;
	}

	@Override
	public String toString() {
		return numeFarmacist + ": " + medicamente ;
	}
	
	public void cautaMedicamentDenumire(String denumire) {
		for(Medicamente m : medicamente) {
			if(m.getNumeMedicament().equals(denumire)) {
				System.out.println("Medicamentul exista, il puteti gasi in raftul cu ID-ul: " + m.getIdMedicament());
				break;
			}
		}
	}
	
	public void modificaInfoMedicament(String denumireMedicament, String modifica) throws IOException {
		
		String line = "";
		String splitBy = ",";  
		BufferedReader br = new BufferedReader(new FileReader("medicamente.csv"));
		StringBuffer inputBuffer = new StringBuffer();
		
		try { 
			
			while ((line = br.readLine()) != null)  {
				
				String[] meds = line.split(splitBy);
				
				if(meds[1].equals(denumireMedicament)) {
					meds[3] = modifica;
					String replace = (Arrays.deepToString(meds)).toString();
					inputBuffer.append(replace);
					inputBuffer.append('\n');
				}else {
					inputBuffer.append(line);
					inputBuffer.append('\n');
				}
			}
			
			br.close();
			
			FileOutputStream fileOut = new FileOutputStream("medicamente.csv");
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();
	        System.out.println("Medicamentul a fost modificat cu succes!");
	        
			}catch (NumberFormatException e) {  
				e.printStackTrace();  
			}catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch(IOException e2) {
				e2.printStackTrace();
			}
		
	}
	
	private void modificaNrMedicament(String denumireMedicament, int modifica) throws IOException {
		
		String line = "";
		String splitBy = ",";  
		BufferedReader br = new BufferedReader(new FileReader("medicamente.csv"));
		StringBuilder inputBuffer = new StringBuilder();
		
		try { 
			
			while ((line = br.readLine()) != null)  {
				
				String[] meds = line.split(splitBy);
				
				if(meds[1].equals(denumireMedicament)) {
					meds[9] = String.valueOf(modifica);
					
					String replace = meds[0] + "," + meds[1] + "," + meds[2] + "," + meds[3] + "," + meds[4] + "," + 
							meds[5] + "," + meds[6] + "," + meds[7] + "," + meds[8] + "," + meds[9];
					
					inputBuffer.append(replace);
					inputBuffer.append('\n');
				}else {
					inputBuffer.append(line);
					inputBuffer.append('\n');
				}
			}
			
			br.close();
			
			FileOutputStream fileOut = new FileOutputStream("medicamente.csv");
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();
	        System.out.println("Medicamentul a fost vandut cu succes!");
	        
			}catch (NumberFormatException e) {  
				e.printStackTrace();  
			}catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch(IOException e2) {
				e2.printStackTrace();
			}
		
	}
	
	public double vanzareMedicament(String denumireMedicament) throws IOException {
		double nr = 0;
		for(Medicamente m : medicamente) {
			if(m.getNumeMedicament().equals(denumireMedicament) && m.getNrMedicamente() > 0) {
				modificaNrMedicament(denumireMedicament, m.getNrMedicamente() - 1);
				nr += m.getPretMedicament();
			}
		}
		
		return nr;
	}
	
	public void adaugareMedicament(Medicamente m) {
	        try {
	            FileWriter fw = new FileWriter("medicamente.csv", true);
	            fw.write(m.toString());
	            fw.close();
	            System.out.println("Medicamentul a fost adaugat cu succes!");
	        }
	        catch(IOException e) {
	        	e.printStackTrace();
	        }
	}

}
