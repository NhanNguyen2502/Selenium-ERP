package erp.common.helpers;

import net.datafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.python.antlr.ast.Str;

import java.util.Locale;

public class FakeDataHelper {
    private static final String _locate = PropertiesHelper.getValue("LOCATE");
    private static String _currentLocal = "Null";
    private static Faker faker;


    public static Faker createFaker() {
        faker = new Faker(new Locale(_locate));
        return faker;
    }

    public static Faker createFakeByLocate(String locate) {

        faker = new Faker(new Locale(locate));
        _currentLocal = locate;
        return faker;
    }

    public static Faker getFakedata() {
        if (faker == null || !_locate.equals(_currentLocal)) {
            createFaker();        }
        return faker;
    }

    public static void setFake(Faker faker) {
        FakeDataHelper.faker = faker;
    }
}
