package pwo;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class App {
    public static void main(String[] args) throws IOException {
        try (PDDocument doc = new PDDocument()) {
            PDPage myPage = new PDPage();
            doc.addPage(myPage);

            try (PDPageContentStream contentStream = new PDPageContentStream(doc, myPage)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(25, 700);

                String line1 = "Maven is a build automation tool used primarily for Java projects.";
                contentStream.showText(line1);
                contentStream.newLine();

                String line2 = "Maven is built using a plugin-based architecture.";
                contentStream.showText(line2);
                contentStream.newLine();

                String line3 = "Maven addresses two aspects of building software:";
                contentStream.showText(line3);
                contentStream.newLine();

                String line4 = "how software is built, and its dependencies.";
                contentStream.showText(line4);
                contentStream.newLine();

                contentStream.endText();
            }

            doc.save("plik.pdf");
        }
    }
}

