package com.greene.controller;

import com.greene.services.SortingService;
import com.greene.util.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sort")
public class sortingController {

    @Autowired
    private SortingService sortingService;

    @GetMapping("/")
    public String test() {
        return "index";
    }

    @GetMapping("/bubble/{list}")
    public List<List<Node>> bubbleSort(@PathVariable List<Integer> list) {
        return sortingService.bubbleSortNodes(list);
    }

    @GetMapping("/selection/{list}")
    public List<List<Node>> selectionSort(@PathVariable List<Integer> list) {
        return sortingService.selectionSortNodes(list);
    }
}
