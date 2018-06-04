package com.lucentit.pecuniam.domain.repository;

import com.lucentit.pecuniam.domain.model.User;
import com.lucentit.pecuniam.domain.model.UserSession;

public interface UserSessionRepository extends BaseRepository<UserSession, Long> {    
    UserSession returnActiveSession(User user);
}
