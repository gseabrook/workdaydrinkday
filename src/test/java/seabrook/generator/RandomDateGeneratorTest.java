package seabrook.generator;

import org.joda.time.Instant;
import org.joda.time.Interval;
import org.junit.Test;

import static seabrook.assertions.WorkDayDrinkDayAssertions.assertThat;
import static seabrook.factory.DomainFactory.nextXMinutes;

public class RandomDateGeneratorTest {

    @Test
    public void generateRandomDate(){
        // Given
        Interval interval = nextXMinutes(5);

        // When
        Instant instant = new RandomDateGenerator().generateInstant(interval);

        // Then
        assertThat(instant)
                .isWithinInterval(interval);
    }

}