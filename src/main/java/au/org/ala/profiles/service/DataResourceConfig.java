package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResourceConfig {

    DataResourceOption recordResourceOption = DataResourceOption.NONE;
    DataResourceOption imageResourceOption = DataResourceOption.NONE;
    List<String> imageSources = new ArrayList<>();
    List<String> recordSources = new ArrayList<>();
    List<String> privateRecordSources = new ArrayList<>();
}
