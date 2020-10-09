package yourpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR1;
import static android.os.Build.VERSION_CODES.N;

import java.util.Locale;

public class LocaleHelper {
    public static final  String LANGUAGE_ENGLISH   = "en";
    public static final  String LANGUAGE_TURKISH   = "tr";
    private static final String LANGUAGE_KEY       = "language_key";

    private final SharedPreferences prefs;

    public LocaleHelper(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public Context setLocale(Context c) {
        return updateResources(c, getLanguage());
    }

    public Context setNewLocale(Context c, String language) {
        persistLanguage(language);
        return updateResources(c, language);
    }

    public String getLanguage() {
        return prefs.getString(LANGUAGE_KEY, LANGUAGE_TURKISH);
    }

    @SuppressLint("ApplySharedPref")
    private void persistLanguage(String language) {
        prefs.edit().putString(LANGUAGE_KEY, language).commit();
    }

    private Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        if (isAtLeastVersion(JELLY_BEAN_MR1)) {
            config.setLocale(locale);
            context = context.createConfigurationContext(config);
        } else {
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
        return context;
    }

    public static Locale getLocale(Resources res) {
        Configuration config = res.getConfiguration();
        return isAtLeastVersion(N) ? config.getLocales().get(0) : config.locale;
    }


    public static boolean setNewLocale(Activity activity, String language, boolean restartProcess) {
        App.localeHelper.setNewLocale(activity, language);

        Intent i = new Intent(activity, MainActivity.class);
        activity.startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

        if (restartProcess) {
            System.exit(0);
        } else {
            Toast.makeText(activity, "Dil değiştirildi", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public static boolean isAtLeastVersion(int version) {
        return Build.VERSION.SDK_INT >= version;
    }
}
