package model;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Chao on 2017/3/23.
 */
public class RecordTest {
    @Test
    public void defaultConstructorTest(){
        Record record = new Record();
        Assert.assertNull(record.getLastName());
        Assert.assertNull(record.getFirstName());
        Assert.assertNull(record.getGender());
        Assert.assertNull(record.getDateOfBirth());
        Assert.assertNull(record.getFavoriteColor());
    }
    @Test
    public void setLastNameTest() {
        Record record = new Record("Obama", "Barack", Gender.Male, "Red", new Date());
        Assert.assertTrue(record.getLastName().equals("Obama"));
        record.setLastName("Amabo");
        Assert.assertTrue(record.getLastName().equals("Amabo"));
    }
    @Test
    public void setFirstNameTest() {
        Record record = new Record("Obama", "Barack", Gender.Male, "Red", new Date());
        Assert.assertTrue(record.getFirstName().equals("Barack"));
        record.setFirstName("JFK");
        Assert.assertTrue(record.getFirstName().equals("JFK"));
    }
    @Test
    public void setGenderTest() {
        Record record = new Record("Obama", "Barack", Gender.Male, "Red", new Date());
        Assert.assertTrue(record.getGender() == Gender.Male);
        record.setGender(Gender.Female);
        Assert.assertTrue(record.getGender() == Gender.Female);
    }
    @Test
    public void setFavoriteColorTest() {
        Record record = new Record("Obama", "Barack", Gender.Male, "Red", new Date());
        Assert.assertTrue(record.getFavoriteColor().equals("Red"));
        record.setFavoriteColor("Blue");
        Assert.assertTrue(record.getFavoriteColor().equals("Blue"));
    }
    @Test
    public void setDateOfBirthTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "31-08-1982";
        Date date = sdf.parse(dateInString);
        Record record = new Record("Obama", "Barack", Gender.Male, "Red", date);
        record.setDateOfBirth(sdf.parse("01-01-1990"));
        Assert.assertTrue(record.getDateOfBirth().equals(sdf.parse("01-01-1990")));
    }
}
