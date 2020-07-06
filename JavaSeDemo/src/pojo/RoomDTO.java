package pojo;

import net.sf.cglib.core.Converter;

import java.io.Serializable;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-18 09:06
 **/
public class RoomDTO implements Serializable, Converter {

    private String roomName;
    private Door door;

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * 转换器
     * 遍历src的每一个属性
     * 通过set方法赋值到target的同属性名
     *
     * @param value   src对象的某属性的值
     * @param target  target对象的全类名，不用输入，自动调用之前使用的BeanCopier的target对象的全类名
     * @param context src对象的某属性的get方法，如getUserName
     * @return
     */
    @Override
    public Object convert(Object value, Class target, Object context) {

        return value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append(" ");
        sb.append("\"roomName\":\"");
        sb.append(roomName);
        sb.append("\"");
        sb.append(",");
        sb.append("\"door\":");
        sb.append(door);
        sb.append("}");
        return sb.toString();
    }
}
