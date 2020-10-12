function isEmailValid(input) {
    // This regex obtained from https://emailregex.com/
    return input.match(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) !== null;
}

// Example:
// isEmailValid("ozcanzaferayan@gmail.com")
// true
// isEmailValid("ozcanzaferayan@gmail.com")
// true