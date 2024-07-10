package com.test.domain;

/**
 * Class with a structure for storage in our comparison flow.
 */
public class WordData {

    private String originalString;
    private java.lang.Double quality;

    private String comparateTo;

    public java.lang.Double getQuality() {
        return quality;
    }

    public void setQuality(java.lang.Double quality) {
        this.quality = quality;
    }

    public String getComparateTo() {
        return comparateTo;
    }

    public void setComparateTo(String comparateTo) {
        this.comparateTo = comparateTo;
    }

    public String getOriginalString() {
        return originalString;
    }

    public void setOriginalString(String originalString) {
        this.originalString = originalString;
    }
}
