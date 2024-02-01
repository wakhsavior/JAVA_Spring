package net.ddns.wakh.HomeWork.controllers;

import net.ddns.wakh.HomeWork.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    RegistrationService service;

}
