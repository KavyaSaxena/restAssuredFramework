package Util;


import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {

    static Workbook workbook;
    static Sheet sheet;

    public static String TESTDATA_SHEET_PATH = "/home/Kavya.saxena/Desktop/restAssuredFramework/src/test/java/TestData/LoginTestData.xlsx";

    public static Object[][] getTestData(String sheetName){
        FileInputStream file = null;
        try{
            file = new FileInputStream(TESTDATA_SHEET_PATH);
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(file);
        } catch (InvalidFormatException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i = 0; i< sheet.getLastRowNum(); i++){
            for(int k =0; k< sheet.getRow(0).getLastCellNum();k++){
                data[i][k] = sheet.getRow(i+1).getCell(k).toString();
                // System.out.println(data[i][k];
            }
        }
        return data;
    }

}
