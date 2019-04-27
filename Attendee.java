//This class creates the attendee objects (works with the Banquet class)
public class Attendee {

    String aFirst;
    String aLast;
    int aCompany;
    String aAllergies;
    int aID;
    int aTable;

    public Attendee(String firstName, String lastName, int company, String allergies, int aID) { //The banquet class passes in these variables for each "attendee"
        aFirst = firstName;
        aLast = lastName;
        aCompany = company;
        if (!allergies.equals(null)) { //If the person doesn't answer for allergies, no allergy variable is set
            aAllergies = allergies;
        }
        aID = aID;
    }
//Each of the following methods returns the variable for each separate attendee

        public String returnFirst() {
            return aFirst;
        }

        public String returnLast() {
            return aLast;
        }

        public int returnCompany() {
            return aCompany;
        }

        public String returnAllergies() {
            return aAllergies;
        }

        public String returnName() {
            return (aFirst + " " + aLast);

        }
        public int returnTable() {
        return aTable;
        }

        public int returnAID() {
            return aID;
        }

        public void print() {
            System.out.println("name: " + returnName());
            System.out.println("allergies: " + aAllergies);
        }

        public void setTable(int table) {
        aTable = table;
        }

    }




