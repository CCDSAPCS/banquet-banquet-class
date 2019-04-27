import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Banquet {

    //initialization parameters for banquet class.
    public Banquet(int tablecount,int tableseats,ArrayList<String> groups){
        numtables=tablecount;
        numseats=tableseats;
        companies=groups;
    }

    //Initialize the scanner that will be used throughout this shizzle.
    Scanner scan = new Scanner(System.in);
    // companies is an arraylist of every company in attendance. their comanyID is their index in the arrayList
    ArrayList<String> companies;
    //an arraylistof 100 attendees
    ArrayList<Attendee> attendees = new ArrayList<>();

    //an array that tracks the number of attendees sent by each company
    int[] companiescounter = new int[companies.size()];

    //attendeeID 0-99 incremented by the register method. allows attendees to be found within the 100 attendee arraylist
    int aIDcounter;
    //number of tables available
    int numtables;
    //number of seats at each table
    int numseats;
    // the total capacity of the banquet
    int maxattendees = numtables * numseats;



    /*overloaded method that with no parameters that allows an individual to submit him or herself.
     * With the parameter of company, a company can submit multiple attendees at once.
     * All variables are
     */

    public void register() {
        // if the number of attendees made is under 100, take input. otherwise quit
        if (aIDcounter < maxattendees) {
            System.out.println("give company ID");
            int companyID = scan.nextInt();
            int counter = companiescounter[companyID];
            if (counter < 10) {
                System.out.println("Give first name");
                String first = scan.next();
                System.out.println("Give last name");
                String last = scan.next();
                System.out.println("Give allergies");
                String allergies = scan.next();
                int aID = aIDcounter;
                attendees.add(new Attendee(first, last, companyID, allergies, aID));
                companiescounter[companyID]++;
                aIDcounter++;
            } else System.out.println("Each Company can only submit 10 attendees");
        } else System.out.println("REGISTRATION CLOSED");
    }

    //Allows a given company to submit multiple attendees at once, sort of
    public void register(int company) {
        if (aIDcounter < maxattendees) {
            Scanner scan = new Scanner(System.in);
            System.out.println("give number of applicants");
            int counter = scan.nextInt();
            if (counter + companiescounter[company] <= 10) {
                for (int i = 0; i < counter; i++) {
                    System.out.println("Enter info for attendee#" + (i + 1));
                    System.out.println("Give first name");
                    String first = scan.next();
                    System.out.println("Give last name");
                    String last = scan.next();
                    System.out.println("Give allergies");
                    String allergies = scan.next();
                    int aID = aIDcounter;
                    attendees.add(new Attendee(first, last, company, allergies, aID));
                    companiescounter[company]++;
                    aIDcounter++;
                }
            } else System.out.println("Maximum number of attendees per company is 10");
        } else System.out.println("REGISTRATION CLOSED");
    }

    public ArrayList<Attendee> returnAttendees() {

        return attendees;
    }
    public int returnAttendeeSize(){
        return attendees.size();
    }

    public int returnMax() {
        return maxattendees;
    }

    public void seating() {
        if (attendees.size() < maxattendees) {
            System.out.println("REGISTRATION INCOMPLETE. NO SEATING ARRANGEMENT AVAILABLE");
        } else {
            Table table = new Table(numtables, numseats, companies.size());
            table.populate(companiescounter, attendees);
            System.out.println(Arrays.toString(table.returnTables()));

        }


    }

}
