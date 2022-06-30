import java.util.ArrayList;
import java.util.List;

public class Room implements Comparable<Room>{
    String name;
    public static int  id = 0;
    public int idp;
    public double size;
    public Person rented=new Person();
    List<Stuff> a1 = new ArrayList<>();
    List<Vehicle> a2 = new ArrayList<>();
    public Room(double size){
        this.size=size;
        id++;
        this.idp=id;
    }
        double getSize(){
            return this.size;
        }
        int getIdp(){
        return idp;
    }
    String SgetIdp(){
        return idp + "";
    }
    public void Add (Stuff p) throws TooManyThingsException{
        if((this.size-p.size)>=0){
            this.size=this.size-p.size;
            a1.add(p);
        }
        else throw new TooManyThingsException();
    }
    public void Add (Vehicle p) throws TooManyThingsException{
        if((this.size-p.size)>=0){
            this.size=this.size-p.size;
            a2.add(p);
        }
        else throw new TooManyThingsException();
    }
    public void deleteSize (double size){
        this.size=this.size+size;
        }
    public void show(){
        for(int i=0; i<a1.size(); i++)
            System.out.println(a1.get(i));
        for(int i=0; i<a2.size(); i++)
            System.out.println(a2.get(i));
    }
    public void rent(Person o){
        this.rented=o;
    }
    public String toString (){
        return this.idp + " " + this.size;
    }


    @Override
    public int compareTo(Room o) {
        int result = (int)(this.size-o.size);
        return result;
    }
}
