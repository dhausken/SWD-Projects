import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
/**
 * @author David Hausken
 * @version 1.0
 * @since 1.0
 *
 * Tests the Easter class from years 2000 to 2020.
 * Dates obtained from https://www.census.gov/srd/www/genhol/easter500.html
 */
public class ComputusTest
{
    @Test
    public void testComputus() throws Exception
    {
        Easter e[]  = new Easter[21];
        for(int i = 0; i != 21; i++)
        {
             e[i] = new Easter(i+2000);
        }
        Assert.assertThat(e[0].numToMonth(e[0].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[0].getDay()), CoreMatchers.is(23));

        Assert.assertThat(e[1].numToMonth(e[1].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[1].getDay()), CoreMatchers.is(15));

        Assert.assertThat(e[2].numToMonth(e[2].getMonth()), CoreMatchers.is("March"));
        Assert.assertThat((e[2].getDay()), CoreMatchers.is(31));

        Assert.assertThat(e[3].numToMonth(e[3].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[3].getDay()), CoreMatchers.is(20));

        Assert.assertThat(e[4].numToMonth(e[4].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[4].getDay()), CoreMatchers.is(11));

        Assert.assertThat(e[5].numToMonth(e[5].getMonth()), CoreMatchers.is("March"));
        Assert.assertThat((e[5].getDay()), CoreMatchers.is(27));

        Assert.assertThat(e[6].numToMonth(e[6].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[6].getDay()), CoreMatchers.is(16));

        Assert.assertThat(e[7].numToMonth(e[7].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[7].getDay()), CoreMatchers.is(8));

        Assert.assertThat(e[8].numToMonth(e[8].getMonth()), CoreMatchers.is("March"));
        Assert.assertThat((e[8].getDay()), CoreMatchers.is(23));

        Assert.assertThat(e[9].numToMonth(e[9].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[9].getDay()), CoreMatchers.is(12));

        Assert.assertThat(e[10].numToMonth(e[10].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[10].getDay()), CoreMatchers.is(4));

        Assert.assertThat(e[11].numToMonth(e[11].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[11].getDay()), CoreMatchers.is(24));

        Assert.assertThat(e[12].numToMonth(e[12].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[12].getDay()), CoreMatchers.is(8));

        Assert.assertThat(e[13].numToMonth(e[13].getMonth()), CoreMatchers.is("March"));
        Assert.assertThat((e[13].getDay()), CoreMatchers.is(31));

        Assert.assertThat(e[14].numToMonth(e[14].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[14].getDay()), CoreMatchers.is(20));

        Assert.assertThat(e[15].numToMonth(e[15].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[15].getDay()), CoreMatchers.is(5));

        Assert.assertThat(e[16].numToMonth(e[16].getMonth()), CoreMatchers.is("March"));
        Assert.assertThat((e[16].getDay()), CoreMatchers.is(27));

        Assert.assertThat(e[17].numToMonth(e[17].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[17].getDay()), CoreMatchers.is(16));

        Assert.assertThat(e[18].numToMonth(e[18].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[18].getDay()), CoreMatchers.is(1));

        Assert.assertThat(e[19].numToMonth(e[19].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[19].getDay()), CoreMatchers.is(21));

        Assert.assertThat(e[20].numToMonth(e[20].getMonth()), CoreMatchers.is("April"));
        Assert.assertThat((e[20].getDay()), CoreMatchers.is(12));
    }
}
