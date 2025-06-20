
public class User{
    public User(){
    }

    public void bookTicket(Movie movie, int showID, int[] seatNumbers){
        for (Show show : movie.getShows()) {
        if (show.getShowID() == showID) {
            if (show.bookSeats(seatNumbers)) {
                System.out.println("Tickets booked successfully!");
            } else {
                System.out.println("Seat already booked or invalid.");
            }
            return;
        }
    }
    System.out.println("Show not found.");
    }
}