package org.example.sjindividuellainlamning.controllers;

import org.example.sjindividuellainlamning.entities.Member;
import org.example.sjindividuellainlamning.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

// POSTMAN -------------------------------------------------------------------------------------------------------------

    @PostMapping("/addmember")
    public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") int id) {
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMembers() {
        return new ResponseEntity<>(memberService.getMembers(), HttpStatus.OK);
    }

    @PutMapping("/updatemember/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") int id, @RequestBody Member member) {
        return new ResponseEntity<>(memberService.updateMember(id, member), HttpStatus.OK);
    }

    @DeleteMapping("/deletemember/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable("id") int id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>("Member with id: " + id + " was deleted.", HttpStatus.OK);
    }

// THYMELEAF -----------------------------------------------------------------------------------------------------------

    @GetMapping("/deletemember")
    public String showMemberList(Model model) {
        model.addAttribute("members", memberService.getMembers());
        return "deletemember";
    }

    @GetMapping("/deletememberbyid/{id}")
    public String deleteMemberById(@PathVariable("id") int id) {
        memberService.deleteMember(id);
        return "redirect:/admin/deletemember";
    }

}
