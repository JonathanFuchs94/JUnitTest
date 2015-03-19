import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class BigDecimalTest {

    private List<BigDecimal> bigDecimalList;

    private List<String> stringList;

    private String valueOne = "5,700";

    private String valueTwo = "10,60";

    private String valueThree = "5,06";

    @Before
    public void setup() {
        bigDecimalList = new ArrayList<>();
        stringList = new ArrayList<String>();
        stringList.add(valueOne);
        stringList.add(valueTwo);
        stringList.add(valueThree);
    }

    @Test
    public void testScale() throws ParseException {
        prepareForScale();
        Collections.sort(bigDecimalList);
        for (int i = 0; i < bigDecimalList.size(); i++) {
            System.out.println(bigDecimalList.get(i));
        }
    }

    private void prepareForScale() throws ParseException {
        for (int i = 0; i < stringList.size(); i++) {
            DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);

            df.setParseBigDecimal(true);
            String value = stringList.get(i);
            BigDecimal bd = (BigDecimal) df.parseObject(value);
            bigDecimalList.add(bd.setScale(2));
        }
    }
}
