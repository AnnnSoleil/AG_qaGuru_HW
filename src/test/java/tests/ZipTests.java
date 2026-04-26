package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ZipTests {
    private ClassLoader cl = ZipTests.class.getClassLoader();

    @Test
    void zipParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("files/hw_qa_quru.zip")
        )){
            ZipEntry entry;
            while ((entry = zis.getNextEntry())!=null) {
                if (entry.getName().endsWith(".pdf")) {
                    byte[] pdfbytes = zis.readAllBytes();
                    PDF pdf = new PDF(pdfbytes);
                    assertThat(pdf.text).contains("антикризисный");
                }
                if (entry.getName().endsWith(".xlsx")) {
                    byte[] xlsxBytes = zis.readAllBytes();
                    XLS xls = new XLS(xlsxBytes);
                    String xlsxContent = xls.excel.getSheetAt(0).getRow(0).getCell(4).getStringCellValue();
                    assertTrue(xlsxContent.contains("Вторник"));
                }
                if (entry.getName().endsWith(".csv")) {
                    byte[] csvBytes = zis.readAllBytes();
                    String csvContent = new String(csvBytes, StandardCharsets.UTF_8);
                    assertThat(csvContent).contains("Понедельник");
                }
            }
        }
    }
}
