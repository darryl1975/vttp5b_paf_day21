package sg.edu.nus.iss.vttp5b_paf_day21.model;

public class Room {
    private int id;

    private String roomtype;

    private float price;

    public Room(int id, String roomtype, float price) {
        this.id = id;
        this.roomtype = roomtype;
        this.price = price;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
}
