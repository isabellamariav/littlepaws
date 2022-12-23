package nl.vet.littlepaws.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class FileInfo {

    @NotNull(message = "Name of the file cannot be null. ")
    private String name;
    private String url;
}
