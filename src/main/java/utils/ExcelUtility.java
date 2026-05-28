package utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    // Single workbook instance
    private static Workbook wb = new XSSFWorkbook();

    // Sheets for each loan type
    public static Sheet homeLoan = wb.createSheet("Home Loan");
    public static Sheet personalLoan = wb.createSheet("Personal Loan");
    public static Sheet carLoan = wb.createSheet("Car Loan");

    // Row counters (important for multiple entries)
    private static int homeRow = 1;
    private static int personalRow = 1;
    private static int carRow = 1;

    // Static block → runs once automatically
    static {
        createHeader(homeLoan);
        createHeader(personalLoan);
        createHeader(carLoan);
    }

    // Create header
    public static void createHeader(Sheet sheet) {
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Loan Type");
        header.createCell(1).setCellValue("Principal");
        header.createCell(2).setCellValue("Interest");
        header.createCell(3).setCellValue("EMI");
        
    }

    // Write Home Loan Data
    public static synchronized void writeHomeLoanData(
            String principal, String interest, String emi) {

        Row row = homeLoan.createRow(homeRow++);

        row.createCell(0).setCellValue("Home Loan");
        row.createCell(1).setCellValue(principal);
        row.createCell(2).setCellValue(interest);
        row.createCell(3).setCellValue(emi);
        
    }

    // Write Personal Loan Data
    public static synchronized void writePersonalLoanData(
            String principal, String interest, String emi) {

        Row row = personalLoan.createRow(personalRow++);

        row.createCell(0).setCellValue("Personal Loan");
        row.createCell(1).setCellValue(principal);
        row.createCell(2).setCellValue(interest);
        row.createCell(3).setCellValue(emi);
        
    }

    // Write Car Loan Data
    public static synchronized void writeCarLoanData(
           String type, String principal, String interest, String emi) {

        Row row = carLoan.createRow(carRow++);

        row.createCell(0).setCellValue("Car Loan "+type);
        row.createCell(1).setCellValue(principal);
        row.createCell(2).setCellValue(interest);
        row.createCell(3).setCellValue(emi);
        
    }

    // Save Excel File
    public static void saveExcel() {
        try {
            FileOutputStream fos = new FileOutputStream("TestData/Loans.xlsx");
            wb.write(fos);
            wb.close();
            fos.close();

            System.out.println("Excel file written successfully! :Loans.xlsx");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}