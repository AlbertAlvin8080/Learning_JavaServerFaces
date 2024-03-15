package org.example.customtags.client_behavior;

import jakarta.faces.component.behavior.ClientBehaviorBase;
import jakarta.faces.component.behavior.ClientBehaviorContext;
import jakarta.faces.component.behavior.FacesBehavior;

@FacesBehavior(value = "confirmDelete")
public class ConfirmDeleteBehavior extends ClientBehaviorBase {
    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        return "return confirm('Are you sure?');";
    }
}
