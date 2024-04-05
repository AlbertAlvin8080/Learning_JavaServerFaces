package org.example.flow_builder;

import jakarta.enterprise.inject.Produces;
import jakarta.faces.flow.Flow;
import jakarta.faces.flow.builder.FlowBuilder;
import jakarta.faces.flow.builder.FlowBuilderParameter;
import jakarta.faces.flow.builder.FlowDefinition;

import java.io.Serializable;

public class RegistrationFlowBuilderBean implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "registration-annotation";
        flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/registration-annotation/registration-annotation.xhtml")
                .markAsStartNode();
        flowBuilder.viewNode(flowId, "/registration-annotation/registration-annotation2.xhtml");
        flowBuilder.viewNode(flowId, "/registration-annotation/registration-annotation3.xhtml");
        flowBuilder.returnNode("exitToBegin").fromOutcome("/index.xhtml");
        flowBuilder.finalizer("#{registrationAnnotationBean.save()}");

        flowBuilder.flowCallNode("callAnnotationPendencies")
                .flowReference("", "pendencies-annotation")
                .outboundParameter("name", "#{registrationAnnotationBean.name}")
                .outboundParameter("surname", "#{registrationAnnotationBean.surname}");

        flowBuilder.switchNode("switchValidate")
                .defaultOutcome(flowId)
                .switchCase()
                .condition("#{not empty registrationAnnotationBean.name and not empty registrationAnnotationBean.surname}")
                .fromOutcome("registration-annotation2");

        return flowBuilder.getFlow();
    }
}
