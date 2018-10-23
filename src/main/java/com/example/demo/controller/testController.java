package com.example.demo.controller;

import com.example.demo.Node;
import com.example.demo.services.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private SortingService sortingService;

    @GetMapping("/")
    public String test() {
        return "index";
    }

    @GetMapping("/bubble-sort/{list}")
    public List<List<Node>> bubbleSort(@PathVariable List<Integer> list) {
        return sortingService.bubbleSortNodes(list);
    }

    @GetMapping("/selection-sort/{list}")
    public List<List<Node>> selectionSort(@PathVariable List<Integer> list) {
        return sortingService.selectionSortNodes(list);
    }
}
