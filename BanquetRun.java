import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BanquetRun {

    public static void main(String[] args) {
        int numTables;
        int numSeats;
        boolean done = false;
        int input;
        int company;
        ArrayList<String> Companies = new ArrayList<>(Arrays.asList("WalMart", "Kroger", "Amazon", "Lowes", "BestWestern", "KMart", "Fusian", "Heinz",
                "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor", "AMD", "Razer"));
        Scanner scan = new Scanner(System.in);
        System.out.println("WELCOME TO BANQUET");

        System.out.println("How many Tables do you have?");
        input = scan.nextInt();
        numTables = input;

        System.out.println("How many Seats at each Table?");
        input = scan.nextInt();
        numSeats = input;

        Banquet b1 = new Banquet(numTables,numSeats,Companies);

        while (!done) {
            System.out.println("CHOOSE A FUNCTION");
            System.out.println("    1)Register a single attendee");
            System.out.println("    2)Register multiple attendees from one company");
            System.out.println("    3)Print seating arrangement");
            System.out.println("    4)Print Attendee list");
            System.out.println("    5)Print Detailed Attendee list");
            System.out.println("    6)Quit Program");
            input = scan.nextInt();

            if(input==1) {
                b1.register();
            }
            else if(input==2){
                System.out.println("INPUT COMPANY ID 0-15");
                company = scan.nextInt();
                b1.register(company);
            }
            else if(input==3) {
                System.out.println("PRINTING SEATING");
                b1.seating();

            }
            else if(input==4) {
                System.out.println("ATTENDEE LIST");
                System.out.println("Total attendees: "+b1.returnAttendeeSize());
                for(Attendee dude: b1.returnAttendees() ) {
                    System.out.println(dude.returnName());
                }

            }
            else if (input==5){
                System.out.println("DETAILED ATTENDEE LIST");
                System.out.println("Total attendees: "+b1.returnAttendeeSize());
                if(b1.returnAttendeeSize()<b1.returnMax()) {
                    for (Attendee dude : b1.returnAttendees()) {
                        dude.print();
                    }
                }
                else {
                    for(Attendee dude: b1.returnAttendees()) {
                        dude.print();
                        System.out.println("Table: "+dude.returnTable());
                    }
                }
            }
            else if(input==6){
                System.out.println("TERMINATING PROGRAM");
                done = true;
            }
            else System.out.println("INVALID INPUT, TRY AGAIN");
        }
    }
}
