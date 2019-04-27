import java.util.ArrayList;

public class Table {

    int numTable;
    int tableSeats;
    int numCompanies;
    Attendee[][] tables;

    public Table(int numtables, int numseats, int numcompanies){
         numTable = numtables;
         tableSeats = numseats;
         numCompanies = numcompanies;
         tables = new Attendee[numTable][tableSeats];

    }





        public void printTable(int tableNum) {
            for (int i = 0; i < tableSeats; i++) {
                System.out.println(tables[tableNum-1][tableSeats]);
            }
        }

        public void findPerson(String name) {
            for (int i = 0; i < numTable; i++) {
                for (int j = 0; i < tableSeats; j++) {
                    if (tables[numTable][tableSeats].returnName().equals(name)) {
                        System.out.println("Table Number: " + numTable);
                        System.out.println(("Seat Number: " + tableSeats));
                    }
                }
            }
        }

        public boolean isFull(int tableNum) {
            for (int i = 0; i < tableSeats; i++) {
                if (tables[tableNum-1][i] == null) return false;
            }
            return true;
        }

        public boolean isEmpty(int tableNum) {
            for (int i = 0; i < tableSeats; i++) {
                if (tables[tableNum-1][i] != null) return false;
            }
            return true;
        }


        public void populate(int[] CompaniesCounter, ArrayList<Attendee> attendees) { //josh array shows comapny sizes, guests array has all attendees
            int table = 0;
            int seat = 0;

            for(int i=0; i<numCompanies; i++) {
                if (CompaniesCounter[i] == tableSeats && isEmpty(table+1)) {
                    for (Attendee person : attendees) {
                        if (person.returnCompany() == i) {
                            tables[table][seat] = person;
                            person.setTable(table+1);
                            seat++;
                            if (isFull(table+1)) {
                                table++;
                                seat = 0;
                            }
                        }
                    }
                }
            }
            for(int h=0;h<numCompanies;h++){
                    for(Attendee person:attendees){
                        if(person.returnCompany() == h ){
                            for(int j=0; j<numTable; j++){
                                for(int z=0; z<tableSeats; z++){
                                    if(tables[j][z] == null && person.returnTable()==0) {
                                        tables[j][z] = person;
                                        person.setTable(j+1);
                                    }
                                }
                            }
                        }
                    }
            }
    }
        public Attendee[][] returnTables(){
            return tables;
        }

        public void printTables() {
            for( int x=0; x<numTable; x++) {
                System.out.println("TABLE "+(x+1));
                for(int y=0; y<tableSeats; y++) {
                    tables[x][y].print();
                }
            }

        }

    }


