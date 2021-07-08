package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JobTests {
static Job job1, job2, job3, job4, job5;

    @BeforeAll
static void Job(){
    job1 = new Job("Steve", new Employer("Kristan"), new Location("Comcast"), new PositionType("Coder"),
            new CoreCompetency("Java"));
    job2 = new Job("Bruce", new Employer("Roshani"), new Location("Grow2Code"), new PositionType("engineer"),
            new CoreCompetency("Javascript"));
    job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    job5 = new Job("Brian", new Employer(""), new Location("RadioShack"), new PositionType("clerk"),
            new CoreCompetency("sales"));
    }

    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
        assertEquals(1,(job2.getId() - job1.getId()));
    }


    @Test
    public void testJobConstructorSetsAllFields() {
    assertTrue(job1.getId() !=0);
    assertTrue(job1.getName() !="");

    assertTrue(job1.getEmployer() instanceof Employer);
    assertTrue(job1.getLocation() instanceof Location);
    assertTrue(job1.getPositionType() instanceof PositionType);
    assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    assertTrue(job1 instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
    assertFalse(job3.equals(job4));
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        char firstChar = job5.toString().charAt(0);
        char lastChar = job5.toString().charAt(job5.toString().length()-1);
        assertTrue(firstChar == lastChar);
    }


    @Test
    public void testToStringHasLabelsForEachField() {
        String expected = String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: " +
                        "%s\nCore Competency: %s\n",  job1.getId(), job1.getName(), job1.getEmployer().getValue(),
                job1.getLocation().getValue(), job1.getPositionType().getValue(), job1.getCoreCompetency().getValue());
        String actual = job1.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void testToStringDataNotAvailable() {
        String expected = String.format("\nID: %d\nName: %s\nEmployer: Data Not Available\nLocation: %s\nPosition " +
                        "Type: " +
                        "%s\nCore Competency: %s\n",  job5.getId(), job5.getName(),
                job5.getLocation().getValue(), job5.getPositionType().getValue(), job5.getCoreCompetency().getValue());
        String actual = job5.toString();
        assertEquals(expected,actual);

    }
}


