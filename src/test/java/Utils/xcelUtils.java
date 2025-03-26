package Utils;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class xcelUtils
{
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public xcelUtils(String exclPath, String sheetName) throws IOException {
        workbook= new XSSFWorkbook(exclPath); //variable used to getting data from excl
        sheet = workbook.getSheet(sheetName); //Sheet1 of the Test Data file

    }

    //create function to get data from excel.
    public static void getCellData(int rowNum, int colNum) throws IOException {
//        String xclPath = "./data/Test Data.xlsx"; //giving path to file Test Data.xlsx
//        workbook = new XSSFWorkbook(xclPath); //variable used to getting data from excl
//        sheet = workbook.getSheet("Sheet1"); //Sheet1 of the Test Data file

        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));

        System.out.println(value);

    }

    public static void getNoOfRows() throws IOException {
        String projDir = System.getProperty("user.dir");
        System.out.println(projDir);

        int countSheet = sheet.getLastRowNum();
        System.out.println(countSheet);
    }
}
