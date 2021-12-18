package ds;

import java.sql.SQLException;
import java.sql.Types;

public class CloumnBean {
    String  name;
    int  type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }
    public String getTypeName(){
        return getTypeName(type);
    }

    public void setType(int type) {
        this.type = type;
    }
    public  String getTypeName(int type) {
        switch (type) {
            case Types.ARRAY:
                break;
            case Types.BIGINT:
                return "BIGINT";
            case Types.BINARY:
                return "BINARY";
            case Types.BIT:
                return "BIT";
            case Types.BLOB:
                return "BLOB";
            case Types.BOOLEAN:
                return "BOOLEAN";
            default:
                return "STRING";

        }
        return "STRING";
    }
}
