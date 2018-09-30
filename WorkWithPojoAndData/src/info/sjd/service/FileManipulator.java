package info.sjd.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import info.sjd.model.Good;

public class FileManipulator {

	private static final String USER_DIR = System.getProperty("user.dir");

	private static final String SEP = System.getProperty("file.separator");
	
	private static final String PATH_TO_FILE = USER_DIR + SEP + "test" + SEP + "test.csv";

	public static void writeToFile(Good good, Boolean append) {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(PATH_TO_FILE, append);
			writer.write(good.toString() + ";\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Good> readFromFile() {
		List<Good> goodList = new ArrayList<>();
		
		FileReader reader = null;
		BufferedReader buffReader = null;
		try {
			reader = new FileReader(PATH_TO_FILE);
			buffReader = new BufferedReader(reader);
			String line = "";
			
			while ((line=buffReader.readLine()) != null) {
				String[] blocks = line.replaceAll(";", "").split(", ");
				Good good = new Good(blocks[0], blocks[1], Integer.parseInt(blocks[2]));
				goodList.add(good);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return goodList;
	}
	
	
}
