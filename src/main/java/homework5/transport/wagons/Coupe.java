package homework5.transport.wagons;

/**
 * Created by root.
 */
public class Coupe extends Wagon {
    public Coupe (){
        super(Wagon.types[1],36,random(100,2000),2);
    }
}
