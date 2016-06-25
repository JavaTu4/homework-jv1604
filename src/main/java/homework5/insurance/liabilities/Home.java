package homework5.insurance.liabilities;

/**
 * Created by root.
 */
public class Home extends Liability{
    public Home(){
        super("Жилье",Liability.risks[random(0,Liability.risks.length - 1)],random(200,1000),random(10000,100000));
    }
}
