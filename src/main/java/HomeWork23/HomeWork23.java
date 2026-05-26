/**
 * Classname    HomeWork23
 * @version     0.01
 * @author      Aleksei Borzetsov
 * date         22.05.2026
 */

package HomeWork23;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork23 {

    public void run() {
        System.out.println("; Алексей Борзецов | Домашняя работа №23 | Выдано 20.05.2026 ;");
        System.out.println();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src\\main\\resources\\data.xml"));

            NodeList firstNameNodeList = document.getElementsByTagName("firstName");
            NodeList lastNameNodeList = document.getElementsByTagName("lastName");
            NodeList titleNodeList = document.getElementsByTagName("title");
            NodeList linesNodeList = document.getElementsByTagName("line");

            String firstName = firstNameNodeList.item(0).getTextContent();
            String lastName = lastNameNodeList.item(0).getTextContent();
            String title = titleNodeList.item(0).getTextContent();

            FileWriter fileWriter = new FileWriter("src\\main\\resources\\"
                    + firstName + "_" + lastName + "_" + title + ".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < linesNodeList.getLength(); i++) {
                bufferedWriter.write(linesNodeList.item(i).getTextContent());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
