package com.example.exam_md2.controller;

import com.example.exam_md2.File.File;
import com.example.exam_md2.model.Student;
import com.example.exam_md2.sevice.StudentManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "student", value = "/students")
public class StudentServlet extends HttpServlet {
    StudentManager studentManager=new StudentManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                showFormDelete(req, resp);
                break;
            default:
                showListStudent(req, resp);
        }
    }



    private void showFormDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentManager.delete(id);
        File.readFromFile("D:\\CodeGym_MD3\\Exam_MD2\\src\\main\\java\\com\\example\\exam_md2\\File\\student.csv");
        resp.sendRedirect("/students");
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/edit.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Student student =studentManager.search(id);
        req.setAttribute("sua",student);
        requestDispatcher.forward(req, resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/create.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/list.jsp");
        List<Student> list ;
        list= File.readFromFile("D:\\CodeGym_MD3\\Exam_MD2\\src\\main\\java\\com\\example\\exam_md2\\File\\student.csv");
        req.setAttribute("danhSach", list);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                Create(req, resp);
                break;
            case "edit":
                Edit(req, resp);
                break;
            case "seach":
                Seach(req,resp);
                break;

        }
    }

    private void Seach(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("student/list.jsp");
        List<Student> products=new ArrayList<>();
        String seach=req.getParameter("seach");
        for (int i = 0; i < studentManager.getStudentList().size(); i++) {
            if (studentManager.getStudentList().get(i).getName().contains(seach)){
                products.add(studentManager.getStudentList().get(i));
            }
        }
        req.setAttribute("danhSach",products);
        requestDispatcher.forward(req,resp);
    }

    private void Edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name =req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String address =req.getParameter("address");
        double score = Double.parseDouble(req.getParameter("score"));
        studentManager.edit(id,new Student(id,name,age,sex,address,score));
        resp.sendRedirect("/students");
    }

    private void Create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name =req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String address =req.getParameter("address");
        double score = Double.parseDouble(req.getParameter("score"));
        studentManager.add(new Student(id,name,age,sex,address,score));
        resp.sendRedirect("/students");
    }
}