package practiceproblem.convertjavaobjectintojsonformat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty
    private String modal;
    @JsonProperty
    private String engine;

    public Car() {}

    @JsonCreator
    public Car(@JsonProperty("modal")  String modal, @JsonProperty("engine") String engine) {
        this.modal = modal;
        this.engine = engine;
    }

}
