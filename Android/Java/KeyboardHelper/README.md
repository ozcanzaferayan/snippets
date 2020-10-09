# KeyboardHelper
This class can be used as hiding keyboard. For showing, please add `android:windowSoftInputMode=\"stateVisible\"` to activity tag which stays in AndroidManifest.

```xml
<activity
    android:name=".ui.main.MainActivity"
    android:windowSoftInputMode="stateVisible" />
```

## Usage
```java
KeyboardHelper.hide(fragment.getActivity());
```