package au.org.ala.profiles.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapConfig {

    /*
        mapAttribution nullable: true
        mapPointColour nullable: true
        mapDefaultLatitude nullable: true
        mapDefaultLongitude nullable: true
        mapZoom nullable: true
        mapBaseLayer nullable: true
        biocacheUrl nullable: true
        biocacheName nullable: true
        maxZoom nullable: true
        maxAutoZoom nullable: true
     */

    String mapAttribution;

    String mapPointColour;

    Float mapDefaultLatitude;

    Float mapDefaultLongitude;

    Integer mapZoom;

    String mapBaseLayer;

    String biocacheUrl;

    String biocacheName;

    Integer maxZoom;

    Integer maxAutoZoom;

    boolean autoZoom;

    boolean allowSnapshots;
}
