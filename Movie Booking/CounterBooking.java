public class CounterBooking extends Booking {

    public CounterBooking(Movie movie, Theatre theatre, int seats) {
        super(movie, theatre, seats);
    }

    @Override
    public void confirmBooking() {
        if (theatre.bookSeats(seats)) {
            System.out.println("✅ Counter booking successful for " + seats + " seat(s).");
        } else {
            System.out.println("❌ Booking failed. Not enough seats available.");
        }
    }
}
