function normalizeUnicodes(text) {
    return text.normalize("NFKD").replace(/[\u0300-\u036f]/g, "");
}

// Example:
// normalizeUnicodes('Ç Ğ İ Ö Ş Ü Ç Ğ İ Ö Ş Ü');
// "C G I O S U C G I O S U"