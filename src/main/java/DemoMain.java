import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoMain {
    public static void main(String[] args) {

        Faker faker = new Faker();
        System.out.println(faker.internet().password());

//        String name = faker.name().fullName(); // Miss Samanta Schmidt
//        String firstName = faker.name().firstName(); // Emory
//        String lastName = faker.name().lastName(); // Barton
//
//        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
//
//        System.out.println(name  + "   ---  " + firstName + "    " + lastName + "   " + streetAddress );

//        for (int i = 0; i < 100 ; i++) {
//            System.out.println( faker.address().zipCode());
//
//        }




    }
}
