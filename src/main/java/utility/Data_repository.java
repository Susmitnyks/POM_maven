package utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Data_repository {

    static FileInputStream fs;
    static {
        try {
            fs = new FileInputStream("D:\\DemoFile.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static XSSFWorkbook workbook;
    static {
        try {
            workbook = new XSSFWorkbook(fs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static XSSFSheet sheet = workbook.getSheetAt(0);
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    public static String username_value= String.valueOf(sheet.getRow(0).getCell(0));

}
