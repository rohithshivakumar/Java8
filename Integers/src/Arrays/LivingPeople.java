package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rohith Shivakumar on 4/17/2016.
 * Given a list of people with their birth and death years, implement a method to compute the year with the most
 * number of people alive. You may assume that all people were born between 1900 and 2000(inclusive).
 * If a person was alive during any portion of that year, they should be included in that year's count. For example,
 * Person (birth = 1908, death = 1909) is included in the counts for both 1908 and 1909
 */

public class LivingPeople {
    private List<Person> people = new ArrayList<Person>();

    public void addPeople(List<Person> people) {
        this.people = people;
    }

    /**
     * This method returns the year with most people alive.
     * If there are many years during which most people are alive, return the first year that the most people are alive
     * @return
     * @throws Exception
     */
    public int getYearWithMostPeopleAlive() throws Exception {
        final int MIN_RANGE = 1900;
        final int MAX_RANGE = 2000;

        int yearWithMostPeopleAlive = 0;
        int mostPeopleAlive = 0;
        List<Integer> yearlyPeopleAliveCounter = new ArrayList<Integer>();
        int birthYr;
        int deathYr;
        String msg = null;
        Integer zero = new Integer(0);

        try {
            //Initialize to zero as initially we have seen no people
            for(int i = 0; i <= (MAX_RANGE - MIN_RANGE); i++) {
                yearlyPeopleAliveCounter.add(i, zero);
            }

            //Populate Yearly people alive counter
            for(Person p : people) {
                deathYr = 0;
                if(0 != p.getBirthYear()) {
                    birthYr = p.getBirthYear();

                    if(0 != p.getDeathYear()) {
                        deathYr = p.getDeathYear();
                    }

                    int birthYrIndex = birthYr % MIN_RANGE;
                    int deathYrIndex = deathYr % MIN_RANGE;
                    for(int i = birthYrIndex; i <= deathYrIndex; i++){
                        yearlyPeopleAliveCounter.set(i,yearlyPeopleAliveCounter.get(i).intValue() + 1);
                    }
                }
            }

            //Find the year
            for(int i = 0; i < yearlyPeopleAliveCounter.size(); i++) {
                if(mostPeopleAlive < yearlyPeopleAliveCounter.get(i)) {
                    yearWithMostPeopleAlive = i;
                    mostPeopleAlive = yearlyPeopleAliveCounter.get(i);
                }
            }
        }
        catch (Exception e) {
            msg = "Exception occured while determining year with most people alive.";
            System.err.println(msg + ". " + e.getMessage());
            throw new Exception(msg,e);
        }
        return (MIN_RANGE + yearWithMostPeopleAlive);
    }
}
