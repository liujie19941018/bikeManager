package com.aowin.service.impl;

import com.aowin.dao.IUserDao;
import com.aowin.model.User;
import com.aowin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public User getlogin(User user) throws Exception{
        return iUserDao.getlogin(user);
    }
}
