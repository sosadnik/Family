package org.example.FamilyMemberApp.controller;

import lombok.RequiredArgsConstructor;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberRequest;
import org.example.FamilyMemberApp.controller.dto.FamilyMemberRespond;
import org.example.FamilyMemberApp.service.FamilyMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class FamilyMemberController {

    private final FamilyMemberService service;

    @PostMapping("/createFamilyMember")
    public HttpStatus createFamilyMember(@RequestBody FamilyMemberRequest familyMemberDto) {
        service.saveFamilyMember(familyMemberDto);
        return HttpStatus.OK;
    }



    @GetMapping("/getFamilyMember")
    public ResponseEntity<List<FamilyMemberRespond>> getFamilyMemberList(@RequestParam Long familyId){
        System.out.println(service.getFamilyMemberList(familyId));
        return ResponseEntity.ok()
                .body(service.getFamilyMemberList(familyId));
    }
}
