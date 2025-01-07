package br.com.testesUnitarios.service.staticwithparams;

public class MyUtils {

    public static String getWelcomeMessage(String username, boolean isCostumer){
        if(isCostumer){
            return "Dear " + username;
        }

        return "Hello " + username;
    }
}
