package homework5.mobileConnection.tariffs;

/**
 * Created by root.
 */
public class Intercity extends Tariff {
    public Intercity (){
        super("Междугородний",random(10000,100000),150,0,Tariff.minutes[random(0,(minutes.length - 1))]);
    }
}
