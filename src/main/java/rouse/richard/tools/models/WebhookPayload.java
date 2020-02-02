package rouse.richard.tools.models;

import lombok.Data;

@Data
public class WebhookPayload {
    private String zen;
    private int hook_id;
    private Hook hook;
}

