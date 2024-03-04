package com.rappidtech.utilities;

import com.github.javafaker.Faker;
import com.rappidtech.tests.TC_01_VerifyLoginWithValidUserNameAndPassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelUtils {
    private static final Logger logger = LogManager.getLogger(ExcelUtils.class);

    public static Faker faker = new Faker();
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    /**
     * This method will generate First Names and last Names with the help of the faker library
     *
     * @param sheetName       the name of the sheet for your excel
     * @param fileName        the file name of the excel sheet
     * @param numberOfRecords how many records we want tp generate
     */
    public static void generateFirstNameLastNameIntoExcelSheet(String sheetName, String fileName, int numberOfRecords) {
        logger.info("Generating First Name and Last Name into Excel Sheet");
        workbook = new XSSFWorkbook(); // initialize workbook object
        sheet = workbook.createSheet(sheetName); // create a new worksheet inside excel

        for (int i = 0; i < numberOfRecords; i++) {
            Row row = sheet.createRow(i); // create a new row everytime at index of i -> 0 1 2 3 4 etc...
            Cell firstName = row.createCell(0); // first column is firstName
            Cell lastName = row.createCell(1); // second column is lastName

            firstName.setCellValue(faker.name().firstName()); // set value of firstName using faker
            lastName.setCellValue(faker.name().lastName());  // set value of lastName using faker
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);// create a file
            workbook.write(fileOutputStream); // write the excel into a file
        } catch (FileNotFoundException e) {
            logger.error("File not found exception");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("IO Exception");
            throw new RuntimeException(e);
        } finally {
            try {
                workbook.close();// close workbook
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method will generate First Names and passwords with the help of the faker library
     *
     * @param sheetName       the name of the sheet for your excel
     * @param fileName        the file name of the excel sheet
     * @param numberOfRecords how many records we want tp generate
     */
    public static void generateFirstNameAndPasswordIntoExcelSheet(String sheetName, String fileName, int numberOfRecords) {
        logger.info("Generating First Name and Password into Excel Sheet");
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < numberOfRecords; i++) {
            Row row = sheet.createRow(i);
            Cell firstName = row.createCell(0);// first column is firstName
            Cell password = row.createCell(1);// second column is password

            firstName.setCellValue(faker.name().firstName());// set value of firstName using faker
            password.setCellValue(faker.internet().password());// set value of password using faker
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);// create a file
            workbook.write(fileOutputStream); // write the excel into a file
        } catch (FileNotFoundException e) {
            logger.error("File not found exception");
            throw new RuntimeException(e);
        } catch (IOException e) {
            logger.error("IO Exception");
            throw new RuntimeException(e);
        } finally {
            try {
                workbook.close();// close workbook
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param filePath  the path to the excel file
     * @param sheetName the sheet name insdie your workbook : example "Sheet1"
     */
    public static void getExcelInstance(String filePath, String sheetName) {
        logger.info("Getting the Excel Instance");
        try {
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the number of rows present in the Excel sheet
     */
    public static int getRowCount() {
        logger.info("Getting the Row Count");
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows : " + rowCount);
        return rowCount;
    }

    /**
     * @return the number of column present in the Excel sheet
     */
    public static int getColCount() {
        logger.info("Getting the Column Count");
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }

    /**
     * This method will read the cell data and return it in the form of a string
     * @param rowNum the row number
     * @param colNum the column number
     * @return the cell data in the form of a string
     */
    public static String getCellDataString(int rowNum, int colNum) {
        logger.info("Getting the Cell Data");
        String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellData;
    }


    /**
     * This methold will read excel sheet data set and return them
     * in the form of two dimensional array
     *
     * @return two dimensional array of the excel dataset
     */
    public static Object[][] getDataSet(String filePath, String sheetName) {
        logger.info("Getting the Data Set from Excel");
        getExcelInstance(filePath, sheetName);
        int rowCount = getRowCount();
        int colCount = getColCount();
        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = getCellDataString(i, j);
                data[i][j] = cellData;
            }
        }
        return data;
    }


}
