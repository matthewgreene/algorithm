package com.greene.controller;

import com.greene.services.SortingService;
import com.greene.util.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sort")
public class sortingController {

    @Autowired
    private SortingService sortingService;

    @GetMapping("/bubble/{list}")
    public List<List<Node>> bubbleSort(@PathVariable List<Integer> list) {
        return sortingService.bubbleSort(list);
    }

    @GetMapping("/selection/{list}")
    public List<List<Node>> selectionSort(@PathVariable List<Integer> list) {
        return sortingService.selectionSort(list);
    }
}
