//This class creates the attendee objects (works with the Banquet class)
public class Attendee {

String first;
String last;
int company = 0;
String allergies;
int aID = 0;

public Attendee(String firstName, String lastName, int company, String allergies, int aID) { //The banquet class passes in these variables for each "attendee"
	this.first = firstName;
	this.last = lastName;
	this.company = company;
	if (!allergies.equals(null)) { //If the person doesn't answer for allergies, no allergy variable is set
		this.allergies = allergies;
	}
	this.aID = aID;
}
//Each of the following methods returns the variable for each separate attendee 
public String returnFirst() {
	return this.first;
}

public String returnLast() {
	return this.last;
}

public int returnCompany() {
	return this.company;
}

public String returnAllergies() {
	return this.allergies;
}

public String returnName() {
	return (this.first + " " + this.last);

}

public int returnAID() {
	return aID;
}
}




