package com.lucentit.pecuniam.domain.service.impl;

import com.lucentit.pecuniam.domain.model.User;
import com.lucentit.pecuniam.domain.repository.UserRepository;
import com.lucentit.pecuniam.domain.repository.UserSessionRepository;
import com.lucentit.pecuniam.domain.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepository userRepo;
    private UserSessionRepository userSessionRepo;
    
    public AuthenticationServiceImpl() {
        
    }
    
    public AuthenticationServiceImpl(UserRepository userRepo, UserSessionRepository userSessionRepo) {
        this();
        this.userRepo = userRepo;
        this.userSessionRepo = userSessionRepo;
    }
    
    @Override
    public boolean isUserAuthenticated(String userName, String password) {
        User user = this.userRepo.returnByUsernameAndPassword(userName, password);
        
        if (user == null)
            return false;
        
        return userSessionRepo.returnActiveSession(user) != null;
    }

    @Override
    public User authenticateUser(String userName, String password) {
        return this.userRepo.returnByUsernameAndPassword(userName, password);
    }
    
}
