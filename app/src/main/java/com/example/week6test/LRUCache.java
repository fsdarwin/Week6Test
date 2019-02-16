package com.example.week6test;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    static Deque<Integer> intDq;
    static HashSet<Integer> map;
    static int casheSize;

    private LRUCache(int size) {
        intDq = new LinkedList<>();
        map = new HashSet<>();
        casheSize = size;
    }

    public void input(int x) {
        if (!map.contains(x)) {
            if (intDq.size() == casheSize) {
                int last = intDq.removeLast();
            }
        } else {
            int index = 0;
            int i = 0;
            Iterator<Integer> iter = intDq.iterator();
            while (iter.hasNext()) {
                if (iter.next() == x) {
                    index = i;
                    break;
                }
                i++;
            }
            intDq.remove(index);
        }
        intDq.push(x);
        map.add(x);
    }
    public void display(){
        Iterator<Integer> iter = intDq.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(4);
        lruCache.input(1);
        lruCache.input(2);
        lruCache.input(5);
        lruCache.input(6);
        lruCache.input(1);
        lruCache.input(4);
        lruCache.input(5);
        lruCache.input(3);
        lruCache.input(3);
        lruCache.input(1);
        lruCache.display();
    }
}
