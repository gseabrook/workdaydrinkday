package seabrook.generator;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.springframework.stereotype.Component;

@Component
public class RandomDateGenerator {

    public Instant generateInstant(Interval interval) {
        Long startMillis = interval.getStartMillis();
        Long endMillis = interval.getEndMillis();

        long time = new RandomDataGenerator().nextLong(startMillis, endMillis);
        return new Instant(time);
    }

}
