<<<<<<< HEAD
import static org.junit.Assert.assertEquals;

=======
>>>>>>> 128d6ea2c77165465ab91a4c9a1653c979e3ccfa
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

<<<<<<< HEAD
import org.apache.commons.lang.math.NumberUtils;
=======
>>>>>>> 128d6ea2c77165465ab91a4c9a1653c979e3ccfa
import org.junit.Before;
import org.junit.Test;

public class BigDecimalTest {

    private List<BigDecimal> bigDecimalList;

    private List<String> stringList;

<<<<<<< HEAD
    private String valueOne = "1.000,5";
=======
    private String valueOne = "5,700";
>>>>>>> 128d6ea2c77165465ab91a4c9a1653c979e3ccfa

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
<<<<<<< HEAD
            assertEquals(stringList.get(i), bigDecimalList.get(i).toString());
=======
            System.out.println(bigDecimalList.get(i));
>>>>>>> 128d6ea2c77165465ab91a4c9a1653c979e3ccfa
        }
    }

    private void prepareForScale() throws ParseException {
        for (int i = 0; i < stringList.size(); i++) {
<<<<<<< HEAD
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
=======
            DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(Locale.GERMAN);

            df.setParseBigDecimal(true);
            String value = stringList.get(i);
            BigDecimal bd = (BigDecimal) df.parseObject(value);
            bigDecimalList.add(bd.setScale(2));
>>>>>>> 128d6ea2c77165465ab91a4c9a1653c979e3ccfa
        }
    }
}
