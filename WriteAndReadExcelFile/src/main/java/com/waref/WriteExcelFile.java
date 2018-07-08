package com.waref;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by on 2018/7/8.
 */
public class WriteExcelFile {
    private static final String FILE_PATH = "src/Students.xlsx";

    // We are making use a single instance to prevent multiple write access to same file.
    private static final WriteExcelFile INSTANCE = new WriteExcelFile();

    public static WriteExcelFile getInstance() {
        return INSTANCE;
    }

    private WriteExcelFile() {
    }

    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Magneto", "90", "100", "80"));
        studentList.add(new Student("Wolverine", "60", "60", "60"));
        studentList.add(new Student("ProfX", "100", "100", "100"));

        writeStudentsListToExcel(studentList);
    }

    private static void writeStudentsListToExcel(List<Student> studentList) {
        // Using XSSF for xlsx format, for xls use HSSF.
        Workbook workbook = new XSSFWorkbook();

        Sheet studentSheet = workbook.createSheet("Students");

        int rowIndex = 0;
        for (Student student : studentList) {
            Row row = studentSheet.createRow(rowIndex++);
            int cellIndex = 0;
            // First place in row is name.
            row.createCell(cellIndex++).setCellValue(student.getName());

            // Second place in row is marks in maths.
            row.createCell(cellIndex++).setCellValue(student.getMaths());

            // Third place in row is marks in Science.
            row.createCell(cellIndex++).setCellValue(student.getScience());

            // Fourth place in row is marks in English.
            row.createCell(cellIndex++).setCellValue(student.getEnglish());
        }

        // Write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
            System.out.println(FILE_PATH + " is successfully written.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
