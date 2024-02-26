package ru.gb.MyRickAndMortyAPI.model;

import lombok.Data;

@Data
public class Info {
    private int count;
    private int pages;
    private String next;
    private String prev;

    @Override
    public String toString() {
        return "Info{" +
                "count=" + count +
                ", pages=" + pages +
                ", next='" + next + '\'' +
                ", prev='" + prev + '\'' +
                '}';
    }
}
