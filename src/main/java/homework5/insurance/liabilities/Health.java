package homework5.insurance.liabilities;

/**
 * Created by root.
 */
public class Health extends Liability {
    public Health (){
        super("Здоровье",Liability.risks[random(0,Liability.risks.length - 1)],random(500,2000),random(15000,150000));
    }
}
