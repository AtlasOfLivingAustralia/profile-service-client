package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theme {

    String mainBackgroundColour;

    String mainTextColour;

    String callToActionHoverColour;

    String callToActionColour;

    String callToActionTextColour;

    String footerBackgroundColour;

    String footerTextColour;

    String footerBorderColour;

    String headerTextColour;

    String headerBorderColour;
}
