/**
* Klasse für Speicherung von MietDetails in Java.
*
* @author Anja Wolf
* @version 1.0
*/


class RentalAgreement {
  private int id;
  private Car car;
  private Person person;
  private int duration;
  private boolean lastday = false;
  private boolean active = false;

  /**
  * Custom Konstruktor mit konstanter Mietdauer 1.
  * @param id ID des Mietvertrages
  * @param car Auto das vermietet werden soll
  * @param person Person an die Auto vermietet werden soll
  */

  public RentalAgreement(final int id, final Car car, final Person person) {
    this.id = id;
    this.person = person;
    this.duration = 1;
    setCar(car);
    this.active = true;
    this.person.addActiveRental();
  }

  /**
  * Custom Konstruktor mit variabler Mietdauer.
  * @param id ID des Mietvertrages
  * @param car Auto das vermietet werden soll
  * @param person Person an die Auto vermietet werden soll
  * @param duration Anzahl der Tage, für die Auto vermietet werden soll
  */

  public RentalAgreement(final int id, final Car car, final Person person, final int duration) {
    this.id = id;
    this.person = person;
    this.duration = duration;
    setCar(car);
    this.active = true;
    this.person.addActiveRental();
  }

  /**
  * Getter für Objektvariablen.
  */

  public int getId() {
    return this.id;
  }

  public Car getCar() {
    return this.car;
  }

  public Person getPerson() {
    return this.person;
  }

  public int getDuration() {
    return this.duration;
  }

  public boolean isLastday() {
    return this.lastday;
  }

  public boolean isActive() {
    return this.active;
  }

  /**
  * Methode um Auto erfolgreich zu Mietvertrag hinzufügen zu können.
  * @param car Auto das hinzugefügt werden soll
  **/

  public void setCar(final Car car) {
    if (car != null && car.isCommissioned() == false
        && this.person.getDrivingLicence() == car.getNeededDrivingLicence()) {
      this.car = car;
      this.car.commissionIt();
    } else {
      return;
    }
  }

  /**
  * Methode um Mietvertrag einen Tag weiterzuschalten.
  * @return Boolean ob letzter Tag des Mietvertrages erreicht wurde.
  **/

  public boolean nextDay() {
    this.lastday = false;
    if (this.active == true) {
      this.duration--;
      if (this.duration == 0) {
        this.lastday = true;
      }
    }
    return this.lastday;
  }

  /**
  * Methode um Mietvertrag zu beenden; jedoch nicht aus der HashMap zu entfernen.
  **/

  public void finish() {
    this.active = false;
    this.car.resetCommission();
    this.person.removeActiveRental();
  }

  /**
  * Methode um Mietvertrag zu beenden; jedoch nicht aus der HashMap zu entfernen.
  **/

  public void cancel() {
    finish();
  }
}
