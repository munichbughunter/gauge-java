package com.thoughtworks.gauge.processor;

import gauge.messages.Messages;
import gauge.messages.Spec;

public class DefaultMessageProcessor implements IMessageProcessor {
    @Override
    public Messages.Message process(Messages.Message message) {
        Messages.ExecutionStatusResponse.Builder response = Messages.ExecutionStatusResponse.newBuilder().setExecutionResult(Spec.ProtoExecutionResult.newBuilder().setFailed(false).setExecutionTime(0).build());

        return Messages.Message.newBuilder()
                .setMessageId(message.getMessageId())
                .setMessageType(Messages.Message.MessageType.ExecutionStatusResponse)
                .setExecutionStatusResponse(response)
                .build();
    }
}
