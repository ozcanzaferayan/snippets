function getValidIBANLength(countryCode) {
    const code = countryCode.substring(0, 2).toUpperCase();
    const countryMap = {
        "AD": 24,
        "AT": 20,
        "BE": 16,
        "BA": 20,
        "BG": 22,
        "CH": 21,
        "CY": 28,
        "CZ": 24,
        "DE": 22,
        "DK": 18,
        "EE": 20,
        "ES": 24,
        "FO": 18,
        "FI": 18,
        "FR": 27,
        "GB": 22,
        "GI": 23,
        "GL": 18,
        "GR": 27,
        "HU": 28,
        "HR": 21,
        "IE": 22,
        "IS": 26,
        "IT": 27,
        "LI": 21,
        "LT": 20,
        "LU": 20,
        "LV": 21,
        "MA": 24,
        "MC": 27,
        "MK": 19,
        "MT": 31,
        "NL": 18,
        "NO": 15,
        "PL": 28,
        "PT": 25,
        "RO": 24,
        "RS": 22,
        "SE": 24,
        "SI": 19,
        "SK": 24,
        "SM": 27,
        "TN": 24,
        "TR": 26
    }
    const lengthOfCountry = countryMap[code];
    return lengthOfCountry == null ? -1 : lengthOfCountry;
}

function getAlphabetPosition(letter) {
    return Math.abs("A".charCodeAt() - letter.toUpperCase().charCodeAt())
}