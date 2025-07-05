package com.TestNGOCT;

import org.testng.annotations.DataProvider;

public class DataUtils2 {
	
	
	//@DataProvider( indices = {0,1}, parallel = true)
	
	@DataProvider()

	public  String[][] dataUtils() {
		
		
		String [] [] data  = new String[3][2];
		data [0][0] = "Husseyhari@gmail.com";
		data [0] [1] = "Hari@123";
		
		data [1] [0] = "8637615641";
		data [1] [1] = "Hari@123";
		
		data[2] [0] = "newData";
		data [2] [1] = "Password";

		return data;
	}

}
