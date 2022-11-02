package edu.miu.rest.phaseone.storage;

import edu.miu.rest.phaseone.entity.Course;
import edu.miu.rest.phaseone.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Kuylim TITH
 * Date: 11/1/2022
 */
public class FakeDB {
    private FakeDB() {
    }

    public static final List<Student> STU_DB = new ArrayList<>();
    public static final List<Course> CO_DB = new ArrayList<>();
    public static final Map<EnumID, Long> ID = new HashMap<>();

    static {

        Course fpp = new Course(1L, "Foundation Programming", "FPP");
        Course mpp = new Course(2L, "Modern Programming", "MPP");
        Course ea = new Course(3L, "Enterprise Architecture", "EA");
        Course cloud = new Course(4L, "Cloud Computing", "CC");
        Course sa = new Course(5L, "Software Architecture", "SA");

        CO_DB.add(fpp);
        CO_DB.add(mpp);
        CO_DB.add(ea);
        CO_DB.add(cloud);
        CO_DB.add(sa);

        Student stu1 = new Student(1L, "Jhon", "Doe", "jhon@mail.com", "CS", 3.999f,
                List.of(fpp, mpp, ea));
        Student stu2 = new Student(2L, "Alex", "Jan", "alex@mail.com", "CS", 3.999f,
                List.of(fpp, mpp, cloud));
        Student stu3 = new Student(3L, "Ryan", "Joe", "ryan@mail.com", "MSD", 4.0f,
                List.of(fpp, mpp, sa));

        STU_DB.add(stu1);
        STU_DB.add(stu2);
        STU_DB.add(stu3);

        ID.put(EnumID.C_ID, 6L);
        ID.put(EnumID.S_ID, 4L);
    }
}
