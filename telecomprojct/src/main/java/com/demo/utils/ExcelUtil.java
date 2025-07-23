package com.demo.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {
    private Workbook workbook;
    private String filePath;

    public ExcelUtil(String filePath) throws IOException {
        this.filePath = filePath;
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
    }

    // Get cell data
    public String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }

    // Write data to a cell
    public void setCellData(String sheetName, int rowNum, int colNum, String value) throws IOException {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
        saveWorkbook();
    }

    // Save workbook
    private void saveWorkbook() throws IOException {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            workbook.write(out);
        }
    }

    // Close workbook
    public void close() throws IOException {
        workbook.close();
    }

    // Example method to iterate through all rows and cells
    public void printAllData(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        Iterator<Row> rowIterator = sheet.iterator();
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (Cell cell : row) {
                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }
    }
}
