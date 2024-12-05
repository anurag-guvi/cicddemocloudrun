package com.example.crdemo.controller;


import com.example.crdemo.model.Branch;
import com.example.crdemo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/all")
    public List<Branch> getAllBranches() {
        return branchService.getBranches();
    }
}