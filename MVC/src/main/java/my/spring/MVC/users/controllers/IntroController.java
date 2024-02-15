package my.spring.MVC.users.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/intro",method = RequestMethod.GET)
public class IntroController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "intro/index";
    }
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(){
        return "intro/about";
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(){
        return "users";
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUsersById(@PathVariable("id") String id) {
        return "user id =  " + id;
    }
//    @ResponseBody
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String getUsersByParam(@RequestParam("id") String id) {
//        return "user id =  " + id;
//    }
    @ResponseBody
    @RequestMapping(value = {"/user","/student"},
            params = {"id","name"},
            method = RequestMethod.GET)
    public String getUsersByDifParam(@RequestParam("id") long id, @RequestParam("name") String name) {
        return String.format("user name = %s; id = %s", name,id );
    }



}
