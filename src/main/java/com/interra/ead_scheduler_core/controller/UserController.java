package com.interra.ead_scheduler_core.controller;

import java.util.List;

import com.interra.ead_scheduler_core.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.interra.ead_scheduler_core.response.ESResponse;
import com.interra.ead_scheduler_core.response.ResponseParams;

@RestController
public class UserController extends Controller {
 
    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ResponseEntity<ESResponse> listAllUsers() {
        ESResponse result;
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        result=ResponseParams.buildSuccess(users);
        return ResponseEntity.ok().body(result);
    }
    
    
}