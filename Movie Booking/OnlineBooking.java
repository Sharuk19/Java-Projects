public class OnlineBooking extends Booking {

    public OnlineBooking(Movie movie, Theatre theatre, int seats) {
        super(movie, theatre, seats);
    }

    @Override
    public void confirmBooking() {
        if (theatre.bookSeats(seats)) {
            System.out.println("✅ Online booking successful for " + seats + " seat(s).");
        } else {
            System.out.println("❌ Booking failed. Not enough seats available.");
        }
    }
}
