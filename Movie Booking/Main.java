import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Avengers: Endgame", 180);
        Theatre theatre = new Theatre("PVR Chennai", 100);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Movie & Theatre Info");
            System.out.println("2. Book Ticket (Online)");
            System.out.println("3. Book Ticket (Counter)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    movie.showDetails();
                    theatre.showTheatreStatus();
                    break;
                case 2:
                case 3:
                    System.out.print("Enter number of seats: ");
                    int seats = sc.nextInt();
                    Booking booking;
                    if (choice == 2)
                        booking = new OnlineBooking(movie, theatre, seats);
                    else
                        booking = new CounterBooking(movie, theatre, seats);
                    booking.confirmBooking();
                    break;
                case 4:
                    System.out.println(" Thank you for using the booking system!");
                    System.exit(0);
                default:
                    System.out.println(" Invalid option. Try again.");
            }
        }
    }
}
