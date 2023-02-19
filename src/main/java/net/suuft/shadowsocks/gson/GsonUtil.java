package net.suuft.shadowsocks.gson;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GsonUtil {

    @Getter
    private final Gson gson = new Gson();

    public String parseJson(Object object) {
        return gson.toJson(object);
    }

    public <T> T unparseJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

}