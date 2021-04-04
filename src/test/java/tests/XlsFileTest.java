package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.*;

public class XlsFileTest {
    private final String expectedData = "Табель";

    @Test
    void xlsSimpleTest() {
        String xlsFilePath = "./src/test/resources/files/1.xls";

        XLS xls = new XLS(getFile(xlsFilePath));
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsCellTest() {
        String xlsFilePath = "./src/test/resources/files/1.xls";

        XLS xls = new XLS(getFile(xlsFilePath));
        String actualData = getCellValueXlsFile(xls, 0, 0, 4);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxTest() {
        String xlsxFilePath = "./src/test/resources/files/1.xlsx";

        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
