package xyz.stankovic.nikola.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Greeting implements Serializable {
    private final long id;
    private final String content;
}
