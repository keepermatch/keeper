package com.codepath.keeper.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewlent on 11/10/16.
 */

public class VouchResponse {

    public List<Vouch> vouches;

    public VouchResponse() {
        vouches = new ArrayList<Vouch>();
    }

}
