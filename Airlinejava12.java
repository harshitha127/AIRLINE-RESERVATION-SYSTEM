import java.util.Scanner;

interface ReservationSystem {
    void reserveSeat(int seatNum);
    void viewSeats();
    void makePayment(int seatNum);
    void bookingConfirmation(int seatNum);
    void generateETicket(int seatNum);
}

abstract class Airline implements ReservationSystem {
    protected boolean[] seats;
    protected double[] seatPrices;
    protected boolean[] payments;

    public Airline(int numSeats, double defaultPrice) {
        seats = new boolean[numSeats];
        seatPrices = new double[numSeats];
        payments = new boolean[numSeats];
        for (int i = 0; i < numSeats; i++) {
            seatPrices[i] = defaultPrice;
        }
    }

    public void reserveSeat(int seatNum) {
        try {
            if (seats[seatNum - 1]) {
                System.out.println("Sorry, this seat is already reserved.");
            } else {
                seats[seatNum - 1] = true;
                System.out.println("Seat reserved. Thank you.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat number.");
        }
    }

    public void viewSeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            if (seats[i]) {
                System.out.println("Reserved - Price: $" + seatPrices[i]);
            } else {
                System.out.println("Available");
            }
        }
    }
 public void makePayment(int seatNum) {
        try {
            if (!seats[seatNum - 1]) {
                System.out.println("This seat is not reserved yet.");
            } else if (payments[seatNum - 1]) {
                System.out.println("Payment for this seat has already been made.");
            } else {
                System.out.println("Payment for seat " + seatNum + " successful. Amount: $" + seatPrices[seatNum - 1]);
                payments[seatNum - 1] = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat number.");
        }
    }

    public void bookingConfirmation(int seatNum) {
        try {
            if (!seats[seatNum - 1]) {
                System.out.println("This seat is not reserved yet.");
            } else if (!payments[seatNum - 1]) {
                System.out.println("Payment for this seat has not been made yet.");
            } else {
                System.out.println("Booking confirmation for seat " + seatNum + " successful.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat number.");
        }
    }

    public void generateETicket(int seatNum) {
        try {
            if (!seats[seatNum - 1]) {
                System.out.println("This seat is not reserved yet.");
            } else if (!payments[seatNum - 1]) {
                System.out.println("Payment for this seat has not been made yet.");
            } else {
                System.out.println("E-ticket for seat " + seatNum + " generated successfully.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat number.");
        }
    }
}

public class Airlinejava12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of seats: ");
        int numSeats = input.nextInt();

        System.out.print("Enter the default seat price: $");
        double defaultPrice = input.nextDouble();

        ReservationSystem airline = new Airline(numSeats, defaultPrice) {
        };

        while (true) {
            System.out.println("2. View all seats");
            System.out.println("1. Reserve a seat");
            System.out.println("3. Make payment");
            System.out.println("4. Booking confirmation");
            System.out.println("5. Generate e-ticket");
            System.out.println("6. Exit");
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter seat number: ");
                int seatNum = input.nextInt();
                airline.reserveSeat(seatNum);
            } else if (choice == 2) {
                airline.viewSeats();
            } else if (choice == 3) {
                System.out.print("Enter seat number to make payment: ");
                int seatNum = input.nextInt();
                airline.makePayment(seatNum);
            } else if (choice == 4) {
                System.out.print("Enter seat number for booking confirmation: ");
                int seatNum = input.nextInt();
                airline.bookingConfirmation(seatNum);
            } else if (choice == 5) {
                System.out.print("Enter seat number to generate e-ticket: ");
                int seatNum = input.nextInt();
                airline.generateETicket(seatNum);
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        input.close();
    }
}