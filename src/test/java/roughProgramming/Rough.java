package roughProgramming;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class Rough {


    @Test
    public  void getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1 = formatter.format(date);
        System.out.println(date1);
    }

    @Test
    public void getApi(){
        RestAssured.baseURI="";
        throw new ArithmeticException();

    }
}
