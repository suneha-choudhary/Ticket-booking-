import java.util.List;

public class Movie{
    private final String title;
    private final List<Show> shows;

    public Movie(String name, List<Show> shows){
        this.title = name;
        this.shows = shows;
    }

    public String getTitle(){
        return title;
    }

    public List<Show> getShows(){
        return shows;
    }

    public void displayShows(){
        for(Show show : shows){
            System.out.println("Show ID: " + show.getShowID() + " | Time: " + show.getTime());
        }
    }
    
    public Show getShowByID(int showID) {
    for (Show show : shows) {
        if (show.getShowID() == showID) {
            return show;
        }
    }
    return null;
}
}