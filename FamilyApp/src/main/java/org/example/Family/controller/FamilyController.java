package org.example.Family.controller;

import lombok.RequiredArgsConstructor;
import org.example.Family.controller.dto.FamilyRequest;
import org.example.Family.controller.dto.FamilyRespond;
import org.example.Family.service.FamilyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class FamilyController {

    private final FamilyService familyService;

    @PostMapping("/CreateFamily")
    public ResponseEntity<Long> createFamily(@RequestBody FamilyRequest request){
        return ResponseEntity.ok()
                .body(familyService.createFamily(request));
    }

    @GetMapping("/GetFamily")
    public ResponseEntity<FamilyRespond> getFamily(@RequestParam Long familyId){
       return ResponseEntity.ok()
               .body(familyService.getFamily(familyId));
    }
}
