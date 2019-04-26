import java.util.ArrayList;
public class Table {

    int numTable;
    int tablePeople;
    int numCompanies;

    public Table(int numtable, int tablepeople, int numcompanies){
         numTable = numtable;
         tablePeople = tablepeople;
         numCompanies = numcompanies;

    }



        Attendee tables[][] = new Attendee[numTable][tablePeople];

        public void printTable(int tableNum) {
            for (int i = 0; i < tablePeople; i++) {
                System.out.println(tables[tableNum][tablePeople]);
            }
        }

        public void findPerson(String name) {
            for (int i = 0; i < numTable; i++) {
                for (int j = 0; i < tablePeople; j++) {
                    if (tables[numTable][tablePeople].returnName().equals(name)) {
                        System.out.println("Table Number: " + numTable);
                        System.out.println(("Seat Number: " + tablePeople));
                    }
                }
            }
        }

        public boolean isFull(int tableNum) {
            for (int i = 0; i < tablePeople; i++) {
                if (tables[tableNum][tablePeople] == null) return false;
            }
            return true;
        }


        public void populate(int josh[], ArrayList<Attendee>attendees) { //josh array shows comapny sizes, guests array has all attendees

            for(int i=0;i<josh.length;i++){
                if(josh[i]==numTable){
                    for(Attendee person:attendees){
                        int counter=0;
                        if(person.returnCompany() == i){
                            tables[i][counter]=person;
                            person.setTable(i);
                            counter++;
                        }
                    }
                }
                if(josh[i]<numTable){
                    for(Attendee person:attendees){
                        if(person.returnCompany() == i ){
                            for(int j=0;j<numTable;j++){
                                for(int z=0;z<tablePeople;z++){
                                    if(tables[j][z]==null){
                                        tables[j][z]=person;
                                        person.setTable(j);
                                    }
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

    }


