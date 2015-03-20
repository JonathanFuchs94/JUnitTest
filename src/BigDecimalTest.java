import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.math.NumberUtils;
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
        stringList.add(valueThree);
        stringList.add(valueOne);
        stringList.add(valueTwo);
    }

    @Test
    public void testScale() throws ParseException {
        prepareForScale();
        Collections.sort(bigDecimalList);
        for (int i = 0; i < bigDecimalList.size(); i++) {
            System.out.println(bigDecimalList.get(i));
            assertEquals(stringList.get(i).substring(5), bigDecimalList.get(i).toString().replace(".", ","));
        }
    }

    private void prepareForScale() throws ParseException {
        for (int i = 0; i < stringList.size(); i++) {
            String value = stringList.get(i);
            String tempValue = value.replace(",", "");
            tempValue = tempValue.replace(".", "");
            if (NumberUtils.isNumber(tempValue)) {
                DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMANY);
                df.setParseBigDecimal(true);
                BigDecimal bd = (BigDecimal) df.parseObject(value);
                bigDecimalList.add(bd.setScale(2));
            } else {
                System.out.println("Die Zahl {" + value + "} ist kein BigDecimal ");
                break;
            }
        }
    }
}
