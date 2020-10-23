package com.nityainc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Sample output for the below program
Jan	1
Feb	4
Mar	4
Apr	6
May	4
Jun	4
Jul	1
Dec	2*/

/*Java program to count the no. of file in a specified folder path grouped by their created month*/
public class FolderScanner {

    public static void main(String[] args) {
        try {
            Stream<Path> files = Files.list(Paths.get("\\your\\local\\path"));
            Map<Integer, List<Path>> filesOfSameMon = files.collect(Collectors.groupingBy(file -> {
                        try {
                            BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
                            FileTime createdTime = attributes.creationTime();
                            String[] strings = String.valueOf(createdTime).split("-");
                            return (Integer.parseInt(strings[1]) - 1);
                        } catch (IOException e) {
                            return null;
                        }
                    }
            ));
            filesOfSameMon.forEach((month, pathsList) -> System.out.println(getMonth(month) + "\t" + pathsList.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMonth(int month) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return monthNames[month];
    }
}
