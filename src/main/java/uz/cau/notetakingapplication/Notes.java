package uz.cau.notetakingapplication;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notes {
    private String title;
    private String description;
    private int priority;
    private String time;

}
