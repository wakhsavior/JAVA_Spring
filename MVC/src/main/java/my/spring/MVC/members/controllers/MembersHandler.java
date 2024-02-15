package my.spring.MVC.members.controllers;

import my.spring.MVC.models.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersHandler {
    private static List<Member> members = new ArrayList<>();
    @GetMapping("")
    public String toMembers(Model model) {
        model.addAttribute("members",members);

        return "members/members";
    }
    @GetMapping("/new_member")
    public String toAddMember(Model model){return "members/new_member";}
    @PostMapping("/new_member/create")
    public String createMember(@RequestParam String firstName, @RequestParam String lastName, Model model){
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        members.add(new Member(firstName,lastName));
        System.out.printf("First name %s; Last name %s\n",firstName,lastName);
        return "redirect:/members";
//        return "members/members";
    }
}
