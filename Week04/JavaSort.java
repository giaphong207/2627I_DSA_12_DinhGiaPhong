import java.util.ArrayList; //Bài 4
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

//Lớp so sánh sinh viên
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        //so sánh CGPA giảm dần
        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
        //nếu CGPA bằng nhau, so sánh Tên (fname) theo thứ tự alphabet (A-Z)
        int nameCompare = s1.getFname().compareTo(s2.getFname());
        if (nameCompare != 0) {
            return nameCompare;
        }
        //nếu cả CGPA và Tên đều giống nhau, so sánh ID tăng dần
        return Integer.compare(s1.getId(), s2.getId());
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int testCases = Integer.parseInt(in.nextLine());
            List<Student> studentList = new ArrayList<Student>();
            while (testCases > 0) {
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();
                Student st = new Student(id, fname, cgpa);
                studentList.add(st);
                testCases--;
            }
            Collections.sort(studentList, new StudentComparator()); //thực hiện sắp xếp danh sách sinh viên bằng Comparator
            for (Student st : studentList) {
                System.out.println(st.getFname());
            }
        }
        in.close();
    }
}
