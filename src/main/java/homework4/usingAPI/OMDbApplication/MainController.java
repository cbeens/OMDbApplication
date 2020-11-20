package homework4.usingAPI.OMDbApplication;

import homework4.usingAPI.OMDbApplication.Models.Movie;
import homework4.usingAPI.OMDbApplication.Models.MovieRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.UUID;

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

    //ModelAndView variable for use in methods
    ModelAndView page;

    @RequestMapping("/")
    public ModelAndView doHome() {
        page = new ModelAndView("index");

        page.addObject("movieslist", movieRepo.findAll());

        page.addObject("poster", moviePoster);
        page.addObject("title", movieTitle);
        page.addObject("director", movieDirector);
        page.addObject("desc", movieDesc);
        page.addObject("genre", movieGenre);
        page.addObject("rating", movieRating);

        return page;

    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ModelAndView add() {

        Movie movie = new Movie(movieTitle, movieDirector, movieDesc, movieGenre, movieRating, moviePoster);

        movieRepo.save(movie);

        ModelAndView page = new ModelAndView("redirect:/");
        page.addObject("movieslist", movieRepo.findAll());
        return page;
    }

    @RequestMapping(value = "/search", method=RequestMethod.GET)
    public ModelAndView search(@RequestParam("search") String movie) {

        //modify movie string, replacing empty spaces with + sign for GET
        movie = movie.replaceAll("\\s","+");

        page = new ModelAndView("redirect:/");
        getMovie(movie);

        return page;
    }

    public void getMovie(String movie) {
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

            try {
                JSONObject obj = new JSONObject(json.toString());

                movieTitle = obj.getString("Title");
                movieDirector = obj.getString("Director");
                movieDesc = obj.getString("Plot");
                movieGenre = obj.getString("Genre");
                movieRating = obj.getString("Rated");
                moviePoster = obj.getString("Poster");
            }

            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
