package com.greene.services;

import com.greene.util.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    public List<List<Node>> bubbleSort(List<Integer> unsorted) {
        boolean isSorted;
        List<Node> nodeList = convertToNodes(unsorted);
        List<List<Node>> steps = new ArrayList<>();
        steps.add(nodeList);
        nodeList = copyNodeList(nodeList);

        do {
            isSorted = true;
            for (int i=0; i<nodeList.size()-1; i++) {
                if (nodeList.get(i).getValue() > nodeList.get(i+1).getValue()) {
                    isSorted = false;

                    Node tmp = nodeList.remove(i+1);
                    tmp.setChanged(true);
                    nodeList.get(i).setChanged(true);
                    nodeList.add(i, tmp);

                    break;
                }
            }

            if (!isSorted) {
                steps.add(nodeList);
                nodeList = copyNodeList(nodeList);
            }

        } while (!isSorted);

        return steps;
    }

    public List<List<Node>> selectionSort(List<Integer> unsorted) {
        List<Node> nodeList = convertToNodes(unsorted);
        List<List<Node>> steps = new ArrayList<>();
        steps.add(nodeList);
        nodeList = copyNodeList(nodeList);

        for (int i=0; i<nodeList.size()-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<nodeList.size(); j++) {
                if (nodeList.get(j).getValue() < nodeList.get(minIndex).getValue()) {
                    minIndex = j;
                }
            }
            Node tmp = nodeList.remove(minIndex);
            tmp.setChanged(true);
            nodeList.get(i).setChanged(true);
            nodeList.add(i, tmp);

            steps.add(nodeList);
            nodeList = copyNodeList(nodeList);
        }

        return steps;
    }

    private List<Node> copyNodeList(List<Node> nodeList) {
        List<Node> copy = new ArrayList<>();

        for (Node n : nodeList) {
            copy.add(new Node(n));
        }

        return copy;
    }

    private List<Node> convertToNodes(List<Integer> intList) {
        List<Node> nodeList = new ArrayList<>();

        for (int i : intList) {
            nodeList.add(new Node(i));
        }

        return nodeList;
    }

}
