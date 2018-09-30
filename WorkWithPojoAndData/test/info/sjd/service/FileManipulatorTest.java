package info.sjd.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import info.sjd.model.Good;

public class FileManipulatorTest {

	private static String textInFile;
	
	@BeforeClass
	public static void setBeforeClass() {
		List<Good> goods = FileManipulator.readFromFile();
		String text = "";
		for (Good good : goods) {
			text += good.toString() + ";\n";
		}
		textInFile = text;
	}
	
	@Test
	public void testWriteAndReadFromFile() {
		Good good = new Good("art001", "Vacuum cleaner V001", 29995);
		FileManipulator.writeToFile(good, Boolean.FALSE);
		
		List<Good> goods = FileManipulator.readFromFile();
		
		assertTrue(!goods.isEmpty());
		assertEquals((long)goods.get(0).getPrice(), 29995L);
	}
	
	@AfterClass
	public static void setAfterClass() {
		for (String line : textInFile.split(";\n")) {
			String[] blocks = line.split(", ");
			Good good = new Good(blocks[0], blocks[1], Integer.parseInt(blocks[2]));
			FileManipulator.writeToFile(good, Boolean.TRUE);
		}
	}

}
