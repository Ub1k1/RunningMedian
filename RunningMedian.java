package com.company;

import java.util.*;

public class RunningMedian {
    public double[] getMedians(int[] arr){
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>((a, b)->b-a);
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        double[] medians = new double[arr.length];
        for (int i = 0; i < arr.length; i++){
            addNumber(arr[i], lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }

    public void addNumber(int num, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if (lowers.size() == 0){
            lowers.add(num);
            return;
        }

        if (num <= lowers.peek()){
            lowers.add(num);
        }else{
            highers.add(num);
        }
    }

    public void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> smaller = lowers.size() <= highers.size()?lowers:highers;
        PriorityQueue<Integer> bigger = lowers.size() > highers.size()?lowers:highers;
        if (bigger.size() - smaller.size() >= 2){
            smaller.add(bigger.poll());
        }
    }

    public double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> smaller = lowers.size() <= highers.size()?lowers:highers;
        PriorityQueue<Integer> bigger = lowers.size() > highers.size()?lowers:highers;
        if (smaller.size() == bigger.size()){
            return ((double)(smaller.peek() + bigger.peek())/2);
        }else{
            return bigger.peek();
        }
    }
}
