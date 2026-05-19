package Utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {

    public static void main(String[] args) {

        Workbook wb = new XSSFWorkbook();

        // Create 3 Sheets
        Sheet HomeLoan = wb.createSheet("Home Loan");
        Sheet PersonalLoan = wb.createSheet("Personal Loan");
        Sheet CarLoan = wb.createSheet("Car Loan");

        // HOME LOAN DATA
        createHeader(HomeLoan);
        Object[][] homeData = {
            {"2026", "61486", "298404", "359890", "4938514", "1.23%"},
            {"May", "7486", "37500", "44986", "4992514", "0.15%"},
            {"Jun", "7542", "37444", "44986", "4984971", "0.30%"}
        };

        writeData(HomeLoan, homeData);

        // PERSONAL LOAN DATA
        
        createHeader(PersonalLoan);
        Object[][] personalData = {
            {"Month 1", "12000", "3000", "15000", "480000", "2%"},
            {"Month 2", "12500", "2800", "15300", "467500", "4%"}
        };

        writeData(PersonalLoan, personalData);

        // CAR LOAN DATA
        
        createHeader(CarLoan);

        Object[][] carData = {
            {"Month 1", "119000", "11875", "131000", "1381000", "7%"},
            {"Month 2", "120000", "11000", "131000", "1261000", "15%"}
        };

        writeData(CarLoan, carData);

        // Save file
        try {
            FileOutputStream fos = new FileOutputStream("TestData/Loans.xlsx");
            wb.write(fos);
            wb.close();
            fos.close();
            System.out.println("Excel with 3 sheets created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reusable method for Header
    public static void createHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Year");
        header.createCell(1).setCellValue("Principal");
        header.createCell(2).setCellValue("Interest");
        header.createCell(3).setCellValue("Total Payment");
        header.createCell(4).setCellValue("Balance");
        header.createCell(5).setCellValue("Loan Paid %");
    }

    // Reusable method for Data Writing
    public static void writeData(Sheet sheet, Object[][] data) {
        int rowNum = 1;

        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < rowData.length; i++) {
                row.createCell(i).setCellValue(rowData[i].toString());
            }
        }
    }
}