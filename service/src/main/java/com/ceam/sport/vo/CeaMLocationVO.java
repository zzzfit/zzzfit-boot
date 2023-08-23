package com.ceam.sport.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CeaM
 * 2023/02/22 10:51
 **/
@Data
public class CeaMLocationVO {

    private Long id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Markers> markers = new LinkedList<>();

    public List<Markers> newMarkers(Long id,
                               BigDecimal latitude,
                               BigDecimal longitude,
                               Label label,
                               Callout callout) {
        Markers markersEntiry = new Markers();
        markersEntiry.setId(id);
        markersEntiry.setLatitude(latitude);
        markersEntiry.setLongitude(longitude);
        markersEntiry.setLabel(label);
        markersEntiry.setCallout(callout);
        this.markers.add(markersEntiry);
        return markers;
    }

    public Label newLabel(String content) {
        Label label = new Label();
        label.setContent(content);
        return label;
    }

    public Callout newCallout(String content) {
        Callout callout = new Callout();
        callout.setContent(content);
        return callout;
    }
}

@Data
class Markers {
    private Long id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String iconPath = "../../static/images/location64.png";
    private Label label;
    private Callout callout;
}

/**
 * 直接显示
 */
@Data
class Label {
    private String content;
    private String color = "green";
    private Integer fontSize = 20;
    private Integer x = -90;
    private Integer y = -71;
    private Integer borderWidth = 3;
    private Integer borderRadius = 20;
    private String borderColor = "limegreen";
    private Integer padding = 5;
}

/**
 * 点击显示与隐藏
 */
@Data
class Callout {
    private String content;
    private String color = "green";
    private Integer fontSize = 20;
}


