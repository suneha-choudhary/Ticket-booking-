import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Movie{
    String name;
    List<Show> shows;

    Movie(String name, List<Show> shows){
        this.name = name;
        this.shows = shows;
    }

    String getName(){
        return name;
    }

    List<Show> getShows(){
        return shows;
    }
}

class Show{
    String time;
    Map<Integer, Boolean> seats;

    Show(String time, int totalseats){
        this.time = time;
        seats = new HashMap<>();
        for(int i = 1; i <= totalseats; i++){
            seats.put(i, false);
        }
    }

    String getTime(){
        return time;
    }

    synchronized boolean bookSeat(int seatNumber){
        if(!seats.containsKey(seatNumber)){
            System.out.println("Invalid seat number. Please Enter from the given Seat number!");
            return false;
        }

        if(seats.get(seatNumber)){
            return false;
        }
        seats.put(seatNumber, true);
        return true;
    }

    void displayAvailableSeats(){
        System.out.print("Availabe Seats: ");
        for (Map.Entry<Integer, Boolean> entry : seats.entrySet()) {
            if(!entry.getValue()){
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}


public class Booking{
    List<Movie> movies;

    Booking(){
        movies = new ArrayList<>();
        seedData();
    }

    private void seedData(){
        List<Show> movie1 = new ArrayList<>();
        movie1.add(new Show("10:00 AM", 5));
        movie1.add(new Show("1:00 PM",5));
        movies.add(new Movie("Ludo", movie1));

        List<Show> movie2 = new ArrayList<>();
        movie2.add(new Show("12:00 PM", 5));
        movie2.add(new Show("4:00 PM",5));
        movies.add(new Movie("Interstellar", movie2));
    }

    public void startBooking(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\nAvailable Movies:");
            for (int i = 0; i < movies.size(); i++) {
                System.out.println((i+1) +". " + movies.get(i).getName());
            }

            System.out.print("\n");

            System.out.print("Select a movie (number): ");
            int movieChoice = scanner.nextInt() - 1;
            Movie selectedMovie = movies.get(movieChoice);

            List<Show> shows = selectedMovie.getShows();
            System.out.println("\nAvailable Shows for " + selectedMovie.getName() + ":");
            for(int i = 0; i < shows.size(); i++){
                System.out.println((i+1) + ". " + shows.get(i).getTime());
            }

            System.out.println();

            System.out.println("Select a show (number): ");
            int showChoice = scanner.nextInt() - 1;
            Show selectedShow = shows.get(showChoice);
            System.out.println();

            selectedShow.displayAvailableSeats();

            System.out.println("Enter a seat number to book:  ");
            int seatNumber = scanner.nextInt();

            boolean booked = selectedShow.bookSeat(seatNumber);

            if(booked){
                System.out.println("Seat booked successfully!\n");
            }
            else{
                System.out.println("Booking Failed!! Try again.....\n");
            }
        }
    }

    public static void main(String[] args) {
        Booking system = new Booking();
        system.startBooking();
    }
}