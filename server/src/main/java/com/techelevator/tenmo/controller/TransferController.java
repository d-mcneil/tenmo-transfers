package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "api/users/{userId}/accounts/{accountId}/transfers")
public class TransferController {

  //  @RequestMapping (path = "/users", method = RequestMethod.GET)
    //public List<User> getValidUsers()
}
