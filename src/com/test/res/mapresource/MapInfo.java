package com.test.res.mapresource;

/**
 * Desc:
 *
 * @author wulei19922@gmail.com
 * create:2020/7/17
 **/

public class MapInfo {
  public   int widht;
    public   int heiht;
    public int x;
    public  int y;
    public String name;


    public MapInfo setWidht(int widht) {
        this.widht = widht;
        return this;
    }

    public MapInfo setHeiht(int heiht) {
        this.heiht = heiht;
        return this;
    }

    public MapInfo setX(int x) {
        this.x = x;
        return this;
    }

    public MapInfo setY(int y) {
        this.y = y;
        return this;
    }

    public MapInfo setName(String name) {
        this.name = name;
        return this;
    }
}
