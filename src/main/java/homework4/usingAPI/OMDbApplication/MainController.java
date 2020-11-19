package homework4.usingAPI.OMDbApplication;

import homework4.usingAPI.OMDbApplication.Models.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    MovieRepo movieRepo;

    @RequestMapping("/")
    public ModelAndView doHome() {
        ModelAndView page = new ModelAndView("index");

        String movieTitle = "",
                movieDirector = "",
                movieDesc = "",
                movieGenre = "",
                movieRating = "",
                moviePoster = "";

        String apikey = "a116d871";

        return page;

    }
}
