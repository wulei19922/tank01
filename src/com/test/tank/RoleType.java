package com.test.tank;

public enum RoleType {
    
    
    
    ENEMY(0,"敌人"),TEAMER(1,"队友"),SELF(2,"自己");


    
    private  String  name;
    private  int  code;
    RoleType(int i, String name) {
        this.code=i;
        this.name=name;
    }
    
    
    
}
