package com.example.exam_md2.sevice;

import com.example.exam_md2.File.File;
import com.example.exam_md2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IManager<Student> {
    List<Student> studentList;
    public StudentManager() {
        studentList = new ArrayList<>();
    }


    public List<Student> getStudentList() {
        return studentList = File.readFromFile("D:\\CodeGym_MD3\\Exam_MD2\\src\\main\\java\\com\\example\\exam_md2\\File\\student.csv");
    }




    @Override
    public void add(Student student) {
        studentList.add(student);
        File.writeToFile("D:\\CodeGym_MD3\\Exam_MD2\\src\\main\\java\\com\\example\\exam_md2\\File\\student.csv", getStudentList());
    }


    @Override
    public void edit(int n, Student student) {
        int index = -1;
        for (int i = 0; i < this.studentList.size(); i++) {
            if (this.studentList.get(i).getId() == n) {
                index = i;
            }
        }
        studentList.set(index, student);

    }

    @Override
    public void delete(int n) {
        for (Student p : studentList) {
            if (p.getId() == n) {
                studentList.remove(p);
                break;
            }
        }
    }

    @Override
    public Student search(int n) {
        for (Student p : studentList) {
            if (p.getId() == n) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Student> showAll() {

        return null;
    }
}
