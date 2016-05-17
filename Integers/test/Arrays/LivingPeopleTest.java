package Arrays;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohith Shivakumar on 4/20/2016.
 */
public class LivingPeopleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLivingPeople() throws Exception {
        List<Person> persons = new ArrayList<Person>();
        Person p = new Person(1901,1910);
        persons.add(p);
        p = new Person(1908,1930);
        persons.add(p);
        p = new Person(1990,2000);
        persons.add(p);
        p = new Person(1985,1990);
        persons.add(p);
        p = new Person(1941,1980);
        persons.add(p);

        LivingPeople l = new LivingPeople();
        l.addPeople(persons);

        int yrWithMostPeopleAlive = l.getYearWithMostPeopleAlive();
        Assert.assertEquals("Highest number of people lived in 1908",1908,yrWithMostPeopleAlive);
    }


    @Test
    public void testLivingPeople1() throws Exception {
        List<Person> persons = new ArrayList<Person>();

        LivingPeople l = new LivingPeople();
        l.addPeople(persons);

        int yrWithMostPeopleAlive = l.getYearWithMostPeopleAlive();
        Assert.assertEquals("Zero population ever scenario",1900,yrWithMostPeopleAlive);
    }

    @Test
    public void testLivingPeople2() throws Exception {
        List<Person> persons = new ArrayList<Person>();
        Person p = new Person(1911,1911);
        persons.add(p);

        LivingPeople l = new LivingPeople();
        l.addPeople(persons);

        int yrWithMostPeopleAlive = l.getYearWithMostPeopleAlive();
        Assert.assertEquals("born and dead in same year",1911,yrWithMostPeopleAlive);
    }
}
