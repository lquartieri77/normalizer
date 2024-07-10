package com.test.filereader;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyFileReaderToStringArrayTest {

    @Test
    public void testReadMyNormalizedJobTitles() {
        String[] titles = MyFileReaderToStringArray.readMyNormalizedJobTitles();
        assertNotNull("Array should not be null", titles);
        assertTrue("Array should contain some titles", titles.length > 0);
    }

    @Test
    public void testFileExists() {
        assertNotNull("File should exist", MyFileReaderToStringArray.NORMALIZED_JOB_TITLES_TXT);
    }
}
