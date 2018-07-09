/**
* Klasse die Rental Agreements speichert.
*
* @author Anja Wolf
* @version 1.0
*/

import java.util.HashMap;
import java.util.HashSet;

class CarRentalAgency {

  HashMap<String, Person> persons  = new HashMap<>(); //Name Person = KEY

  HashMap<String, Car> cars = new HashMap<>(); //Nummernschild = KEY

  HashMap<Integer, RentalAgreement> rentalAgreements = new HashMap<>(); //ID MV = KEY

  int lastId = 0;

  /**
  * Methode um Person zur HashMap "persons" hinzuzufügen, falls noch nicht vorhanden.
  * @param name Name der Person
  * @param drivingLicence Führerscheinklasse der Person
  * @return boolean ob Person zur HashMap hinzugefügt wurde oder nicht
  */

  public boolean addPerson(final String name, final String drivingLicence) {
    boolean result;
    for (String k : persons.keySet()) {
      if (k == name) {
        result = false;
        return result;
      }
    }
    Person person1;
    person1 = new Person(name, drivingLicence);
    persons.put(name, person1);
    result = true;
    return result;
  }

  /**
  * Methode um Auto zur HashMap "cars" hinzuzufügen, falls noch nicht vorhanden.
  * @param manufacturer Hersteller des Autos
  * @param type Modell des Autos
  * @param licencePlate Nummernschild des Autos
  * @param neededDrivingLicence benötigte Führerscheinklasse um Auto mieten zu dürfen
  * @return boolean ob Auto zur HashMap hinzugefügt wurde oder nicht
  */

  public boolean addCar(final String manufacturer, final String type,
        final String licencePlate, final String neededDrivingLicence) {
    boolean result;
    for (String k : cars.keySet()) {
      if (k == licencePlate) {
        result = false;
        return result;
      }
    }
    Car car1;
    car1 = new Car(manufacturer, type, licencePlate, neededDrivingLicence);
    cars.put(licencePlate, car1);
    result = true;
    return result;
  }

  /**
  * Methode um Auto an Person für individuellen Zeitraum zu vermieten.
  * @param name Name der Person (Key für Hashmap) an die Auto vermietet werden soll
  * @param licencePlate Nummernschild des Autos (Key für Hashmap) das vermietet werden soll
  * @param days Anzahl der Tage, für die Auto vermietet werden soll
  * @return ID (Key der Hashmap rentalAgreements) des neuen Mietvertrages
  */

  public int rent(final String name, final String licencePlate,
      final int days) {
    this.lastId = lastId;
    int re = 0;
    int duration = days;
    Person person2;
    person2 = persons.get(name);
    Car car2;
    car2 = cars.get(licencePlate);

    if (persons.containsKey(name) == false) {
      re = -1;
      return re;
    }
    if (cars.containsKey(licencePlate) == false) {
      re = -2;
      return re;
    }
    if (car2 != null && car2.isCommissioned() == true) {
      re = -3;
      return re;
    }
    if (person2 != null && car2 != null
        && person2.getDrivingLicence() != car2.getNeededDrivingLicence()) {
      re = -4;
      return re;
    }
    if (person2 != null && car2 != null && car2.isCommissioned() == false
          && person2.getDrivingLicence() == car2.getNeededDrivingLicence()) {
      //if (persons.containsKey(name) && cars.containsKey(licencePlate)) {
      this.lastId++;
      RentalAgreement rentalA = new RentalAgreement(this.lastId, car2, person2, days);
      rentalAgreements.put(this.lastId, rentalA);
      re = this.lastId;
    }
    return re;
  }

  /**
  * Methode um Auto an Person für einen Tag zu vermieten (Aufruf der 1. rent Methode).
  * @param name Name der Person (Key für Hashmap) an die Auto vermietet werden soll
  * @param licencePlate Nummernschild des Autos (Key für Hashmap) das vermietet werden soll
  * @return ID (Key der Hashmap rentalAgreements) des neuen Mietvertrages
  */

  public int rent(final String name, final String licencePlate) {
    int rent2 = rent(name, licencePlate, 1);
    return rent2;
  }

  /**
  * Methode um Auto zurückzugeben und Mietvertrag zu beenden.
  * @param id ID des Mietvertrages (Key der Hashmap rentalAgreements)
  * @return boolean ob Auto erfolgreich zurückgegeben wurde
  */

  public boolean returnCar(final int id) {
    if (rentalAgreements.containsKey(id) == false) {
      return false;
    }
    RentalAgreement rentalA;
    rentalA = rentalAgreements.get(id);
    Car car = rentalA.getCar();
    Person person = rentalA.getPerson();
    car.resetCommission();
    person.removeActiveRental();
    rentalA.finish();
    return true;
  }

  /**
  * Methode um alle Mietverträge einen Tag weiterzuschalten.
  * @return HashSet mit allen ID's der Mietverträge, die jetzt ihren letzten Tag erreicht haben
  */

  public HashSet<Integer> nextDay() {
    HashSet<Integer> endingTomorrow = new HashSet<>();
    RentalAgreement rentalA;
    for (int k: rentalAgreements.keySet()) {
      rentalA = rentalAgreements.get(k);
      boolean lastDayCheck = rentalA.nextDay();
      if (lastDayCheck == true) {
        endingTomorrow.add(k);
      }
    }
    return endingTomorrow;
  }
}
