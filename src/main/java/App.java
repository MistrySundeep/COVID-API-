import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        apiRequest();
    }

    static String generateCountry(){
        String country;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of a country: ");
        country = sc.next();
        return country;
    }

    static void apiRequest() throws Exception{
        String s = generateCountry();

        HttpResponse<JsonNode> response = Unirest.get("https://covid-19-data.p.rapidapi.com/country?name=" +s+ "&format=json")
                .header("x-rapidapi-key", "ecefebcdc4mshbfe28ad931987c8p1f7e8djsnf69ba853cee2")
                .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .asJson();


        Gson gson = new Gson();
        //Makes an object array from the response
        countriesObj[] cObj = gson.fromJson(response.getBody().toString(), countriesObj[].class);

        //Outputs the specified part of the Json
        try {
            FileWriter fileWriter = new FileWriter("COVID_INFO_" + cObj[0].country.toUpperCase());
            fileWriter.write("Country: " + cObj[0].country +"\n");
            fileWriter.write("Code: " + cObj[0].code +"\n");
            fileWriter.write("Confirmed: " + cObj[0].confirmed +"\n");
            fileWriter.write("Critical: " + cObj[0].critical +"\n");
            fileWriter.write("Deaths: " + cObj[0].deaths +"\n");
            fileWriter.write("Recovered: " + cObj[0].recovered +"\n");
            fileWriter.write("Last Change: " + cObj[0].lChange +"\n");
            fileWriter.write("Last Updated: " + cObj[0].lUpdate +"\n");

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            System.out.println("There has been an error");
            e.printStackTrace();
        }
    }
}





//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    JsonParser jp = new JsonParser();
//    JsonElement je = jp.parse(response.getBody().toString());
//    String prettyJsonString = gson.toJson(je);
//    System.out.println(prettyJsonString);