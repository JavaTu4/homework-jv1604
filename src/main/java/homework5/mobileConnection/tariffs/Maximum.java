package homework5.mobileConnection.tariffs;

/**
 * Created by root.
 */
public class Maximum extends Tariff{
    public Maximum (){
        super("Максимум",random(10000,100000),200,Tariff.minutes[random(0,(minutes.length - 1))],
                Tariff.minutes[random(0,(minutes.length - 1))]);
    }
}
