package pl.coderslab.app.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Errors {

    private String path;
    private String message;
}