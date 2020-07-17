package com.test.tank.state;

public enum RoleTypeEnum {
    
    
    
    ENEMY(0,"敌人"),TEAMER(1,"队友"),SELF(2,"自己"),BARRIER(3,"障碍物");


    
    private  String  name;
    private  int  code;
    RoleTypeEnum(int i, String name) {
        this.code=i;
        this.name=name;
    }
    
    
    
}
