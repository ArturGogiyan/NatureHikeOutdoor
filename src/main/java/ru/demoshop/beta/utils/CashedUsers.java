package ru.demoshop.beta.utils;

import ru.demoshop.beta.dataBaseInterface.DTO.CommonUSerData;

import java.util.HashMap;
import java.util.Map;

public class CashedUsers {
    private static HashMap<String, CommonUSerData> users;

    public static HashMap<String, CommonUSerData> getUsers() {
        if(users==null){
            users = new HashMap<String, CommonUSerData>();
        }
        return users;
    }
}
