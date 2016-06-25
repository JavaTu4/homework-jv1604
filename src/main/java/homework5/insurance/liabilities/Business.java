package homework5.insurance.liabilities;

/**
 * Created by root.
 */
public class Business extends Liability {
    public Business (){
        super("Бизнес",Liability.risks[random(0,Liability.risks.length - 1)],random(1000,5000),random(100000,1000000));
    }
}
