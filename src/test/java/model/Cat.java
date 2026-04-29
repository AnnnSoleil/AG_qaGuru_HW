package model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    @JsonProperty("object")
    public String objectCat;
    @JsonProperty("name")
    public String nameCat;
    @JsonProperty("age")
    public int ageCat;
    @JsonProperty("skills")
    public List<String> skillsCat;
    public Address address;
}
