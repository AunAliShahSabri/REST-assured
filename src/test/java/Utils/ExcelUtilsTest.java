package Utils;

import java.io.IOException;

public class ExcelUtilsTest
{
    public static void main(String[] args) throws IOException {
        String exclPath = "./data/Test Data.xlsx";
        String sheetName = "Sheet1";
        xcelUtils excel = new xcelUtils(exclPath, sheetName);

        excel.getNoOfRows();
        excel.getCellData(1,0);
    }
}
