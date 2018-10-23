package com.greene.services;

import com.greene.util.Node;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    public List<List<Integer>> bubbleSort(List<Integer> unsorted) {
        boolean isSorted;
        List<Integer> localList = new ArrayList<>(unsorted);
        List<List<Integer>> stepsList = new ArrayList<>();

        do {
            isSorted = true;
            for (int i=0; i<localList.size()-1; i++) {
                if (localList.get(i) > localList.get(i+1)) {
                    isSorted = false;
                    int tmp = localList.remove(i+1);
                    localList.add(i, tmp);
                    stepsList.add(new ArrayList<>(localList));
                }
            }
        } while (!isSorted);

        return stepsList;
    }

    public List<List<Node>> bubbleSortNodes(List<Integer> unsorted) {
        boolean isSorted;
        List<Node> nodeList = convertToNodes(unsorted);
        List<List<Node>> steps = new ArrayList<>();

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

    public List<List<Integer>> selectionSort(List<Integer> unsorted) {
        List<List<Integer>> steps = new ArrayList<>();

        for (int i=0; i<unsorted.size()-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<unsorted.size(); j++) {
                if (unsorted.get(j) < unsorted.get(minIndex)) {
                    minIndex = j;
                }
            }
            int tmp = unsorted.remove(minIndex);
            unsorted.add(i, tmp);
            steps.add(new ArrayList<>(unsorted));
        }

        return steps;
    }

    public List<List<Node>> selectionSortNodes(List<Integer> unsorted) {
        List<Node> nodeList = convertToNodes(unsorted);
        List<List<Node>> steps = new ArrayList<>();

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
