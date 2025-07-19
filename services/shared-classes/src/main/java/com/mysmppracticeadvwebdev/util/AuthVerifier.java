package com.mysmppracticeadvwebdev.util;

import java.util.Map;

public interface AuthVerifier {
    void verifyUser(Map<String, String> user_details);
}
