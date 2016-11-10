package com.codepath.keeper.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewlent on 11/10/16.
 */

public class VouchResponse {

    // instance vars
    private List<Vouch> vouches;

    // constructors
    public VouchResponse() {
        vouches = new ArrayList<Vouch>();
    }

    // getters and setters
    public List<Vouch> getVouches() {
        return vouches;
    }

    public void setVouches(List<Vouch> vouches) {
        this.vouches = vouches;
    }



}
