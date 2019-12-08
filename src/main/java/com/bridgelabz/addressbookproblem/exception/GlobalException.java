package com.bridgelabz.addressbookproblem.exception;

public class GlobalException extends Exception {
    public String message;
    public static ExceptionType type;

    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FILE, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE, NO_ACCESS, BINDING_PROBLEM_AT_RUNTIME
    }

    public GlobalException(String message) {
        super(message);
    }
    public GlobalException(String s, ExceptionType type) {
        super(s);
        this.type = type;
    }
}
