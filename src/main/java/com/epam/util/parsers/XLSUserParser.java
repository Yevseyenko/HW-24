package com.epam.util.parsers;

import com.epam.model.User;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class XLSUserParser {
    private static String inputFile = "src/main/resources/emailPassword.xls";
    private static Object[] data = new Object[5];

    public static Object[] getXLSUser() {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            int i = 0;
            Sheet sheet = w.getSheet(0);
            for (int j = 1; j <= 5; j++) {
                User user = new User();
                Cell cell = sheet.getCell(0, j);
                user.setLogin(cell.getContents());
                cell = sheet.getCell(1, j);
                user.setPassword(cell.getContents());
                data[i] = user;
                i++;
            }
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
