public class Vehicle extends Stuff {
    public String feature;
    public Vehicle(String name, double size, String feature){
        super(name,size);
        this.feature=feature;
    }
    public String toString(){
        return this.name + " " + this.size + " " + this.feature;
    }
}
