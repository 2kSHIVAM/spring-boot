package com.learning.annotations.Annotations.Hateoas;

import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;

public class HateoasLinks {
    private List<Link> links = new ArrayList<>();
    public void addLink(Link link){
        links.add(link);
    }

    public List<Link> fetchLinks(){
        return links;
    }
}
