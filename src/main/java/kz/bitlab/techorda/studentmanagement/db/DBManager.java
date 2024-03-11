package kz.bitlab.techorda.studentmanagement.db;

import kz.bitlab.techorda.studentmanagement.model.Student;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Long id = 3L;

    static {
        studentList.add(new Student(1L,"Madiyar","Serik", 99, "A"));
        studentList.add(new Student(2L,"Ernar","Serik", 80, "B"));

    }

    // getAllStudents();
    public static ArrayList<Student> getAllStudentList(){
        return studentList;
    }

    // addStudent(Student student);
    public static void addStudent(Student student){
        student.setId(id);
        studentList.add(student);
        id++;
        if(student.getExam()>59 && student.getExam()<75){
            student.setMark("C");
        }else if(student.getExam()>89){
            student.setMark("A");
        }else if(student.getExam()>74 && student.getExam()<90){
            student.setMark("B");
        }else if(student.getExam()>49 && student.getExam()<60){
            student.setMark("В");
        } else {
            student.setMark("F");
        }
    }


    //getStudentById();
    public static Student getStudentById(Long id){
        for (Student stud : studentList){
            if (stud.getId() == id){
                return stud;
            }
        }
        return null;
    }

    //updateStudent(Long id, Student student)
    public static void updateStudent(Long id, Student student){
        for (Student stud : studentList){
            if (stud.getId()==id){
                studentList.set(Integer.parseInt(String.valueOf(id)),student);
            }
        }
    }

    // deleteStudent(Long id);
    public static void deleteStudent(Long id){
        for (Student stud : studentList){
            if (stud.getId()==id){
                studentList.remove(Integer.parseInt(String.valueOf(id)));
            }
        }
    }

}
