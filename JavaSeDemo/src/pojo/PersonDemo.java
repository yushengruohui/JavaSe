package pojo;

import map.BeanUtils;
import net.sf.cglib.beans.BeanCopier;
import org.junit.Test;
import tool.MyBeanTool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-18 08:40
 **/
public class PersonDemo {
    @Test
    public void demo1() {
        Person person = new Person();
        person.setId(0);
        person.setNames(0);
        Room room = new Room();
        room.setRoomId(0);
        room.setRoomName("0001");
        Set<Room> rooms = new HashSet<>();
        rooms.add(room);
        rooms.add(room);
        person.setRoom(rooms);
        System.out.println(person);


    }

    // BeanCopier ，浅拷贝
    @Test
    public void demo2() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomName("500");
        Room room = new Room();
        BeanCopier beanCopier = BeanCopier.create(roomDTO.getClass(), room.getClass(), false);

        beanCopier.copy(roomDTO, room, null);

        System.out.println("room = " + room);
    }

    // BeanCopier ，浅拷贝
    @Test
    public void demo3() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomName("500");
        Door door = new Door();
        door.setDoorId(3);
        door.setDoorName("大门");
        door.setDoorNumbers(2);
        roomDTO.setDoor(door);

        Room room = new Room();
        MyBeanTool.copy(roomDTO, room);

        System.out.println("room = " + room);
        door.setDoorId(1);
        room.setDoor(door);

        System.out.println("roomDTO = " + roomDTO);
    }

    //深拷贝
    @Test
    public void demo4() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomName("我是传送门");
        Door door = new Door();
        door.setDoorId(3);
        door.setDoorName("大门");
        door.setDoorNumbers(2);
        roomDTO.setDoor(door);
        System.out.println("roomDTO = " + roomDTO);

        Room room = new Room();
        //MyBeanTool.copy(roomDTO, room);
        //MyBeanTool.copy(roomDTO, room, new Converter() {
        //    @Override
        //    public Object convert(Object value, Class target, Object context) {
        //        if (target.isAssignableFrom(BigInteger.class)) {
        //            return new BigInteger(value.toString());
        //        } else {
        //            return value;
        //        }
        //    }
        //});
        RoomDTO roomDTO1 = MyBeanTool.deepCopy(roomDTO);
        MyBeanTool.copy(roomDTO1, room);
        System.out.println("room = " + room);
        room.setRoomName("我是门");
        room.setRoomId(2);
        door.setDoorName("侧门");

        System.out.println("room = " + room);
        System.out.println("roomDTO = " + roomDTO);
    }

    @Test
    public void demo5() {
        List<Person> peoples = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setNames(111);
            peoples.add(person);
        }
        System.out.println("peoples = " + peoples.toString());
        Object o = peoples;
        System.out.println("o = " + o.toString());
    }

    @Test
    public void demo6() {
        Person peoples = new Person();
        peoples.setId(111);
        peoples.setNames(123456);
        PersonTemp personTemp = BeanUtils.deepCopy(peoples, PersonTemp.class);
        System.out.println("personTemp = " + personTemp.toString());
    }

    @Test
    public void demo7() {
        Person peoples = new Person();
        peoples.setId(1);
        System.out.println("peoples = " + peoples.toString());
        Person person =new Person();
        person.setId(1);
        System.out.println("person = " + person.toString());
    }
}
