package com.weon.DAO;

import com.weon.Model.Email;

public interface EmailDAO {
    void consumeEmail(Email email);
}