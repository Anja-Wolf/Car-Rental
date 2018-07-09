/**
* Klasse für Speicherung von Details zu Autos in Java.
*
* @author Anja Wolf
* @version 1.0
*/

class Car {

  private String manufacturer;
  private String type;
  private String licencePlate;
  private String neededDrivingLicence;
  private boolean commissioned = false;

  /**
  * Custom Konstruktor für Class Car ohne Nummernschild anzugeben.
  * @param manufacturer Hersteller des Autos
  * @param type Modell des Autos
  * @param neededDrivingLicence benötigte Führerscheinklasse um Auto mieten zu dürfen
  */

  public Car(final String manufacturer, final String type, final String neededDrivingLicence) {
    this.manufacturer = manufacturer;
    this.type = type;
    this.neededDrivingLicence = neededDrivingLicence;
  }

  /**
  * Custom Konstruktor für Class Car ohne Nummernschild anzugeben.
  * @param manufacturer Hersteller des Autos
  * @param type Modell des Autos
  * @param licencePlate Nummernschild des Autos
  * @param neededDrivingLicence benötigte Führerscheinklasse um Auto mieten zu dürfen
  */

  public Car(final String manufacturer, final String type,
        final String licencePlate, final String neededDrivingLicence) {
    this.manufacturer = manufacturer;
    this.type = type;
    this.neededDrivingLicence = neededDrivingLicence;
    this.licencePlate = licencePlate;
  }

  /**
  * Getter für einzelne Objekt Variablen.
  */

  public String getManufacturer() {
    return this.manufacturer;
  }

  public String getType() {
    return this.type;
  }

  public String getLicencePlate() {
    return this.licencePlate;
  }

  public String getNeededDrivingLicence() {
    return this.neededDrivingLicence;
  }

  /**
  * Methode um Abzufragen ob Auto im Moment verliehen ist.
  * @return boolean ob Auto im Moment verliehen ist oder nicht
  */

  public boolean isCommissioned() {
    return this.commissioned;
  }

  /**
  * Methode um Nummernschild nachträglich noch festzulegen.
  */

  public void setLicencePlate(final String licencePlate) {
    this.licencePlate = licencePlate;
  }

  /**
  * Methode um Status des Autos auf nicht-verfügbar bzw. momentan verliehen zu setzen.
  */

  public void commissionIt() {
    this.commissioned = true;
  }

  /**
  * Methode um Status des Autos auf wieder verfügbar zu setzen.
  */

  public void resetCommission() {
    this.commissioned = false;
  }
}
