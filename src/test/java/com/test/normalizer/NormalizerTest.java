package com.test.normalizer;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NormalizerTest {

    @Test
    public void testNormalizeJavaEngineer() {
        Normalizer n = new Normalizer();
        String result = n.normalize("Java Engineer");
        assertEquals("Software Engineer", result);
    }

    @Test
    public void testNormalizeAccountant() {
        Normalizer n = new Normalizer();
        String result = n.normalize("Chief Accountant");
        assertEquals("Accountant", result);
    }

    @Test
    public void testNormalizeMechanical() {
        Normalizer n = new Normalizer();
        String result = n.normalize("Mechanical");
        assertEquals("Mechanical", result);
    }

    @Test
    public void testCalculateSimilarity() {
        double similarity = Normalizer.calculateSimilarity("java", "Java developer");
        assertEquals(1.0, similarity, 0.001);
    }


}
