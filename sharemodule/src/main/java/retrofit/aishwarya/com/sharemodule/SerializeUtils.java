package retrofit.aishwarya.com.sharemodule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by aishwarya on 24/6/16.
 */
public class SerializeUtils {

    public static Object deserialize(byte[] data) {
        ObjectInputStream is = null;
        Object object = null;
        if (data.length != 0) {
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            try {
                is = new ObjectInputStream(in);
                object = is.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return object;
    }

    public static byte[] serialize(Object obj) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(out);
            os.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }


}
