import java.util.ArrayList;

public class Table {
    int numTable = 10;
    int tablePeople = 10;
    int numCompanies=16;

    Attendee tables[][] = new ArrayList<Attendee>[numTable][tablePeople];

    public void printTable(int tableNum) {
        for (int i = 0; i < tablePeople; i++) {
            tables[tableNum][tablePeople].print();
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
/*
    public void populate(int josh[][], Attendee guests[][]) { //josh array shows comapany sizes, guests array has all attendees
        int max = 0;
        for (int i = 0; i < numCompanies; i++) {
            for (int j = 0; j < numCompanies; j++) {//finds company with max people
                if (josh[j][1] > max &&josh[j][0]!=0) max = j;
            }
            if(josh[max][1]<=tablePeople){ //if all the people in the company can sit at a table
                for(Attendee person:guests)//for each person in the guests lists
                    if(guests[numTable][tablePeople].returnCompany()==max) {//if a person is part of the "max" company
                        tables[max].add(person);//adds person to the company table arraylist
                    }
            }
            josh[max][0]=0;//sets the company id in josh array to zero so it won't be chosen as max again
        }
    }
}
*/
    
public void populate(int josh[][], Attendee guests[][]) { //josh array shows comapny sizes, guests array has all attendees

//sort companies from biggest to smallest <--Manav
  for(int company: companyArrayList{  
//populate companies with size=10 first <--Chase

//work from big to small when populating the other companies <--Nathan
      if(companySize<tablePeople){//if the company size is less than the number of seats at a table
      for(attendee person: guests){
          if(attendee.getCompany==company){
              for(String seat: tables){
                  if(seat==null)seat=attendee.returnName();
              }//for
          }//if
      }//for
  }//if
  }//big for
}//method
