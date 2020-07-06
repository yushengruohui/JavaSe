package pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-18 09:06
 **/
public class Room implements Serializable {
    private int roomId;
    private String roomName;
    private Door door;

    public Room() {
    }

    public Room(int roomId, String roomName, Door door) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.door = door;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append(" ");
        sb.append("\"roomId\":");
        sb.append(roomId);
        sb.append(",");
        sb.append("\"roomName\":\"");
        sb.append(roomName);
        sb.append("\"");
        sb.append(",");
        sb.append("\"door\":");
        sb.append(door);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return roomId == room.roomId &&
                Objects.equals(roomName, room.roomName) &&
                Objects.equals(door, room.door);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomName, door);
    }
}
