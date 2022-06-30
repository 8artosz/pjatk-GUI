public class NeverRentException extends Exception {
    public NeverRentException(){
        super("Osoba nigdy nie wypozyczyla zadnego pomieszczenia ");
    }
}
