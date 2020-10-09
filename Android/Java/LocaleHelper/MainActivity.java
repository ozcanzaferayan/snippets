package yourpackage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;


public final class MainActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity act = this;
        final Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(view -> {
            String newLocale = LocaleHelper.getLocale(act.getResources()).getLanguage().equals("tr") ? "en" : "tr";
            LocaleHelper.setNewLocale(act, newLocale, false);
        });
    }
}
