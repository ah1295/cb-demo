package com.cb.demo.service;

import com.cb.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserPoller {

    @Autowired
    private UserService userService;

    @Scheduled(fixedRate = 5000)
    public void pollDB(){
        log.info("polling database");
        List<User> users = userService.findByProcessedFalse();
        users.forEach(this::processUser);
    }

    @Transactional
    private void processUser(User user){
        if(user.getProcessed()){
            log.info("user " + user.getName() + " already processed");
            return;
        }
        log.info("processing user : " + user.getName());
        user.setProcessed(true);
        userService.save(user);
        log.info("processed user : " + user.getName());
    }
}
