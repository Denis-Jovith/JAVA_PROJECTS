
public class Student {
    private String name;
    private String gender; // Gender of the student
    private String id; // Student ID
    private String roomNumber;

    public Student(String name, String gender, String id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.roomNumber = null; // Room will be allocated later
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Student {" +
                "Name='" + name + '\'' +
                ", Gender='" + gender + '\'' +
                ", ID='" + id + '\'' +
                ", Room Number='" + roomNumber + '\'' +
                '}';
    }
}
