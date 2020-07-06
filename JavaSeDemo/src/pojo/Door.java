package pojo;

import java.io.Serializable;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-18 16:33
 **/
public class Door implements Serializable {
    private Integer doorId;
    private String doorName;
    private Integer doorNumbers;

    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public Integer getDoorNumbers() {
        return doorNumbers;
    }

    public void setDoorNumbers(Integer doorNumbers) {
        this.doorNumbers = doorNumbers;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append(" ");
        sb.append("\"doorId\":");
        sb.append(doorId);
        sb.append(",");
        sb.append("\"doorName\":\"");
        sb.append(doorName);
        sb.append("\"");
        sb.append(",");
        sb.append("\"doorNumbers\":");
        sb.append(doorNumbers);
        sb.append("}");
        return sb.toString();
    }
}
