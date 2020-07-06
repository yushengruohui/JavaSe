package pojo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-09-27 16:48人
 **/
public class PersonTemp implements Serializable {
    private String id;
    private int names;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        StringBuilder sb = new StringBuilder(300);
        sb.append(this.getClass().getSimpleName()).append("{");
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String modifier = Modifier.toString(field.getModifiers());
                if (modifier.contains("static final")) {
                    continue;
                }
                sb.append(field.getName()).append(":").append(field.get(this)).append(",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        return sb.toString();
    }

}
