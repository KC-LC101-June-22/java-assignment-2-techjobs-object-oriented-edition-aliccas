package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.Location;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //verify that the ID's of the two objects are distinct
    @Test
    public void testSettingJobId() {
        Job testingJob1 = new Job();
        Job testingJob2 = new Job();

        assertNotEquals(testingJob1.getId(), testingJob2.getId());
    }
    //test that the constructor correctly assigns both the class and value of each field.
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testingJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testingJob3.getId() == testingJob3.getId());
        assertTrue(testingJob3.getName() instanceof String);
        assertTrue(testingJob3.getEmployer() instanceof Employer);
        assertTrue(testingJob3.getLocation() instanceof Location);
        assertTrue(testingJob3.getPositionType() instanceof PositionType);
        assertTrue(testingJob3.getCoreCompetency() instanceof CoreCompetency);

        //assertEquals(testingJob1.getId(), testingJob1.getId());
        assertEquals("Product tester", testingJob3.getName());
        assertEquals("ACME", testingJob3.getEmployer().toString());
        assertEquals("Desert", testingJob3.getLocation().toString());
        assertEquals("Quality control", testingJob3.getPositionType().toString());
        assertEquals("Persistence", testingJob3.getCoreCompetency().toString());
    }

    //Test the equals Method to see if they have the same id value.
    // True if they do, false if they do not so test to see if false.
    // Use different jobs since they should have different id's even if all other info is the same.
    @Test
    public void testJobsForEquality() {
        Job testingJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testingJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testingJob4.getId() == testingJob5.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testingJob6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        char testChar1 = testingJob6.toString().charAt(0);
        char testChar2 = testingJob6.toString().charAt(testingJob6.toString().length() -1);
        assertEquals(testChar1, '\n');
        assertEquals(testChar2, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testingJob7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String testingString = testingJob7.toString();
        assertEquals( "\nID: 4\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n", testingString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testingJob8 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String testingString2 = testingJob8.toString();

        assertEquals( "\nID: 3\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Persistence\n", testingString2);


    }
}
