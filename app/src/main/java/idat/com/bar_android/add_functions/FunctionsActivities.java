package idat.com.bar_android.add_functions;

import java.text.DecimalFormat;

public class FunctionsActivities {

    public static Double roundNumber(Double number){
        DecimalFormat df = new DecimalFormat("###.##");
       return Double.valueOf(df.format(number));
    }

}
