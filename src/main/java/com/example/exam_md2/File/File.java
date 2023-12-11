package com.example.exam_md2.File;

import com.example.exam_md2.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {

    public static void writeToFile(String path, List<Student>studentList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "ID, Ten Hoc Sinh , Tuoi , Gioi Tinh, Đia Chi, Điem Trung Binh\n";
            for (Student s : studentList) {
                str += s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getSex() + "," + s.getAddress() +"," + s.getScore()+ "\n";
            }
            bufferedWriter.write(str);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readFromFile(String path) {
        List<Student> list = new ArrayList<>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String contenn = bufferedReader.readLine();
            while (null != (contenn = bufferedReader.readLine())){
                String[] value = contenn.split(",");
                int id = Integer.parseInt(value[0]);
                String name = value[1];
                int age=Integer.parseInt(value[2]);
                String sex = value[3];
                String add = value[4];
                double score = Double.parseDouble(value[5]);
                list.add(new Student(id, name, age, sex, add,score));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
