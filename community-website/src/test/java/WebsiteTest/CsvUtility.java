package WebsiteTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvUtility {


	static final String csv_Path = "../community-website/src/test/resources/communityWeblist.csv";
	static int rowcount = 0;
	static String[] cell;
	static String[][] arlist;

	public static String[][] getCsvFileList() {
		try {
			int i = 0;
			arlist= new String[getCsvRowCount()][2];
	
			CSVReader csvReader = new CSVReader(new FileReader(csv_Path));

			while ((cell = csvReader.readNext()) != null) {
				arlist[i] = cell;
				i++;
			}

			csvReader.close();
			return arlist;
		}

		catch (FileNotFoundException e) {
			System.out.println("CSV File not Found");
		}

		catch (IOException e) {
			System.out.println("CSV File not Readable");
		} catch (CsvValidationException e) {
			System.out.println("CSV Validation Failed");
		}
		
		return arlist;
	}

	public static int getCsvRowCount() {
		try {

			CSVReader csvReader = new CSVReader(new FileReader(csv_Path));

			while ((cell = csvReader.readNext()) != null) {
				rowcount++;
			}
		
			csvReader.close();
			
			
		}catch (FileNotFoundException e) {
			System.out.println("CSV File not Found");
		}catch (IOException e) {
			System.out.println("CSV File not Readable");
		}catch (CsvValidationException e) {
			System.out.println("CSV Validation Failed");
		}
		
		return rowcount;
	}


}
