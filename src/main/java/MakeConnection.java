import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MakeConnection {

    public static String getPetByID(String value) throws IOException {
        URL url = new URL("https://petstore.swagger.io/v2/pet/");
        var urlConnection = new URL(url + value).openConnection();
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        } catch (FileNotFoundException e){
            return "404";
        }
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null){
            output.append(line);
        }
        in.close();
        return output.toString();
    }

    public static void postPet(String pet){

    }
}
