package homework4.usingAPI.OMDbApplication;

import homework4.usingAPI.OMDbApplication.Models.MovieRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

@Controller
public class MainController {

    @Autowired
    MovieRepo movieRepo;

    //String variable for api key
    String apikey = "a116d871";

    //String variables to save json object values
    String movieTitle = "",
            movieDirector = "",
            movieDesc = "",
            movieGenre = "",
            movieRating = "",
            moviePoster = "";

    @RequestMapping("/")
    public ModelAndView doHome() {
        ModelAndView page = new ModelAndView("index");


        String movie = getMovie("batman");

        try {
            JSONObject obj = new JSONObject(movie);

            movieTitle = obj.getString("Title");
            movieDirector = obj.getString("Director");
            movieDesc = obj.getString("Plot");
            movieGenre = obj.getString("Genre");
            movieRating = obj.getString("Rated");
            moviePoster = obj.getString("Poster");

            page.addObject("poster", moviePoster);
            page.addObject("title", movieTitle);
            page.addObject("director", movieDirector);
            page.addObject("desc", movieDesc);
            page.addObject("genre", movieGenre);
            page.addObject("rating", movieRating);
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return page;

    }

    public String getMovie(String movie) {
        try {
            URL url = new URL("http://www.omdbapi.com/?t=" + movie + "&apikey=" + apikey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }

            in.close();
            return json.toString();

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            return "Error with API";
        }
    }
}
