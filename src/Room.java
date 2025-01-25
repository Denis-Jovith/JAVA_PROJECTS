
public class Room {
    private String roomNumber;
    private String gender; // "Male" or "Female"
    private boolean isAllocated;

    public Room(String roomNumber, String gender) {
        this.roomNumber = roomNumber;
        this.gender = gender;
        this.isAllocated = false;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getGender() {
        return gender;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void allocate() {
        this.isAllocated = true;
    }

    public void deallocate() {
        this.isAllocated = false;
    }

    @Override
    public String toString() {
        return "Room {" +
                "Room Number='" + roomNumber + '\'' +
                ", Gender='" + gender + '\'' +
                ", Allocated=" + isAllocated +
                '}';
    }
}
