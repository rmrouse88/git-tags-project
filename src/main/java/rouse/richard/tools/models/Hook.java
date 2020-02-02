package rouse.richard.tools.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Hook {
    private String type;
    private int id;
    private String name;
    private Boolean active;
    private List<String> events;
    private GitConfig config;
    private Date updated_at;
    private Date created_at;
    private String url;
    private String test_url;
    private String ping_url;
    private GitLastResponse lastResponse;
}
