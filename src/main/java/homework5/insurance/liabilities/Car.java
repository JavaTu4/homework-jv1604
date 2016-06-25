package homework5.insurance.liabilities;

/**
 * Created by root.
 */
public class Car extends Liability {
    public Car (){
        super("Автомобиль",Liability.risks[random(0,Liability.risks.length - 1)],random(100,1500),random(20000,200000));

    }
}
