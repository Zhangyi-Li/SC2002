package Lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Plane {
    private PlaneSeat[] seat = new PlaneSeat[12];
    private int numEmptySeat = 12;

    /*
     * For every PlaneSeat obj in seat array, (index + 1) of the PlaneSeat obj will
     * be the SeatID of that PlaneSeat
     * E.g. seat[0] PlaneSeat.seatId = 1, seat[1] PlaneSeat.seatId = 2, ... seat[11]
     * PlaneSeat.seatId = 12
     * This arrangement will not change throughout the program.
     */

    public Plane() {
        // a constructor for the class Plane.
        for (int i = 0; i < 12; i++) {
            seat[i] = new PlaneSeat(i + 1);
        }

    }

    public PlaneSeat[] sortSeats() {
        // a method to sort the seats according to ascending order of customerID.
        // A copy of the original seat array is used for sorting instead of the
        // original.

        // clone the list without referencence
        PlaneSeat[] sortedSeat = seat.clone();
        Arrays.sort(sortedSeat, Comparator.nullsLast(Comparator.comparingInt(PlaneSeat::getCustomerID)));

        return sortedSeat;
    }

    public void showNumEmptySeats() {
        // a method to display the number of empty seats.

        // int seatUnOccupied = 0;
        this.numEmptySeat = 0;

        for (int i = 0; i < seat.length; i++) {
            if (!seat[i].isOccupied()) {
                this.numEmptySeat++;
            }
        }
        // this.numEmptySeat = seatUnOccupied;

        System.out.printf("There are %d empty seats \n", numEmptySeat);
    }

    public void showEmptySeats() {
        // a method to display the list of empty seats.

        System.out.println("The following seats are empty:");
        for (int i = 0; i < seat.length; i++) {
            if (!seat[i].isOccupied()) {
                System.out.printf("SeatID %d \n", seat[i].getSeatID());
            }
        }

    }

    public void showAssignedSeat(boolean bySeatId) {
        // a method to display the assigned seats with seat ID and customer ID.
        // If bySeatId is true, the order will be by seatID, else order is by
        // customerID

        System.out.println("The seat assignments are as follow:");

        PlaneSeat[] newSeat = new PlaneSeat[12];

        if (bySeatId) {
            newSeat = seat;
        } else {
            newSeat = sortSeats();
        }

        for (int i = 0; i < newSeat.length; i++) {
            if (newSeat[i].isOccupied()) {
                System.out.printf("SeatID %d assigned to CustomerID %d. \n", newSeat[i].getSeatID(),
                        newSeat[i].getCustomerID());
            }
        }

    }

    public void assignSeat(int seatId, int cust_id) {
        // a method that assigns a customer ID to an empty seat .

        if (seat[seatId].isOccupied()) {
            System.out.println("Seat already assigned to a customer.");
        } else {
            // added a check that the cust_id is unique (not required by lab)
            boolean custUnique = Arrays.stream(seat)
                    .noneMatch(s -> s.getCustomerID() == cust_id); // Check if no seat matches the customerID

            if (custUnique) {
                if (seat[seatId] == null)
                    seat[seatId] = new PlaneSeat(seatId);
                seat[seatId].assign(cust_id);
                System.out.println("Seat Assigned");
            } else
                System.out.printf("Customer ID '%d' already exist, please try again with another Customer ID.\n",
                        cust_id);
        }
    }

    public void unassignSeat(int seatId) {
        // a method that unassigns a seat.

        if (!seat[seatId].isOccupied()) {
            System.out.println("Seat not occupied to a customer.\r");
        } else {
            seat[seatId].unAssign();
            System.out.println("Seat UnAssigned\r");
        }

    }

}
