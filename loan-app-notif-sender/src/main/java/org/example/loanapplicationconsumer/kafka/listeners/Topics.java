package org.example.loanapplicationconsumer.kafka.listeners;

public enum Topics {
    MY_TOPIC("my-topic");

    private final String topicName;

    Topics(String topicName) {
        this.topicName = topicName;

    }

    @Override
    public String toString() {
        return topicName;
    }

}
