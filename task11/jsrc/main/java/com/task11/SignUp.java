package com.task11;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record SignUp(String email, String password, String firstName, String lastName) {

    private static final Logger logger = LoggerFactory.getLogger(SignUp.class);

    public SignUp {
        logger.debug("23253253 - Validating SignUp data: email={}, password={}, firstName={}, lastName={}",
                email, (password != null ? "[PROVIDED]" : "null"), firstName, lastName);

        if (email == null || password == null || firstName == null || lastName == null) {
            logger.error("23253253 - Invalid SignUp data: Missing fields.");
            throw new IllegalArgumentException("Missing or incomplete data.");
        }
    }

    public static SignUp fromJson(String jsonString) {
        logger.info("23253253 - Parsing SignUp data from JSON.");
        JSONObject json = new JSONObject(jsonString);
        String email = json.optString("email", null);
        String password = json.optString("password", null);
        String firstName = json.optString("firstName", null);
        String lastName = json.optString("lastName", null);

        SignUp signUp = new SignUp(email, password, firstName, lastName);
        logger.debug("23253253 - Parsed SignUp object: {}", signUp);
        return signUp;
    }
}
