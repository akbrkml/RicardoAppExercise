package com.example.nischal.ricardoappexercise.helper;

public class AppConstants {

    public static final int REQUEST_USER_LOGIN = 0001;

    public static final String PREF_NAME = "Ricardo_farm";
    public static final String DB_NAME = "Ricardo_Farm.realm";


    public static final Integer NULL_INDEX = 0;

    public class BASEURL {
        public static final String url_draftserver = "http://ent.draftserver.com/ricardofarm/public/api/v1.1.1/";
        public static final String url_saurav_local = "http://192.168.0.231:1234/api/v1.2/";
        public static final String url_app_live = "http://app.farmservicemanager.com/api/v1.2/";
    }

    public class Validation {
        //Registration validation messages
        public static final String IS_VALID = "is_valid";
        public static final String INVALID_MANAGERS_NAME = "Please enter the manager operator's name.";
        public static final String INVALID_COMPANY_NAME = "Please enter company name.";
        public static final String INVALID_FARM_NAME = "Please enter farm name.";
        public static final String INVALID_PASSWORD = "Please enter password.";
        public static final String INVALID_OLD_PASSWORD = "Please enter old password";
        public static final String INVALID_NEW_PASSWORD = "Please enter new password";
        public static final String INVALID_NEW_PASSWORD_FORMAT = "Password must be at least 8 characters long and alphanumeric.";
        public static final String INVALID_COUNTRY = "Please select country.";
        public static final String INVALID_ADDRESS = "Please enter address.";
        public static final String INVALID_CODE = "Please enter phone number.";
        public static final String INVALID_PHONE_NUMBER = "Please enter phone number.";
        public static final String INVALID_NAME = "Please enter name.";
        public static final String EMPTY_EMAIL = "Please enter email address.";
        public static final String INVALID_EMAIL = "Please enter valid email address.";
        public static final String INVALID_PASSWORD_FORMAT = "Password must be alphanumeric.";
        public static final String INVALID_PASSWORD_LENGTH = "Password must be at least 8 characters long and alphanumeric.";
        public static final String INVALID_NEW_PASSWORD_LENGTH = "New Password must be at least 8 characters long and alphanumeric.";

        public static final String EMPTY_VERIFICATION_CODE = "Please enter verification code.";
        public static final String EMPTY_IMAGE = "Please upload an image.";
        public static final String INVALID_PHONE_NUMBER_LENGTH = "The phone number you have entered is invalid.";
        public static final String EMPTY_PART_NAME = "Please enter part name.";
        public static final String EMPTY_PART_COMMENTS = "Please enter comments.";
    }
    public class VerificationCode {
        public static final int SUCCESS = 200;

        //Login response verification codes
        public static final int INCORRECT_CREDENTIALS = 401;
        public static final int INACTIVE_ACCOUNT = 403;
        public static final int EMAIL_NOT_RECOGNIZED = 404;
        public static final int INVALID_DATA = 412;
        public static final int CONTACT_NOT_VERIFIED = 423;
        public static final int UNABLE_TO_HANDLE_REQUEST = 500;
        public static final int UNABLE_TO_GENERATE_TOKEN = 501;
        public static final int TOKEN_EXPIRED = 401;

        public static final int CONTACT_ALREADY_VERIFIED = 400;
        public static final int NOT_ALLOWED_TO_PERFORM = 403;
        public static final int VERIFICATION_CODE_ALREADY_SENT = 406;
        public static final int NUMBER_ALREADY_IN_USE = 409;
        public static final int VERIFICATION_SENT = 0;
        public static final int PAGE_NOT_FOUND = 404;
        public static final int NOT_ALLOWED_FOR_PAYMENT = 403;
        public static final int SETUP_YOUR_PAYMENT_FIRST = 412;
        public static final int TERMS_PRIVACY_UPDATED = 605;
        public static final int TERMS_UPDATED = 603;
        public static final int PRIVACY_UPDATED = 604;
        public static final int INVALID_CARD = 606;
    }
    public class DEMO_USER {
        public static final String email = "demo@farmservicemanager.com.au";
        public static final String password = "fsmdemo1234";
    }


}
