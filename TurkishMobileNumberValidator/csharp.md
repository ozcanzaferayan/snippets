### IsTurkishMobileNumber
You can use the code below to check if given mobile phone number valid according to Turkish mobile number pattern.

```csharp
using System;
using System.Text.RegularExpressions;

public class Example
{
    public static void Main()
    {
      Console.WriteLine(IsTurkishMobileNumber("5319221559")); 
      Console.WriteLine(IsTurkishMobileNumber("+905319221559"));
      Console.WriteLine(IsTurkishMobileNumber("5581234567"));
      Console.WriteLine(IsTurkishMobileNumber("+905581234567"));
      // True
      // True
      // False
      // False
    }
   
    public static bool IsTurkishMobileNumber(String candidate){
        string pattern = @"^(\+?90|0)?(501|505|506|507|530|531|532|533|534|535|536|537|538|539|540|541|542|543|544|545|546|547|548|549|551|552|553|554|555|559)[0-9]{7}$";
        Regex rgx = new Regex(pattern);
        return rgx.Matches(candidate).Count > 0;
    }
}
```
