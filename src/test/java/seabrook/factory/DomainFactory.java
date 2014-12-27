package seabrook.factory;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class DomainFactory {

    public static Interval nextXMinutes(Integer x) {
        DateTime now = new DateTime();
        DateTime then = new DateTime().plusMinutes(x);

        return new Interval(now, then);
    }

    public static Interval nextXSeconds(Integer x){
        DateTime now = new DateTime();
        DateTime then = new DateTime().plusSeconds(x);

        return new Interval(now, then);
    }
}
