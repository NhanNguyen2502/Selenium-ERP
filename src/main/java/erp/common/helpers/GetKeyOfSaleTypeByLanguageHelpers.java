package erp.common.helpers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetKeyOfSaleTypeByLanguageHelpers {
    private static String _standard = "$.regularInvoice.select.option.standard";
    private static String _installment = "$.regularInvoice.select.option.installment";
    private static String _cashSale = "$.regularInvoice.select.option.cashSale";

    public static  String getStandard(String language)
    {
        return  TranslationHelpers.setFile(language,_standard);
    }

    public static  String getInstallment(String language)
    {
        return  TranslationHelpers.setFile(language,_installment);
    }

    public static  String getCashSale(String language)
    {
        return  TranslationHelpers.setFile(language,_cashSale);
    }

    public static String getRandomSaleType(String language)
    {
        List<String> types = new ArrayList<>();
        types.add(_standard);
        types.add(_installment);
        types.add(_cashSale);
        Random ran = new Random();
        var random = ran.nextInt(types.size());
        System.out.println("Type random selected: "+TranslationHelpers.setFile(language,types.get(random)));
        return TranslationHelpers.setFile(language,types.get(random));
    }

}
