/**
* Klasse für Speicherung von Details zu Personen in Java.
*
* @author Anja Wolf
* @version 1.0
*/

import java.util.HashSet;
import java.util.Set;

class Person {

  private String name;
  private int age;
  private String drivingLicence;
  private int activeRentals = 0;
  HashSet<String> drivingLicences = new HashSet<>();

  /**
  * Custom Constructor für Person Class.
  * @param name Name der Person
  * @param drivingLicence Führerscheinklasse der Person
  */

  public Person(final String name, final String drivingLicence) {
    this.name = name;
    //this.age = age;
    this.drivingLicence = drivingLicence;
    addDrivingLicence(this.drivingLicence);
  }

  /**
  * Getter für einzelne Objekt Variablen.
  */

  public String getName() {
    return this.name;
  }

  public String getDrivingLicence() {
    return this.drivingLicence;
  }

  public Set<String> getDrivingLicences() {
    return this.drivingLicences;
  }

  public int getActiveRentals() {
    return this.activeRentals;
  }

  /**
  * Öffentliche Methode um die Variable activeRentals zu erhöhren/vermindern.
  * Exception: Darf nicht Negativ werden.
  */

  public void addActiveRental() {
    this.activeRentals++;
  }

  public void removeActiveRental() {
    if (this.activeRentals < 1) {
      return;
    }
    this.activeRentals--;
  }

  /**
  * Öffentliche Methode um Werte aus HashShet drivingLicenses zu entfernen
  * oder hinzuzufügen.
  */

  public void addDrivingLicence(final String drivingLicence) {
    drivingLicences.add(drivingLicence);
  }

  public void removeDrivingLicence(final String drivingLicence) {
    drivingLicences.remove(drivingLicence);
  }
}
