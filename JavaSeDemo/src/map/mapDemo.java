package map;

import org.junit.Test;
import pojo.Person;
import pojo.Room;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @autho yusheng
 * @create-date 2020-03-30 14:20
 **/
public class mapDemo {
    @Test
    public void demo1() {
        // 对象转map
        Person person = new Person();
        Set<Room> rooms = new HashSet<>();
        Room room = new Room();
        room.setRoomName("111");
        rooms.add(room);
        person.setRoom(rooms);
        person.setNames(2222);
        System.out.println("person = " + person);
        Map<String, Object> map = BeanUtils.beanToMap(person);
        System.out.println("map = " + map);
    }

    @Test
    public void demo2() {
        // map转对象
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1111);
        map.put("name", 222);
        Set<Room> rooms = new HashSet<>();
        Room room = new Room();
        room.setRoomName("111");
        rooms.add(room);
        map.put("room", rooms);

        System.out.println("map = " + map.get("room"));
        Person person = BeanUtils.mapToBean(map, Person.class);
        System.out.println("person = " + person);
    }
}
