### TurkishMobileNumbers
You can use the code below to check if given mobile phone number valid according to Turkish mobile number pattern.

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Main {
  public static void main(String[] args) {
    System.out.println(isTurkishMobileNumber("5319221559")); 
    System.out.println(isTurkishMobileNumber("+905319221559"));
    System.out.println(isTurkishMobileNumber("5581234567"));
    System.out.println(isTurkishMobileNumber("+905581234567"));
    // true
    // true
    // false
    // false
  }
  
  public static boolean isTurkishMobileNumber(String candidate){
    String patternString = "^(\\+?90|0)?(501|505|506|507|530|531|532|533|534|535|536|537|538|539|540|541|542|543|544|545|546|547|548|549|551|552|553|554|555|559)[0-9]{7}$";    
    Pattern pattern = Pattern.compile(patternString);   
    Matcher matcher = pattern.matcher(candidate);
    return matcher.matches();
  }
}
```
