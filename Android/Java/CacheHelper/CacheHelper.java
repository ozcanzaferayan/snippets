package yourPackage;

import android.content.Context;
import okhttp3.Cache;

import java.io.File;

public class CacheHelper {
    public static Cache getCache(Context context){
        long cacheSize = ( 10 * 1024 * 1024); // 10MB
        Cache cache = new Cache(new File(context.getCacheDir(), "http-cache"), cacheSize);
        return cache;
    }
}
