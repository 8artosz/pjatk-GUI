public class Stuff implements Comparable<Stuff> {
    public String name;
    public double size;
    public Stuff(String name, double size){
        this.name=name;
        this.size=size;
    }
    public String toString (){
        return this.name + " " + this.size;
    }

    @Override
    public int compareTo(Stuff o) {
        int result = (int)(o.size-this.size);
        if(result==0){
            result=o.name.compareTo(this.name);
            return result;
        }
        return result;

    }
}
