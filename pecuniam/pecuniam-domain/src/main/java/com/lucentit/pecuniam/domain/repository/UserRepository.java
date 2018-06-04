package com.lucentit.pecuniam.domain.repository;

import com.lucentit.pecuniam.domain.model.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User returnByUsernameAndPassword(String userName, String password);    
}
