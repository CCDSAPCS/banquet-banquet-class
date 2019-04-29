import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Banquet {

    //initialization parameters for banquet class.
    public Banquet(int numtables,int numseats,ArrayList<String> companies){
        numTables=numtables;
        numSeats=numseats;
        Companies=companies;
        maxattendees = numtables*numseats;
        CompaniesCounter = new int[Companies.size()];
    }

    //Initialize the scanner that will be used throughout this shizzle.
    Scanner scan = new Scanner(System.in);
    // companies is an arraylist of every company in attendance. their comanyID is their index in the arrayList
    ArrayList<String> Companies;
    //an arraylistof 100 attendees
    ArrayList<Attendee> attendees = new ArrayList<>();

    //an array that tracks the number of attendees sent by each company
    int[] CompaniesCounter;

    //attendeeID 0-99 incremented by the register method. allows attendees to be found within the 100 attendee arraylist
    int aIDcounter = 0;
    //number of tables available
    int numTables;
    //number of seats at each table
    int numSeats;
    // the total capacity of the banquet
    int maxattendees;

    int companyID;

    String tempCompID;

    String first;

    String last;

    String allergies;

    int loopcount;

    String[] variables;

    String line;

    /*overloaded method that with no parameters that allows an individual to submit him or herself.
     * With the parameter of company, a company can submit multiple attendees at once.
     * All variables are
     */

    public void register() {
        // if the number of attendees made is under 100, take input. otherwise quit
        if (aIDcounter < maxattendees) {
            System.out.println("give company ID");
            companyID = scan.nextInt();
            int counter = CompaniesCounter[companyID];
            if (counter < 10) {
                System.out.println("Give first name");
                first = scan.next();
                System.out.println("Give last name");
                last = scan.next();
                System.out.println("Give allergies");
                allergies = scan.next();
                attendees.add(new Attendee(first, last, companyID, allergies, aIDcounter));
                CompaniesCounter[companyID]++;
                aIDcounter++;
            }
            else System.out.println("Each Company can only submit 10 attendees");
        }
        else System.out.println("REGISTRATION CLOSED");
    }

    //Allows a given company to submit multiple attendees at once, sort of
    public void register(int company) {
        if (aIDcounter < maxattendees) {
            Scanner scan = new Scanner(System.in);
            System.out.println("give number of applicants");
            int counter = scan.nextInt();
            if (counter + CompaniesCounter[company] <= 10) {
                for (int i = 0; i < counter; i++) {
                    System.out.println("Enter info for attendee#" + (i + 1));
                    System.out.println("Give first name");
                    first = scan.next();
                    System.out.println("Give last name");
                    last = scan.next();
                    System.out.println("Give allergies");
                    allergies = scan.next();
                    attendees.add(new Attendee(first, last, company, allergies, aIDcounter));
                    CompaniesCounter[company]++;
                    aIDcounter++;
                }
            }
            else System.out.println("Maximum number of attendees per company is 10");
        }
        else System.out.println("REGISTRATION CLOSED");
    }

    public void register(String filename) throws FileNotFoundException {
        try {
        Scanner scanner=new Scanner(new File(filename));
        scanner.useDelimiter(",");
        loopcount=0;
            while (scanner.hasNext()) {
                line=scanner.nextLine();
                variables = line.split(",");
                last = variables[0];
                first = variables[1];
                tempCompID = variables[2];
                companyID = Integer.parseInt(tempCompID);
                allergies = randomallergy();
                attendees.add(new Attendee(first, last, companyID, allergies, aIDcounter));
                aIDcounter++;
                loopcount++;
            }
            scanner.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
        System.out.println("Attendees generated: "+loopcount);

    }

    public String randomallergy() {
        int randy = (int)(Math.random()*4);
        if(randy == 4) return "nuts";
        else if (randy == 3) return "seafood";
        else if (randy == 2) return "lobster";
        else if (randy == 1) return "gluten";
        else return "none";
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
        }
        else {
            Table table = new Table(numTables, numSeats, Companies.size());
            table.populate(CompaniesCounter, attendees);
            table.printTables();

        }


    }

}
