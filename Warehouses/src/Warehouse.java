import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    public static int id=0;
    public int idm;
    List<Room> Rooms = new ArrayList<>();
    List<Person> Persons = new ArrayList<>();
    public Warehouse(){
        id++;
        this.idm=id;
    }
    public void saveFile () {
        StringBuilder sb = new StringBuilder();
        sb.append("Pomieszczenia w magazynie(id):  \n");
        for (int i = 0; i < Rooms.size(); i++)
            sb.append(Rooms.get(i).getIdp() + ", ");
        sb.append("\n");
        sb.append("\n");
        sb.append("Pomieszczenie(id) i dane osoby, ktora je wynajmuje(imie, nazwisko, pesel, data urodzenia, miejsce zamieszkania, data wynajmu) \n");
        for (int i = 0; i < Rooms.size(); i++) {
            if(Rooms.get(i).rented.pesel!=null) {
                sb.append(Rooms.get(i).getIdp() + ": ");
                sb.append(Rooms.get(i).rented.firstName + " " + Rooms.get(i).rented.lastName + " " + Rooms.get(i).rented.pesel + " " + Rooms.get(i).rented.birthDate + " " + Rooms.get(i).rented.address + " ");
                if (Rooms.get(i).rented.pesel != null)
                    sb.append(Rooms.get(i).rented.rentDate + " ");
                sb.append("\n");
            }
            else sb.append(Rooms.get(i).getIdp() + ": \n");
        }
        sb.append("\n");
        sb.append("Pomieszczenie(id) i przedmioty, ktore sie w nim znajduja(id, rozmiar) \n");
        for(int i=0; i<Rooms.size(); i++){
            sb.append(Rooms.get(i).getIdp() + ": ");
            for(int j=0; j<Rooms.get(i).a1.size(); j++){
                sb.append(Rooms.get(i).a1.get(j).name + " " + Rooms.get(i).a1.get(j).size + ", ");
            }
        sb.append("\n");
        }
        sb.append("\n");
        sb.append("Pomieszczenie(id) i pojazdy, ktore sie w nim znajduja(id, rozmiar, cecha) \n");
        for(int i=0; i<Rooms.size(); i++){
            sb.append(Rooms.get(i).getIdp() + ": ");
            for(int j=0; j<Rooms.get(i).a2.size(); j++){
                sb.append(Rooms.get(i).a2.get(j).name + " " + Rooms.get(i).a2.get(j).size + " " + Rooms.get(i).a2.get(j).feature + ", ");
            }
            sb.append("\n");
        }
        try {
            FileOutputStream fos = new FileOutputStream("stanMagazynu.txt");
            PrintWriter pw = new PrintWriter(fos);
            pw.print(sb);
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public String getIdm(){
        return this.idm + "";
    }

}