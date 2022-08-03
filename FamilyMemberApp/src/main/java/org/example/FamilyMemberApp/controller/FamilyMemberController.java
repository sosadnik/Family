package org.example.FamilyMemberApp.controller;

import lombok.RequiredArgsConstructor;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberDto;
import org.example.FamilyMemberApp.service.FamilyMemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class FamilyMemberController {

    private final FamilyMemberService service;

    @PostMapping("/createFamilyMember")
    public void createFamilyMember(@RequestBody FamilyMemberDto familyMemberDto){
        service.saveFamilyMember(familyMemberDto);
    }
}
