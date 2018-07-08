package com.waref;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by on 2018/7/7.
 */
public class ReadExcelFile {
    private static final String FILE_PAHT = "src/Students.xlsx";

    public static void main(String[] args) {
        List<Student> studentList = getStudentListFromExcel();
        System.out.println(studentList);
    }

    private static List<Student> getStudentListFromExcel() {
        List<Student> studentList = new ArrayList<>();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(FILE_PAHT);

            // Using XSSF for xlsx format, for xls use HSSF.
            Workbook workbook = new XSSFWorkbook(fis);
            int numberOfSheets = workbook.getNumberOfSheets();

            // Looping over each workbook sheet.
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                Iterator rowIterator = sheet.iterator();

                // Iterator over each row.
                while (rowIterator.hasNext()) {
                    Student student = new Student();
                    Row row = (Row) rowIterator.next();
                    Iterator cellIterator = row.cellIterator();

                    // Iterating over each row.
                    while (cellIterator.hasNext()) {
                        Cell cell = (Cell) cellIterator.next();
                        // The cell containing String will is name.
                        if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                            student.setName(cell.getStringCellValue());
                            // The cell containing numeric value will contain marks.
                        } else if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                            // Cell with index 1 contains marks in Maths.
                            if (cell.getColumnIndex() == 1) {
                                student.setMaths(String.valueOf(cell.getNumericCellValue()));
                            }
                            // Cell with index 2 contains marks in Science.
                            else if (cell.getColumnIndex() == 2) {
                                student.setScience(String.valueOf(cell.getNumericCellValue()));
                            }
                            // Cell with index 3 contains marks in English.
                            else if (cell.getColumnIndex() == 3) {
                                student.setEnglish(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                    }
                    // End iterating a row, add all the elements of a row in list.
                    studentList.add(student);
                }
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
