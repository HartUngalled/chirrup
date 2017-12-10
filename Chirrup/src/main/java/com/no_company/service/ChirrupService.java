package com.no_company.service;

import com.no_company.model.PostsEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;


public class ChirrupService {

    private static ChirrupService _instance;
    private List<PostsEntity> chrips;

    private ChirrupService() {
        chrips = new ArrayList<>();
    }

    /**
     * return singleton instance
     */
    public static ChirrupService getInstance() {
        if (_instance==null) _instance = new ChirrupService();
        return _instance;
    }

    

}