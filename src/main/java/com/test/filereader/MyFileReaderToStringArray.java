package com.test.filereader;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class MyFileReaderToStringArray {

    public static final String NORMALIZED_JOB_TITLES_TXT = "./normalized_job_titles.txt";

    public static String[] readMyNormalizedJobTitles(){
        String[] arrString = null;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NORMALIZED_JOB_TITLES_TXT))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                lines.add(linha);
            }
            arrString = lines.toArray(new String[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrString;
    }

    public static void main(String[] args) {
        readMyNormalizedJobTitles();
    }
}
