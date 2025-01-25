
import java.util.ArrayList;
import java.util.List;

public class HostelManagement {
    private List<Student> students;
    private RoomManager roomManager;

    public HostelManagement() {
        students = new ArrayList<>();
        roomManager = new RoomManager();
    }

    // Add student to the system
    public void addStudent(String name, String gender, String id) {
        students.add(new Student(name, gender, id));
        System.out.println("Student " + name + " with ID " + id + " added.");
    }

    // Remove student from the system
    public void removeStudent(String id) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student with ID " + id + " has been removed.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Allocate room to student based on ID and gender
    public void allocateRoomToStudent(String id) {
        Student student = null;
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                student = s;
                break;
            }
        }

        if (student != null) {
            String gender = student.getGender();
            Room allocatedRoom = roomManager.allocateRoomByGender(gender);
            if (allocatedRoom != null) {
                student.setRoomNumber(allocatedRoom.getRoomNumber());
                System.out.println("Student with ID " + id + " (Gender: " + gender + ") allocated room " + allocatedRoom.getRoomNumber());
            } else {
                System.out.println("No available rooms for " + gender + " students.");
            }
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // View all students
    public List<Student> getStudents() {
        return students;
    }

    // View all rooms
    public List<Room> getRooms() {
        return roomManager.getRooms();
    }
}
