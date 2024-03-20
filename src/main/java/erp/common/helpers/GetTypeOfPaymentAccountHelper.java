package erp.common.helpers;

import org.python.antlr.ast.Str;

public class GetTypeOfPaymentAccountHelper {
    private static String _cash = "$.accountType.select.option.cash";
    private static String _paymentService = "$.accountType.select.option.payment-service";
    private static String _bank = "$.accountType.select.option.bank";

    public static String getCashType(String language) {
        return TranslationHelpers.setFile(language, _cash);
    }

    public static String getBankType(String language) {
        return TranslationHelpers.setFile(language, _bank);
    }

    public static String getPaymentServiceType(String language) {
        return TranslationHelpers.setFile(language, _paymentService);
    }
}
