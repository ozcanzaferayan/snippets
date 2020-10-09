package yourpackage;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.util.Locale;

public final class App extends Application implements Configuration.Provider {

    public static LocaleHelper localeHelper;
    
    @Override
    protected void attachBaseContext(Context base) {
        localeHelper = new LocaleHelper(base);
        super.attachBaseContext(localeHelper.setLocale(base));
    }

    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        localeHelper.setLocale(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
