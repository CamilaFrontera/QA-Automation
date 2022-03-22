package DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="purchaseForm")
    public static Object [][] getData(){
        return new Object[][]{
                {"nameTest","countryTest","cityTest","ccTest","monthTest","yearTest"}
                };
    }

}
