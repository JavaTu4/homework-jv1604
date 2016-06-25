package homework5.mobileConnection.tariffs;

/**
 * Created by root.
 */
public class City extends Tariff{
    public City (){
        super("Городской",random(10000,100000),100,Tariff.minutes[random(0,(minutes.length - 1))],0);
    }
}
