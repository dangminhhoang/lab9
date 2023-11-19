package task1;

import java.util.ArrayList;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		Student s1 = new Student("111", "hieu", 2004);
		Student s2 = new Student("222", "hoang", 2005);
		Student s3 = new Student("333", "hau", 2004);
		Student s5 = new Student("555", "trong", 2005);
		
		
		ArrayList<Student> students1 = new ArrayList<>();
		students1.add(s5);
		students1.add(s3);
		
		ArrayList<Student> students2 = new ArrayList<>();
		students2.add(s1);
		students2.add(s2);
		students2.add(s3);
		
		ArrayList<Student> students3 = new ArrayList<>();
		students3.add(s5);
		students3.add(s3);
		students3.add(s2);
		students3.add(s1);
		
		Course c1 = new Course("1","ctdl","LT","Nguyen Van Du", students1);
		Course c2 = new Course("gtnm", "02", "TH", "Le Van Hung", students2 );
		Course c3 = new Course("trr", "03", "TH", "phuong tram",students3 );
		
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(c3);
		courses.add(c2);
		courses.add(c1);
		
		Faculty f = new Faculty("cntt", "hcm", courses);
		
//	System.out.println(f.filterCourses("TH"));
		
	 System.out.println("Filtered TH Courses:");
     Set<Course> filteredCourses = f.filterCourses("TH");
     for (Course course : filteredCourses) {
         System.out.println(course);
     }
    }
	}

