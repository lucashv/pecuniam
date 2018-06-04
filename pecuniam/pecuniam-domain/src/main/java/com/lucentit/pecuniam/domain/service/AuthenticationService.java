package com.lucentit.pecuniam.domain.service;

import com.lucentit.pecuniam.domain.model.User;

public interface AuthenticationService {
    boolean isUserAuthenticated(String userName, String password);
    User authenticateUser(String userName, String password);
}
