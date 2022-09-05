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

    //toString tests
    Job testJob;
    String testStr;

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        testJob = new Job(name, new Employer(emp), new Location(loc), new PositionType(
                pos), new CoreCompetency(core));
        testStr = testJob.toString();
        assertEquals(testStr.charAt(0),'\n');
        assertEquals(testStr.charAt(testStr.length()-1),'\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        testJob = new Job(name, new Employer(emp), new Location(loc), new PositionType(
                pos), new CoreCompetency(core));
        testStr = testJob.toString();
        assertEquals("\nID: ",testStr.substring(0,4));
        assertTrue(testStr.contains("\nName: "));
        assertTrue(testStr.contains("\nEmployer: "));
        assertTrue(testStr.contains("\nLocation: "));
        assertTrue(testStr.contains("\nPosition Type: "));
        assertTrue(testStr.contains("\nCore Competency:"));

        assertTrue(testStr.contains(Integer.toString(testJob.getId())));
        assertTrue(testStr.contains(testJob.getName()));
        assertTrue(testStr.contains(testJob.getEmployer().getValue()));
        assertTrue(testStr.contains(testJob.getLocation().getValue()));
        assertTrue(testStr.contains(testJob.getPositionType().getValue()));
        assertTrue(testStr.contains(testJob.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        testJob = new Job(name, new Employer(emp), new Location(), new PositionType(
                ), new CoreCompetency());
        testStr = testJob.toString();
        System.out.println(testJob.toString());
        assertTrue(testStr.contains("Location: Data not available"));
        assertTrue(testStr.contains("Position Type: Data not available"));
        assertEquals(testStr.substring(testStr.indexOf("Core")),"Core Competency: Data not available\n");
    }

    @Test
    public void testToStringIdOnlyJobDoesNotExist() {
        Job testEmpty = new Job();
        assertTrue(testEmpty.toString().contains("\nOOPS! This job does not seem to exist.\n"));
    }
}
