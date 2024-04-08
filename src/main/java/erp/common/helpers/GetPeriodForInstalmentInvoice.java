package erp.common.helpers;

import org.python.antlr.ast.Str;

public class GetPeriodForInstalmentInvoice {
    private static String _wekkly = "$.installmentInvoice.select.option.weekly";
    private static String _monthly = "$.installmentInvoice.select.option.monthly";
    private static String _quarterly = "$.installmentInvoice.select.option.quarterly";
    private static String _yearly = "$.installmentInvoice.select.option.yearly";
    private static String _custom = "$.installmentInvoice.select.option.custom";

    public static String getWekkly(String language) {
        return TranslationHelpers.setFile(language, _wekkly);
    }

    public static String getMonthly(String language) {
        return TranslationHelpers.setFile(language, _monthly);
    }

    public static String getYearly(String language) {
        return TranslationHelpers.setFile(language, _yearly);
    }

    public static String getQuarterly(String language) {
        return TranslationHelpers.setFile(language, _quarterly);
    }

    public static String getCustom(String language) {
        return TranslationHelpers.setFile(language, _custom);
    }
}
