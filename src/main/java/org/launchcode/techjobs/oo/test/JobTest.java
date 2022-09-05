package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    String name = "Product tester";
    String emp = "ACME";
    String loc = "Desert";
    String pos = "Quality control";
    String core = "Persistence";
    @Before
    public void createCommonTestObjects() {

    }

    @Test
    public void emptyTest () {
        assertEquals(1,1,.001);
    }

    @Test
    public void testSettingJobId() {
        Job test1 = new Job();
        Job test2 = new Job();
        assertNotEquals(test1.getId(),test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
//        String name = "Product tester";
//        String emp = "ACME";
//        String loc = "Desert";
//        String pos = "Quality control";
//        String core = "Persistence";

        Job testJob = new Job(name, new Employer(emp), new Location(loc), new PositionType(
                pos), new CoreCompetency(core));

        assertTrue(testJob instanceof Job);
        assertEquals(testJob.getName(),name);

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().getValue(),emp);

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().getValue(),loc);

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().getValue(),pos);

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().getValue(),core);
    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job(name, new Employer(emp), new Location(loc), new PositionType(
                pos), new CoreCompetency(core));
        Job test2 = new Job(name, new Employer(emp), new Location(loc), new PositionType(
                pos), new CoreCompetency(core));
        assertFalse(test1.equals(test2));
    }
}
