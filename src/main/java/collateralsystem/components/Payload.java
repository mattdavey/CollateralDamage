package collateralsystem.components;

public class Payload {
    public enum PayloadType {CSA};

    private final PayloadType dataType;
    private final String data;

    public Payload(final PayloadType dataType, final String data) {
        this.dataType = dataType;
        this.data = data;
    }

    public PayloadType getPayloadType() {
        return dataType;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", dataType.toString(), data);
    }
}
