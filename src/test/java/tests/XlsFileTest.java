package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getFile;
import static utils.Files.readXlsxFromPath;

public class XlsFileTest {
    @Test
    void xlsSimpleTest() {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "Табель";
        XLS xls = new XLS(getFile(xlsFilePath));
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() {
        String xlsFilePath = "./src/test/resources/files/1.xls";
        String expectedData = "Табель";
        XLS xls = new XLS(getFile(xlsFilePath));
        String actualData = xls.excel.getSheetAt(0).getRow(0).getCell(4).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxTest() {
        String xlsxFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "Табель";

        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));


    }
}
