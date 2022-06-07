package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		String path = "c:\\temp\\list.csv";
		new File("c:\\temp\\" + "out").mkdir();
		String pathWrite = "c:\\temp\\out\\summary.csv";

		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] vect =line.split(",");
				String name = vect[0];
				double price = Double.parseDouble(vect[1]);
				int quatity = Integer.parseInt(vect[2]);
				list.add(new Product(name,price,quatity));
				line = br.readLine();
				}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite))){
				bw.write("Name item, Total Price");
				bw.newLine();
				for(Product item : list ) {
					bw.write(item.getName() + ", " + String.format("%.2f", item.sum()));
					bw.newLine();
				}
			}
			catch(IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		}
		catch(IOException e) {
			System.out.println("Error reading file: "+e.getMessage());
		}
				

	}

}
