package yourpackage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

public class DialogHelper {
    public static AlertDialog showEditDialog(Context c,
                                             EditText editText,
                                             DialogInterface.OnClickListener listener,
                                             String title,
                                             String msg,
                                             String posBtnTxt,
                                             String negBtnTxt) {
        ForegroundColorSpan color = new ForegroundColorSpan(Color.RED);
        SpannableStringBuilder colorBuilder = new SpannableStringBuilder(title);
        colorBuilder.setSpan(
                color,
                0,
                title.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setView(editText);
        builder.setPositiveButton(posBtnTxt, listener);
        builder.setNegativeButton(negBtnTxt, listener);
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        alertDialog.show();
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();
                return true;
            }
        });
        return alertDialog;
    }

    public static AlertDialog showWarning(Context c, String text) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        if (!(c instanceof  Activity)) return null;
        if(((Activity) c).isFinishing()) return null;
        return dialog.show();
    }

    public static AlertDialog showWarning(Context c,
                                          String text,
                                          DialogInterface.OnClickListener listener,
                                          String posBtnTxt,
                                          String negBtnTxt,
                                          String neuBtnTxt) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setPositiveButton(posBtnTxt, listener);
        dialog.setNegativeButton(negBtnTxt, listener);
        dialog.setNeutralButton(neuBtnTxt, listener);

        return dialog.show();
    }

    public static AlertDialog showWarning(Context c,
                                          Spanned text,
                                          DialogInterface.OnClickListener listener,
                                          String posBtnTxt,
                                          String negBtnTxt) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setPositiveButton(posBtnTxt, listener);
        dialog.setNegativeButton(negBtnTxt, listener);
        dialog.setCancelable(true);
        return dialog.show();
    }


    public static AlertDialog showWarning(Context c,
                                          String text,
                                          DialogInterface.OnClickListener listener,
                                          String posBtnTxt,
                                          String negBtnTxt) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setPositiveButton(posBtnTxt, listener);
        dialog.setNegativeButton(negBtnTxt, listener);
        if (!(c instanceof  Activity)) return null;
        if(((Activity) c).isFinishing()) return null;
        return dialog.show();
    }

    public static AlertDialog showWarningYesNo(Context c,
                                               String text,
                                               DialogInterface.OnClickListener listener) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setPositiveButton("Evet", listener);
        dialog.setNegativeButton("Hayır", listener);
        return dialog.show();
    }

    public static AlertDialog showForApkInstall(Activity act,
                                                Spanned text,
                                                DialogInterface.OnClickListener listener,
                                                String posBtnTxt) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(act);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setCancelable(false);
        dialog.setPositiveButton(posBtnTxt, listener);
        return dialog.show();
    }

    public static AlertDialog showWarning(Context c,
                                          Spanned text,
                                          DialogInterface.OnClickListener listener,
                                          String posBtnTxt) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setPositiveButton(posBtnTxt, listener);
        return dialog.show();
    }

    public static AlertDialog showWarning(Context c,
                                          String text,
                                          DialogInterface.OnClickListener listener,
                                          String posBtnTxt) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Uyarı");
        dialog.setMessage(text);
        dialog.setPositiveButton(posBtnTxt, listener);
        dialog.setCancelable(false);
        return dialog.show();
    }


    public static void show(Context c, String title, int resourceId) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle(title);
        dialog.setMessage(c.getString(resourceId));
        dialog.show();
    }


    public static void show(Context c, String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.show();
    }

    public static AlertDialog showSuccess(Context c,
                                          String text,
                                          DialogInterface.OnClickListener listener) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Başarılı");
        dialog.setMessage(text);
        dialog.setPositiveButton("Tamam", listener);
        return dialog.show();
    }

    public static AlertDialog show(Context c,
                                   String title,
                                   String text,
                                   String positiveButtonText,
                                   String negativeButtonText,
                                   DialogInterface.OnClickListener positiveListener,
                                   DialogInterface.OnClickListener negativeListener) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle(title);
        dialog.setMessage(text);
        dialog.setPositiveButton(positiveButtonText, positiveListener);
        dialog.setNegativeButton(negativeButtonText, negativeListener);

        return dialog.show();
    }
}
