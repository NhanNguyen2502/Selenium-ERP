package erp.common.helpers;

public class Helper {

    public  static String  getcurrentDir(){
        String current =  System.getProperty("user.dir") + "/";
        return  current;
    }
}
