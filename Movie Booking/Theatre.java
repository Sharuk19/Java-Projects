public class Theatre {
    private String name;
    private int totalSeats;
    private int bookedSeats;

    public Theatre(String name, int totalSeats) {
        this.name = name;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public boolean bookSeats(int count) {
        if (count <= getAvailableSeats()) {
            bookedSeats += count;
            return true;
        } else {
            return false;
        }
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public void showTheatreStatus() {
        System.out.println("🏛️ Theatre: " + name);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + getAvailableSeats());
    }
}

