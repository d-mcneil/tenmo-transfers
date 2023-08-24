package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "api/transfers/")
public class TransferController {

    private final UserDao userDao;
    private final TransferDao transferDao;

    public TransferController(UserDao userDao, TransferDao transferDao) {
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    @RequestMapping(path = "{transferId}", method = RequestMethod.GET)
    public Transfer get(@PathVariable int transferId) {
        Transfer transfer = transferDao.getTransferById(transferId);
        if (transfer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transfer not found");
        }
        return transfer;
    }

    @RequestMapping(path = "users/{userId}", method = RequestMethod.GET)
    public List<TransferUsersResponse> getUsersThatCanBeTransferredTo(Principal principal) {
        List<TransferUsersResponse> usersToTransferTo = new ArrayList<>();

        String username = principal.getName();
        List<User> users = userDao.findAll();
        for (User user : users) {
            if (!user.getUsername().equals(username)) {
                usersToTransferTo.add(new TransferUsersResponse(user.getUsername()));
            }
        }

        return usersToTransferTo;
    }

    // TODO add transfer method
    public Transfer addTransfer(@Valid @RequestBody Transfer transfer) {

    }

    // TODO: ask jeremy if there is a better way to handle this problem (returning too much info)
    static class TransferUsersResponse {
        String username;

        public TransferUsersResponse(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }


}
