import java.util.HashMap;
import java.util.HashSet;


class CarRentalApp {

  public static void main(String[] args) {
    final HashMap<String, Person> persons  = new HashMap<>();

    final HashMap<Integer, RentalAgreement> rentalAgreements = new HashMap<>();

    CarRentalAgency agency;
    agency = new CarRentalAgency();

    // agency.addPerson("David Yow", "B");
    // agency.addPerson("David W. Sims", "B");
    // agency.addCar("Jeep", "Wrangler", "M UAS 1", "B");
    // agency.addCar("Land Rover", "Defender", "M UAS 2", "B");
    // HashSet<Integer> endingTomorow = new HashSet<>();
    // endingTomorow.add(agency.rent("David Yow", "M UAS 1"));
    // endingTomorow.add(agency.rent("David W. Sims", "M UAS 2"));
    // System.out.println(agency.nextDay());
    //
    // // Car carA;
    // // Car carB;
    // // Person personWithB;
    // // Person personWithoutB;
    // //
    // // carA = new Car("Land Rover", "Defender", "A");
    // // carB = new Car("Land Rover", "Defender", "B");
    // // personWithB = new Person("Elektra Natchios", "B");
    // // personWithoutB = new Person("Jessica Jones", "A");
    // //
    // // RentalAgreement ra = new RentalAgreement(1, carB, personWithoutB);
    // //
    // // System.out.println(ra.nextDay());
    //
    // System.out.println(endingTomorow);

    // String name = "Anja";
    //
    // System.out.println(persons.containsKey(name));
    // System.out.println(agency.rent("David Yow", "M UAS 1"));
    //
    // Car c = new Car("Audi", "A8", "B");
    // Person p = new Person("Anja", "B");
    //
    // RentalAgreement Hallo = new RentalAgreement(1, c, p);
    // rentalAgreements.put(1, Hallo);
    //
    // System.out.println(rentalAgreements.get(1));

    agency.addPerson("David Yow", "B");
    agency.addPerson("David W. Sims", "B");
    agency.addCar("Jeep", "Wrangler", "M UAS 1", "B");
    agency.addCar("Land Rover", "Defender", "M UAS 2", "B");
    HashSet<Integer> endingInThreeDays = new HashSet<>();
    endingInThreeDays.add(agency.rent("David Yow", "M UAS 1", 3));
    int raNo = agency.rent("David W. Sims", "M UAS 2", 5);
    HashSet<Integer> endingInFiveDays = new HashSet<>();
    endingInFiveDays.add(raNo);
    HashSet<Integer> emptySet = new HashSet<>();
    System.out.println(agency.nextDay());
    System.out.println(agency.nextDay());
    System.out.println(agency.nextDay());
    System.out.println(agency.nextDay());
    System.out.println(agency.returnCar(raNo));
    System.out.println(agency.nextDay());

  }
}
