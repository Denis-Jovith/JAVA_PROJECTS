import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> maleRooms;
    private List<Room> femaleRooms;
    private List<Student> maleStudents;
    private List<Student> femaleStudents;

    public RoomManager() {
        maleRooms = new ArrayList<>();
        femaleRooms = new ArrayList<>();
        maleStudents = new ArrayList<>();
        femaleStudents = new ArrayList<>();

        // Adding male rooms 6A-1 to 6A-200 and 6B-1 to 6B-200
        for (int i = 1; i <= 200; i++) {
            maleRooms.add(new Room("6A-" + i, "Male"));
            maleRooms.add(new Room("6B-" + i, "Male"));
        }

        // Adding female rooms 8C-1 to 8C-200 and 8D-1 to 8D-200
        for (int i = 1; i <= 200; i++) {
            femaleRooms.add(new Room("8C-" + i, "Female"));
            femaleRooms.add(new Room("8D-" + i, "Female"));
        }


    }

    // Allocate room based on gender
    public Room allocateRoomByGender(String gender) {
        if (gender.equalsIgnoreCase("Male") && !maleRooms.isEmpty()) {
            return maleRooms.remove(0); // Allocate the first available male room
        } else if (gender.equalsIgnoreCase("Female") && !femaleRooms.isEmpty()) {
            return femaleRooms.remove(0); // Allocate the first available female room
        }
        return null; // No available rooms
    }

    // Get all rooms
    public List<Room> getRooms() {
        List<Room> allRooms = new ArrayList<>(maleRooms);
        allRooms.addAll(femaleRooms);
        return allRooms;
    }

    // Get all male students
    public List<Student> getMaleStudents() {
        return maleStudents;
    }

    // Get all female students
    public List<Student> getFemaleStudents() {
        return femaleStudents;
    }
}
