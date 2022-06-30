import java.time.LocalDate;
public class Person {
     public String firstName, lastName, pesel, address, birthDate;
     LocalDate rentDate=null;
    public Person(String firstName, String lastName, String pesel, String address, String birthDate){
        this.firstName=firstName;
        this.lastName=lastName;
        this.pesel=pesel;
        this.address=address;
        this.birthDate=birthDate;
    }
    public Person(){
            this.firstName=null;
            this.lastName=null;
            this.pesel=null;
            this.address=null;
            this.birthDate=null;
    }
    public void showPerson () throws NeverRentException{
          if(this.rentDate==null)
        throw new NeverRentException();
        else System.out.println(this.rentDate);
    }
   public String toString(){
       return this.firstName + " " + this.lastName + " " + this.pesel + " " + this.birthDate + " " + this.address;
}




}
