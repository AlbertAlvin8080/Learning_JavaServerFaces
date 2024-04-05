package org.example.flow_builder;

import jakarta.enterprise.inject.Produces;
import jakarta.faces.flow.Flow;
import jakarta.faces.flow.builder.FlowBuilder;
import jakarta.faces.flow.builder.FlowBuilderParameter;
import jakarta.faces.flow.builder.FlowDefinition;

import java.io.Serializable;

public class PendenciesFlowBuilderBean implements Serializable {
    @Produces
    @FlowDefinition
    public Flow defineFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "";
        flowBuilder.id("", "pendencies-annotation");
        flowBuilder.viewNode(flowId, "/pendencies-annotation/pendencies-annotation.xhtml")
                .markAsStartNode();

        flowBuilder.inboundParameter("name", "#{pendenciesAnnotationBean.name}");
        flowBuilder.inboundParameter("surname", "#{pendenciesAnnotationBean.surname}");

        flowBuilder.returnNode("continueAnnotationRegistration")
                .fromOutcome("/registration-annotation/registration-annotation3.xhtml");
        flowBuilder.returnNode("cancelRegistration")
                .fromOutcome("/registration-annotation/registration-annotation.xhtml");

        return flowBuilder.getFlow();
    }
}
