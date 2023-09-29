package org.example;

import java.io.FileReader;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.stream.Collectors;

public class JsonSortSample {

    public JsonSortSample() {
    }

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("12321");

        try{
            String filePath = "C:\\Class\\algorithm-exercises\\src\\main\\java\\org\\example\\q4-sort.json";

            Q4Main q4Main = objectMapper.readValue(new File(filePath), Q4Main.class);
            System.out.println("q4Main. size + "+q4Main.getItems().size());
            List<Q4Sub> q4Subs=q4Main.getItems();

            List<Q4Sub> q4Subs2=q4Main.getItems()
                    .stream()
                    .sorted(Comparator.comparingInt(Q4Sub::getPrice).reversed())
                    .collect(Collectors.toList());

            for(Q4Sub q4sub : q4Subs2){
                System.out.println("q4Sub price"+q4sub.getPrice());
            }

        } catch (Exception e){

            System.out.println(e.getMessage());
        }


    }

}
