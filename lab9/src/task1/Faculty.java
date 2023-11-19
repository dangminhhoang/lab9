package task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name, address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", courses=" + courses +
                '}';
    }
	public Course getMaxPracticalCourse() {
  

    Course re = null;

    for (Course course : courses) {
        if (course.isPractical()) {
            if (re == null || course.hasMoreStudentsThan(re)) {
                re = course;
            }
        }
    }

    return re;
}
	public Map<Integer, List<Student>> groupStudentsByYear(){
		Map<Integer, List<Student>> studentsByYear = new HashMap<>();

        for (Course course : courses) {
            for (Student student : course.getStudents()) {
                List<Student> studentsInYear = studentsByYear.get(student.getYear());
                if (studentsInYear == null) {
                    studentsInYear = new ArrayList<>();
                    studentsByYear.put(student.getYear(), studentsInYear);
                }
                studentsInYear.add(student);
            }
        }

        return studentsByYear;
    }
	public Set<Course> filterCourses(String type) {
        Set<Course> filteredCourses = new TreeSet<>(new Comparator<Course>() {
            @Override
            public int compare(Course course1, Course course2) {
                return Integer.compare(course2.getStudentCount(), course1.getStudentCount());
            }
        });

        for (Course course : courses) {
            if (course.getType().equals(type)) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }
	}

