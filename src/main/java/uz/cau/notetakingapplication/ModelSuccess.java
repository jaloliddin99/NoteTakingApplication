package uz.cau.notetakingapplication;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModelSuccess {

    private Boolean success;
    private String message;
    private Object data;

}
