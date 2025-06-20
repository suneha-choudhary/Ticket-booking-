public class Show{
    private final int showID;
    private final String time;
    private final boolean[] seats = new boolean[5];

    public Show(int showID, String time){
        this.showID = showID;
        this.time = time;
    }

    public int getShowID(){
        return showID;
    }

    public String getTime(){
        return time;
    }

    public void displaySeats() {
        for(int i = 0; i < seats.length; i++){
            System.out.println("Seat " + (i+1) + ": " + (seats[i] ? "Booked" : "Available"));
        }
    }
 
    public boolean bookSeats(int[] seatNumbers){
        for(int seat : seatNumbers){
            if(seat < 1 || seat > seats.length){
                System.out.println("Seat " + seat + " is out of range.");
                return false;
            }
            if(seats[seat - 1]){
                // System.out.println("Seat " + seat + " is already booked.");
                return false;
            }
        }
        for(int seat : seatNumbers){
            seats[seat - 1] = true;
            // System.out.println("Seat " + seat + " booked successfully");
        }
        return true;
    }
}