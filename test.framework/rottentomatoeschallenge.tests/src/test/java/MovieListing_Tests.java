import rottentomateschallenge.automation.AutomationException;

import java.util.HashMap;

public class MovieListing_Tests extends RottenTomatoesAppTestBase {

    public MovieListing_Tests(HashMap<String, String> expectedResults) {
        super(expectedResults);
    }

    public void should_have_list_of_movies() throws AutomationException {
        app.search.navigateTo();
        app.search.searchFor(expected.get("movieTitle"));

        app.movieListing.isCurrentPage();

        assert(app.movieListing.getMovieList().size() > 0);
    }
}
