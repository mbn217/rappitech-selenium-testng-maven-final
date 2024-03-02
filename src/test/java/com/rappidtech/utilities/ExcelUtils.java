package com.rappidtech.utilities;

import com.github.javafaker.Faker;
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
    public static Faker faker = new Faker();
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    /**
     * This method will generate First Names and last Names with the help of the faker library
     * @param sheetName the name of the sheet for your excel
     * @param fileName the file name of the excel sheet
     */
    public static void generateFirstNameLastNameIntoExcelSheet(String sheetName , String fileName){

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < 100 ; i++) {
            Row row = sheet.createRow(i);
            Cell firstName = row.createCell(0);
            Cell lastName = row.createCell(1);

            firstName.setCellValue(faker.name().firstName());
            lastName.setCellValue(faker.name().lastName());
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                workbook.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }




    public static void generateFirstNameAndPasswordIntoExcelSheet(String sheetName , String fileName, int numberOfRecords){

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < numberOfRecords ; i++) {
            Row row = sheet.createRow(i);
            Cell firstName = row.createCell(0);
            Cell password = row.createCell(1);

            firstName.setCellValue(faker.name().firstName());
            password.setCellValue(faker.internet().password());
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                workbook.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }



    /**
     *
     * @param filePath  the path to the excel file
     * @param sheetName the sheet name insdie your workbook : example "Sheet1"
     */
    public static void getExcelInstance( String filePath , String sheetName){
        try {
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @return the number of rows present in the Excel sheet
     */
    public static int getRowCount(){
        int  rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No of Rows : " + rowCount);
        return rowCount;
    }

    /**
     *
     * @return the number of column present in the Excel sheet
     */
    public static int getColCount(){
        int colCount = sheet .getRow(0).getPhysicalNumberOfCells();
        return colCount;
    }

    public static String getCellDataString(int rowNum , int colNum){
        String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellData;
    }


    /**
     * This methold will read excel sheet data set and return them
     * in the form of two dimensional array
     * @return two dimensional array of the excel dataset
     */
    public static Object[][] getDataSet(String filePath , String sheetName){
        getExcelInstance(filePath, sheetName);
        int rowCount = getRowCount();
        int colCount = getColCount();
        Object [][] data  = new Object[rowCount][colCount];

        for(int i = 0 ; i < rowCount ; i++){
            for(int j = 0 ; j < colCount ; j++){
                String cellData = getCellDataString(i,j);
                data[i][j] = cellData;
            }
        }
        return data;
    }



}
