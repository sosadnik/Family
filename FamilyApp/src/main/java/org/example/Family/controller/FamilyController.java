package org.example.Family.controller;

import lombok.RequiredArgsConstructor;
import org.example.Family.controller.dto.FamilyDto;
import org.example.Family.service.FamilyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/CreateFamily")
    public ResponseEntity<Long> createFamily(@RequestBody FamilyDto request){
        return ResponseEntity.ok()
                .body(familyService.createFamily(request));
    }
}
