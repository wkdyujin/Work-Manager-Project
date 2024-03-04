package com.fisa.workmanager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReadCsvTest {

	private String filePath;
    private BufferedReader bufferedReader;
    private List<String[]> readCSV;

    private int index;

    //This constructor is for read CSV File
    @Test
    public void GoCSV() throws IOException {
//    	String filePath = "src\\main\\resources\\static\\estimation.csv";
//        this.filePath = filePath;
//        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.filePath), "UTF-8"));
//        readCSV = new ArrayList<>();
//
//        makeList(bufferedReader);
//        this.index = 0;
//        
//        String[] line=null;
//        while((line = nextRead())!=null){
//            for(String a : line){
//                System.out.print(a +" ");
//            }
//            System.out.println();
//        }
    }

    public void makeList(BufferedReader bufferedReader) throws IOException {
        String line = null;
        while((line = bufferedReader.readLine())!=null) {
            String[] lineContents = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",-1);

            readCSV.add(lineContents);
        }
    }

    //한 행을 읽음
    public String[] nextRead(){
        if(readCSV.size() == index){
            return null;
        }
        return readCSV.get(index++);
    }
}
