package pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-27 16:48人
 **/
public class Person implements Serializable {
    private int id;
    private int names;
    private Set<Room> room;

    public Person(int id, int names) {
        this.id = id;
        this.names = names;
    }

    public Set<Room> getRoom() {
        return room;
    }

    public void setRoom(Set<Room> room) {
        this.room = room;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNames() {
        return names;
    }

    public void setNames(int names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", names=" + names +
                ", room=" + room +
                '}';
    }
}
