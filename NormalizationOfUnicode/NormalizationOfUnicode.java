import java.text.Normalizer;
import java.util.regex.Pattern;

public class NormalizationOfUnicode {
    public static String normalize(String text) {
        Normalizer.Form currentForm = Normalizer.Form.NFKD;
        String normalizedText = Normalizer.normalize(text, currentForm);
        Pattern p = Pattern.compile("[\u0300-\u036f]", Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        return p.matcher(normalizedText).replaceAll("");
    }
}

// Example
// String text = "Ç Ğ İ Ö Ş Ü Ç Ğ İ Ö Ş Ü";
// NormalizationOfUnicode.normalize(text);
// "C G I O S U C G I O S U"
