public abstract class Booking {
    protected Movie movie;
    protected Theatre theatre;
    protected int seats;

    public Booking(Movie movie, Theatre theatre, int seats) {
        this.movie = movie;
        this.theatre = theatre;
        this.seats = seats;
    }

    public abstract void confirmBooking();
}
