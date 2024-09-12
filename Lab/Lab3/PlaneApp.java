package Lab3;

import java.util.Scanner;

public class PlaneApp {
    public static void main(String[] args) {
        Plane plane = new Plane();
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Perform the following methods:");
        System.out.println("(1) Show number of empty seats");
        System.out.println("(2) Show the list of empty seats");
        System.out.println("(3) Show the list of seat assignments by seat ID");
        System.out.println("(4) Show the list of seat assignments by customer ID");
        System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7): quit");
        do {
            System.out.print("\tEnter the number of your choice: ");
            choice = sc.nextInt();

            int seatID = 0, custID = 0;
            switch (choice) {
                case 1:
                    plane.showNumEmptySeats();
                    break;
                case 2:
                    plane.showEmptySeats();
                    break;
                case 3:
                    plane.showAssignedSeat(true);
                    break;
                case 4:
                    plane.showAssignedSeat(false);
                    break;
                case 5:
                    System.out.println("Assigning Seat .. ");
                    System.out.print("\tPlease enter SeatID: ");
                    // seatID - 1 due to the nature I arrange my PlantSeat Array in Plane.java
                    seatID = sc.nextInt() - 1;
                    System.out.print("\tPlease enter Customer ID: ");
                    custID = sc.nextInt();
                    plane.assignSeat(seatID, custID);
                    break;
                case 6:
                    System.out.print("\tEnter SeatID to unassign customer from: ");
                    // seatID - 1 due to the nature I arrange my PlantSeat Array in Plane.java
                    seatID = sc.nextInt() - 1;
                    plane.unassignSeat(seatID);
                    break;
                case 7:
                    System.out.println("Program terminating...");
            }
        } while (choice != 7);
        sc.close();
    }

}