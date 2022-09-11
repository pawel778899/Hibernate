package hibernate;

import hibernate.model.Course;
import hibernate.model.Student;
import hibernate.repository.CourseRepository;
import hibernate.repository.StudentRepository;
import hibernate.model.Teacher;
import hibernate.repository.TeacherRepository;
import org.hibernate.Session;

public class MainUniversity {
//    static HibernateFactory hibernateFactory = new HibernateFactory();
//
//    static StudentRepository studentRepository = new StudentRepository();
//    static TeacherRepository teacherRepository = new TeacherRepository();
//
    public static void main(String[] args) {
//        Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession();
//        session.close();
//
//        Student student = new Student();
//        student.setFirstName("Janek");
//        student.setLastName("Kowalski");
//        student.setIndexNumber(11111);

//        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.add(student);
//          System.out.println(studentRepository.findByIndexNumber(4));

//        Teacher teacher = new Teacher();
//        teacher.setFirstName("Jan");
//        teacher.setLastName("Kowalski");
//        teacher.setId(11111);
//
//
//        TeacherRepository teacherRepository = new TeacherRepository();
//        teacherRepository.add(teacher);
//        System.out.println(teacherRepository.findById(11111));

    CourseRepository courseRepository = new CourseRepository();
    Course coyurseDb = courseRepository.findById(3);
    System.out.println(coyurseDb);

    TeacherRepository teacherRepository = new TeacherRepository();
    Teacher teacher = teacherRepository.findById(12);
    teacher.getCourses().forEach(c -> System.out.println(c.getName()));

}




    }

