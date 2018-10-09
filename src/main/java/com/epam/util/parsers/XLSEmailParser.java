package com.epam.util.parsers;

import com.epam.model.Email;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class XLSEmailParser {
    private static String inputFile = "src/main/resources/emailInfo.xls";
    private static Object[] data = new Object[5];

    public static Object[] getXLSEmail() {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            int i = 0;
            Sheet sheet = w.getSheet(0);
            for (int j = 1; j <= 5; j++) {
                Email email = new Email();
                Cell cell = sheet.getCell(0, j);
                email.setReceiver(cell.getContents());
                cell = sheet.getCell(1, j);
                email.setSubject(cell.getContents());
                cell = sheet.getCell(2, j);
                email.setText(cell.getContents());
                data[i] = email;
                i++;
            }
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
