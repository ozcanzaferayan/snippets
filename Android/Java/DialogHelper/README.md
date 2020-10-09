# Usage

## Simple dialog
```java
DialogHelper.showWarning(this, exception.getMessage());
```


## Ok dialog with event
```java
DialogHelper.showWarning(this, "Telefon numaranız değiştirilmiştir", new DialogInterface.OnClickListener(){
    @Override
    public void onClick(DialogInterface dialog, int which) {
        this.finish();
    }
}, "Tamam");
```

## Yes/no dialog with events
```java
DialogHelper.showWarning(this,
        "Kayıt silinecektir emin misiniz?", // this.getString(R.id.are_you_sure)
        (dialogInterface, i) -> {
            if (i != BUTTON_POSITIVE) {
            	// Other events except positive
                return;
            }
            // Positive event
        },
        "Evet",
        "Hayır");
```

## Edit dialog with positive button event
```java
EditText editText = new EditText(this);
editText.setInputType(InputType.TYPE_CLASS_NUMBER);
editText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(11) });
DialogHelper.showEditDialog(this, editText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        },
        "Telefon değiştirme", "Eski telefon numaranız: 05312221114\nYeni telefon numaranızı giriniz:", "Değiştir", "İptal"
);
```


## Dialog with yes no events
```java
DialogHelper.show(
        this,
        "Başarılı",
        "Dosya kaydedildi",
        "Görüntüle",
        "Tamam",
        (dialogInterface, i) -> {
        	// Dosya görüntüleme kodları
        },
        (dialogInterface, i) -> dialogInterface.dismiss()
);
```