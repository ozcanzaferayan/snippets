public class TurkishCharactersReplacer {
    public static String replace(String text) {
        return text
            .replace("Ç", "C")
            .replace("Ğ", "G")
            .replace("İ", "I")
            .replace("Ö", "O")
            .replace("Ş", "S")
            .replace("Ü", "U")
            .replace("ç", "c")
            .replace("ğ", "g")
            .replace("ı", "i")
            .replace("ö", "o")
            .replace("ş", "s")
            .replace("ü", "u");
    }
}

// Example
// String text = "Ç Ğ İ Ö Ş Ü Ç Ğ İ Ö Ş Ü";
// TurkishCharactersReplacer.replace(text);
// "C G I O S U C G I O S U"
// text = "ç ğ ı ö ş ü ç ğ ı ö ş ü";
// TurkishCharactersReplacer.replace(text);
// "c g i o s u c g i o s u"
