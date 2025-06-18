import java.util.*;

public class TheaterSystem{
    private final List<Movie> movies = new ArrayList<>();

    public TheaterSystem(){
        List<Show> showList1 = Arrays.asList(new Show(1, "10:00 AM"), new Show(2, "2:00 PM"));
        List<Show> showList2 = Arrays.asList(new Show(3, "12:00 PM"), new Show(4, "6:00 PM"));
        movies.add(new Movie("Inception", showList1));
        movies.add(new Movie("Interstellar", showList2));
    }

    public void displayMovies(){
        for(int i = 0; i < movies.size(); i++){
            System.out.println(i + ": " + movies.get(i).getTitle());
        }
    }

    public void run(){
        try(Scanner sc = new Scanner(System.in)){
            User user = new User();
            
            while(true){
                displayMovies();
                System.out.println("Select a movie by index (or -1 to exit): ");
                int movieIndex = sc.nextInt();

                if(movieIndex == -1) break;
                if(movieIndex < 0 || movieIndex >= movies.size()){
                    System.out.println("Invalid movie index. Try again.");
                    continue;
                }

                Movie selectedMovie = movies.get(movieIndex);
                selectedMovie.displayShows();

                System.out.println("Enter Show ID: ");
                int showID = sc.nextInt();
                sc.nextLine();

                Show selectedShow = selectedMovie.getShowByID(showID);
                if(selectedShow == null){
                    System.out.println("Invalid Show ID. Please try again.");
                    continue;
                }

                selectedShow.displaySeats();

                System.out.print("Enter comma-separated seat numbers (e.g., 1,2,3): \n");
                String[] input = sc.nextLine().split(",");
                int[] seatNumbers = new int[input.length];
                for(int i = 0; i < input.length; i++){
                    seatNumbers[i] = Integer.parseInt(input[i].trim());
                }

                user.bookTicket(selectedMovie, showID, seatNumbers);
            }
        }
    }
}