String.prototype.turkishtoEnglish = function() {
    return this
        .replace('Ç', 'C')
        .replace('Ğ', 'G')
        .replace('İ', 'I')
        .replace('Ö', 'O')
        .replace('Ş', 'S')
        .replace('Ü', 'U')
        .replace('ç', 'c')
        .replace('ğ', 'g')
        .replace('ı', 'i')
        .replace('ö', 'o')
        .replace('ş', 's')
        .replace('ü', 'u');
};

// Example
// 'Ç Ğ İ Ö Ş Ü Ç Ğ İ Ö Ş Ü'.turkishtoEnglish()
// "C G I O S U C G I O S U"
// 'ç ğ ı ö ş ü ç ğ ı ö ş ü'.turkishtoEnglish()
// "c g i o s u c g i o s u"