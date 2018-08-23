package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandingConfig {

    String opusBannerUrl;

    String profileBannerUrl;

    String pdfBannerUrl;

    String pdfBackBannerUrl;

    List<Logo> logos;

    String thumbnailUrl;

    String colourTheme;

    String issn;

    String shortLicense;

    String pdfLicense;
}
