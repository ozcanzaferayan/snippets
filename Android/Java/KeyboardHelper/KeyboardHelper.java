package yourpackage;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class KeyboardHelper {
    public static void hide(Activity activity){
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void show(Activity act){
        Toast.makeText(act, "Manifest dosyasında şunu giriniz: android:windowSoftInputMode=\"stateVisible\"", Toast.LENGTH_SHORT).show();
    }
}
