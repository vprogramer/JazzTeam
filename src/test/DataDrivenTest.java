package test;

import com.company.Converter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DataDrivenTest {
    @Test
    public void firstTestGetNameNumber() {

        System.out.println("Test #1, Number: 0");

        Converter numberTranslate = new Converter();

        System.out.println(0 + " = " + numberTranslate.convertToString(new BigInteger("0")));

        assertEquals(" ноль", numberTranslate.convertToString(new BigInteger("0")));
    }

    @Test
    public void secondTestGetNameNumber() {

        System.out.println("Test #2, Number: 1111");

        Converter numberTranslate = new Converter();

        System.out.println(1111 + " = " + numberTranslate.convertToString(new BigInteger("1111")));

        assertEquals(" одна тысяча сто одиннадцать", numberTranslate.convertToString(new BigInteger("1111")));
    }

    @Test
    public void thirdTestGetNameNumber() {

        System.out.println("Test #3");

        Converter converter = new Converter();
        String[] numberString = new String[]{" сто один", " один", " семнадцать", " сорок три", " пятьдесят два", " десять миллионов одна тысяча один"};
        int[] numberLong = {101, 1, 17, 43, 52, 10001001};

        for (int i = 0; i < numberString.length; i++) {
            System.out.println(numberString[i] + " = " + converter.convertToString(BigInteger.valueOf(numberLong[i])));
            assertEquals(numberString[i],
                    converter.convertToString(BigInteger.valueOf(numberLong[i])));

        }

    }

    @Test
    public void forthTestGetNumberFromFile() {

        System.out.println("Test #4");
        Converter converter = new Converter();

        String line;
        List<String> numberString = new ArrayList<String>();
        List<Long> numberLong = new ArrayList<Long>();
        int iterator = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("./src/test/Test.txt"));) {

            while ((line = reader.readLine()) != null) {
                if (iterator % 2 == 0) {
                    numberString.add(line);
                    iterator++;
                } else {
                    numberLong.add(Long.parseLong(line));
                    iterator++;
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: Test.txt");
        }

        for (int i = 0; i < iterator / 2; i++) {
            System.out.println(numberLong.get(i).intValue() + " = " + numberString.get(i));
            assertEquals(numberString.get(i), converter.convertToString(BigInteger.valueOf(numberLong.get(i))));
        }
    }
}
