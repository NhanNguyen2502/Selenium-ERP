package erp.common.helpers;

public class GetTypeOfCompanyHelper {

    public static String getTypeOfDemoCompany(String language) {
        return TranslationHelpers.setFile(language, "$.company.listPage.text.demo");
    }

    public static String getTypeOfRealCompany(String language) {
        return TranslationHelpers.setFile(language, "$.company.listPage.text.real");
    }
}
