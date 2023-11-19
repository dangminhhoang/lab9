package task1;

import java.util.List;
public class Course {
	private String id, title, type, lecturer;
	private List<Student> students;

	public Course(String id, String title, String type, String lecturer, List<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.lecturer = lecturer;
		this.students = students;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course = id:" + id + ", title:" + title + ", type:" + type + ", lecturer:" + lecturer + ", students="
				+ students + "=";
	}
	public int getStudentCount() {
        return students.size();
    }
	 public boolean isPractical() {
	        return "TH".equals(type);
	    }

	    public boolean hasMoreStudentsThan(Course otherCourse) {
	        return this.getStudentCount() > otherCourse.getStudentCount();
	    }
	    public int compareTo(Course otherCourse) {
	        return Integer.compare(otherCourse.getStudentCount(), this.getStudentCount());
	    }
}
