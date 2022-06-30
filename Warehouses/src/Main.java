import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "";
        Stuff stuff = null;
        Person person = null;
        Room room = null;
        Warehouse m = null;
        Room p1 = new Room(200);
        Room p2 = new Room(100);
        Room p3 = new Room(125);
        Room p4= new Room(500);
        Room p5 = new Room(75);
        Room p6 = new Room(180);
        Room p7 = new Room(220);
        Room p8 = new Room(60);
        Room p9 = new Room(140);
        Room p10 = new Room(250);
        Person o1 = new Person("Bartek", "Wasilewski", "99031100244", "ul.Jana Sobieskiego 82, 16-400 Suwalki", "11.03.1999");
        Person o2 = new Person("Rafal", "Nowak", "902010220032", "ul.Kowalskiego 2, 16-400 Suwalki", "01.02.1990");
        Person o3 = new Person("Aleksandra", "Lozowska", "95031122233", "ul.Pulaskiego 44/20, 16-400 Suwalki","11.03.1995");
        Person o4 = new Person("Jan", "Kowalski", "93020500245", "ul.Perzynskiego 12, 01-883 Warszawa", "05.02.1993");
        Person o5 = new Person("Aneta", "Nowakowska", "94060690678", "ul.Magiera 20/32, 01-883 Warszawa", "06.06.1994");
        List<Warehouse> warehouses = new ArrayList<>();
        Warehouse m1 = new Warehouse();
        m1.Persons.add(o1);
        m1.Persons.add(o2);
        m1.Persons.add(o3);
        m1.Persons.add(o4);
        m1.Persons.add(o5);
        m1.Rooms.add(p1);
        m1.Rooms.add(p2);
        m1.Rooms.add(p3);
        m1.Rooms.add(p4);
        m1.Rooms.add(p5);
        m1.Rooms.add(p6);
        m1.Rooms.add(p7);
        m1.Rooms.add(p8);
        m1.Rooms.add(p9);
        m1.Rooms.add(p10);
        warehouses.add(m1);
        for (int i = 0; i < warehouses.size(); i++)
            Collections.sort(warehouses.get(i).Rooms);
        System.out.println("Lista polecen:");
        System.out.println("wybierz_ magazyn id");
        System.out.println("wybierz_ osobe pesel");
        System.out.println("pokaz_osobe");
        System.out.println("wybierz_pomieszczenie id");
        System.out.println("pokaz_pomieszczenie");
        System.out.println("dodaj_przedmiot nazwa rozmiar");
        System.out.println("dodaj_samochod nazwa rozmiar benzyna/gaz/diesel");
        System.out.println("dodaj_motocykl nazwa rozmiar homologacja_tak/homologacja_nie");
        System.out.println("dodaj_rower nazwa rozmiar liczba_przerzutek");
        System.out.println("usun_przedmiot nazwa rozmiar");
        System.out.println("usun_pojazd nazwa rozmiar cecha");
        System.out.println("pokaz_wolne_pomieszczenia");
        System.out.println("wynajmij_pomieszczenie id");
        System.out.println("zapisz");

        System.out.println();
        for (int i = 0; i < warehouses.size(); i++) {
            System.out.println("Magazyn(id): ");
            System.out.print(warehouses.get(i).idm + " ");
            System.out.println();
            System.out.println();
            System.out.println("Osoby(imie, nazwisko, pesel, data urodzenia, miejsce zamieszkania): ");
            for (int j = 0; j < warehouses.get(i).Persons.size(); j++)
                System.out.println(warehouses.get(i).Persons.get(j));
            System.out.println();
            System.out.println("Pomieszczenia(id, rozmiar): ");
            for (int k = 0; k < warehouses.get(i).Rooms.size(); k++)
                System.out.println(warehouses.get(i).Rooms.get(k));
        }
        System.out.println();
        System.out.println("Dzien dobry, prosze wybrac magazyn do obslugi.");
        do {
            Scanner scan = new Scanner(System.in);
            name = scan.nextLine();
            String parts[] = name.split(" ");
            if (parts[0].equals("wybierz_magazyn")) {
                if(parts.length==2) {
                    for (int i = 0; i < warehouses.size(); i++) {
                        if (warehouses.get(i).getIdm().equals(parts[1])) {
                            m = warehouses.get(i);
                            System.out.println("Wybrales magazyn o numerze id: " + m.getIdm());
                        }
                    }
                } else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("wybierz_osobe")) {
                if(parts.length==2) {
                    for (int i = 0; i < m.Persons.size(); i++) {
                        if (parts[1].equals(m.Persons.get(i).pesel)) {
                            person = m.Persons.get(i);
                            System.out.println("Wybrales osobe o numerze PESEL: " + person.pesel);
                        }
                    }
                }else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("pokaz_osobe")) {
                if(parts.length==1) {
                    System.out.println("Dane osoby(imie, nazwisko, pesel, data urodzenia, miejsce zamieszkania, data wynajmu):  ");
                    System.out.print(person + " ");
                    try {
                        person.showPerson();
                    } catch (NeverRentException e) {
                        System.out.print(e.getMessage());
                    }
                    System.out.println();
                    System.out.println("Id wynajetych pomieszczen: ");
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if (m.Rooms.get(i).rented.equals(person))
                            System.out.print(m.Rooms.get(i).getIdp() + ", ");
                    }
                    System.out.println();
                }else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("wybierz_pomieszczenie")) {
                if(parts.length==2) {
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if ((parts[1].equals(m.Rooms.get(i).SgetIdp()) && m.Rooms.get(i).rented.equals(person))) {
                            room = m.Rooms.get(i);
                            System.out.println("Wybrales pomieszczenie o numerze id: " + m.Rooms.get(i).getIdp());
                        }
                    }
                } else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("pokaz_pomieszczenie")) {
                if(parts.length==1) {
                    System.out.println("Zawartosc pomieszczenia: ");
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if (m.Rooms.get(i).equals(room)) {
                            m.Rooms.get(i).show();
                        }
                    }
                } else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("dodaj_przedmiot")) {
                if(parts.length==3) {
                    Double d = Double.valueOf(parts[2]);
                    Stuff pom = new Stuff(parts[1], d);
                    try {
                        for (int i = 0; i < m.Rooms.size(); i++) {
                            if (m.Rooms.get(i).equals(room)) {
                                m.Rooms.get(i).Add(pom);
                                System.out.println("Dodales przedmiot");
                                Collections.sort(m.Rooms.get(i).a1);
                            }
                        }
                    } catch (TooManyThingsException e) {
                        System.out.println(e.getMessage());
                    }
                } else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("dodaj_samochod") || parts[0].equals("dodaj_motocykl") || parts[0].equals("dodaj_rower")) {
                if(parts.length==4) {
                    Double d = Double.valueOf(parts[2]);
                    int z = 0;
                    if (parts[0].equals("dodaj_samochod") && (parts[3].equals("benzyna") || parts[3].equals("gaz") || parts[3].equals("diesel"))) {
                        z++;
                    } else if (parts[0].equals("dodaj_motocykl") && (parts[3].equals("homologacja_tak") || parts[3].equals("homologacja_nie"))) {
                        z++;
                    } else if (parts[0].equals("dodaj_rower")) {
                        Integer d3 = Integer.valueOf(parts[3]);
                        if (d3 > 0 && d3 < 100 )
                            z++;
                        else System.out.println("Podales zla ceche pojazdu, sprobuj ponownie");
                    } else System.out.println("Podales zla ceche pojazdu, sprobuj ponownie");
                    if (z == 1) {
                        Vehicle pom1 = new Vehicle(parts[1], d, parts[3]);
                        try {
                            for (int i = 0; i < m.Rooms.size(); i++) {
                                if (m.Rooms.get(i).equals(room)) {
                                    m.Rooms.get(i).Add(pom1);
                                    System.out.println("Dodales pojazd");
                                    Collections.sort(m.Rooms.get(i).a2);
                                }
                            }
                        } catch (TooManyThingsException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }

            if (parts[0].equals("usun_przedmiot")) {
                if(parts.length==3) {
                    Double d1 = Double.valueOf(parts[2]);
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if (m.Rooms.get(i).equals(room)) {
                            for (int j = 0; j < m.Rooms.get(i).a1.size(); j++) {
                                {
                                    if (m.Rooms.get(i).a1.get(j).name.equals(parts[1]) && m.Rooms.get(i).a1.get(j).size == d1) {
                                        m.Rooms.get(i).a1.remove(j);
                                        m.Rooms.get(i).deleteSize(d1);
                                        System.out.println("Usunales przedmiot");
                                        Collections.sort(m.Rooms.get(i).a1);
                                    }
                                }
                            }
                        }
                    }
                } else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("usun_pojazd")) {
                if(parts.length==4) {
                    Double d1 = Double.valueOf(parts[2]);
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if (m.Rooms.get(i).equals(room)) {
                            for (int j = 0; j < m.Rooms.get(i).a2.size(); j++) {
                                if (m.Rooms.get(i).a2.get(j).name.equals(parts[1]) && m.Rooms.get(i).a2.get(j).size == d1 && m.Rooms.get(i).a2.get(j).feature.equals(parts[3])) {
                                    m.Rooms.get(i).deleteSize(d1);
                                    System.out.println("Usunales pojazd");
                                    m.Rooms.get(i).a2.remove(j);
                                }
                            }
                        }
                    }
                }else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("pokaz_wolne_pomieszczenia")) {
                if(parts.length==1) {
                    System.out.println("Wolne pomieszczenia(id, rozmiar): ");
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if (m.Rooms.get(i).rented.pesel == null) {
                            System.out.println("Id " + m.Rooms.get(i).getIdp() + " Rozmiar " + m.Rooms.get(i).getSize());
                        }

                    }
                }else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("wynajmij_pomieszczenie")) {
                if(parts.length==2) {
                    for (int i = 0; i < m.Rooms.size(); i++) {
                        if (m.Rooms.get(i).SgetIdp().equals(parts[1]) && m.Rooms.get(i).rented.pesel == null) {
                            m.Rooms.get(i).rented = person;
                            System.out.println("Wynajales pomieszczenie o numerze id: " + m.Rooms.get(i).getIdp());
                            m.Rooms.get(i).rented.rentDate = LocalDate.now();
                        }
                    }
                }else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
            if (parts[0].equals("zapisz")) {
                if (parts.length == 1) {
                    System.out.println("Zapisales do pliku");
                    m.saveFile();
                }else System.out.println("Niepoprawnie wprowadziles polecenie, sprobuj ponownie");
            }
        }
            while (name.equals("exit") == false) ;
            System.out.println("Do zobaczenia :)");

    }
}
