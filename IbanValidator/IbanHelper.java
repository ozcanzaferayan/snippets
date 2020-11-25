package yourpackage;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class IbanHelper {
    public static boolean isValid(String iban) {
        if (null == iban) return false;

        if(!isIBANLengthValid(iban))
            return false;

        BigInteger numericIBAN = getNumericIBAN(iban, false);

        int checkDigit = numericIBAN.mod(new BigInteger("97")).intValue();
        return checkDigit == 1;
    }
    
    public static int isIBANLengthValid(String iban) {
        String code = iban.substring(0,2).toUpperCase();
        Map<String, Integer> countryMap = new HashMap<String, Integer>() {
            {
                put("AD", 24);
                put("AT", 20);
                put("BE", 16);
                put("BA", 20);
                put("BG", 22);
                put("CH", 21);
                put("CY", 28);
                put("CZ", 24);
                put("DE", 22);
                put("DK", 18);
                put("EE", 20);
                put("ES", 24);
                put("FO", 18);
                put("FI", 18);
                put("FR", 27);
                put("GB", 22);
                put("GI", 23);
                put("GL", 18);
                put("GR", 27);
                put("HU", 28);
                put("HR", 21);
                put("IE", 22);
                put("IS", 26);
                put("IT", 27);
                put("LI", 21);
                put("LT", 20);
                put("LU", 20);
                put("LV", 21);
                put("MA", 24);
                put("MC", 27);
                put("MK", 19);
                put("MT", 31);
                put("NL", 18);
                put("NO", 15);
                put("PL", 28);
                put("PT", 25);
                put("RO", 24);
                put("RS", 22);
                put("SE", 24);
                put("SI", 19);
                put("SK", 24);
                put("SM", 27);
                put("TN", 24);
                put("TR", 26);
            }
        };

        Integer length = countryMap.get(code);

        return length == null ? false : iban.length == length;
    }

    private static BigInteger getNumericIBAN(String iban, boolean isCheckDigitAtEnd) {
        String endCheckDigitIBAN = iban;
        if (!isCheckDigitAtEnd) {
            endCheckDigitIBAN = iban.substring(4) + iban.substring(0, 4);
        }
        StringBuilder numericIBAN = new StringBuilder();
        for (int i = 0; i < endCheckDigitIBAN.length(); i++) {
            if (Character.isDigit(endCheckDigitIBAN.charAt(i))) {
                numericIBAN.append(endCheckDigitIBAN.charAt(i));
            } else {
                numericIBAN.append(10 + getAlphabetPosition(endCheckDigitIBAN.charAt(i)));
            }
        }

        return new BigInteger(numericIBAN.toString());
    }

    private static int getAlphabetPosition(char letter) {
        return Character.valueOf(Character.toUpperCase(letter)).compareTo(Character.valueOf('A'));
    }

}
