package erp.common.helpers;

public class GetKeyOfSaleTypeByLanguageHelpers {

    public static  String getStandard(String language)
    {
        return  TranslationHelpers.setFile(language,"$.regularInvoice.select.option.standard");
    }

    public static  String getInstallment(String language)
    {
        return  TranslationHelpers.setFile(language,"$.regularInvoice.select.option.installment");
    }

    public static  String getCashSale(String language)
    {
        return  TranslationHelpers.setFile(language,"$.regularInvoice.select.option.cashSale");
    }

}
