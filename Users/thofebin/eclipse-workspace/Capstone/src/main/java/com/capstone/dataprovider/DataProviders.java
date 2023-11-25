package com.capstone.dataprovider;

import org.testng.annotations.DataProvider;
import com.capstone.utility.NewExcelLibrary;

public class DataProviders {
    NewExcelLibrary obj = new NewExcelLibrary();

    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        int rows = obj.getRowCount("Credentials");
        int columns = obj.getColumnCount("Credentials");
        int actualRows = rows - 1;

        Object[][] data = new Object[actualRows][columns];

        for (int i = 0; i < actualRows; i++) {
            for (int j = 0; j < columns; j++) {
                // If the column index is for the password, format the value as a string
                if (j == 1) {
                    data[i][j] = String.valueOf(obj.getCellData("Credentials", j, i + 2));
                } else {
                    data[i][j] = obj.getCellData("Credentials", j, i + 2);
                }
            }
        }
        return data;
    }
    
    @DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
			}
		}
		return data;
	}

}
