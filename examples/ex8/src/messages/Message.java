package messages;

import java.io.Serializable;

/**
 * Created by denis.selutin on 6/18/2015.
 */
public class Message implements Serializable{
    private Header header;
    private Object message;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public static enum Type {
        REGISTRATION, MESSAGE, ADDRESSES_REQUEST, GET_MY_MESSAGES;
    }

    public String toString() {
        return "header = [" + this.header.toString() + "], message = [" + this.message + "]";
    }

    public static class Header  implements Serializable {
        private String headerAttributes;
        private Type type;
        private Integer destinationKey;
        private Integer senderKey;

        public String getHeaderAttributes() {
            return headerAttributes;
        }

        public void setHeaderAttributes(String headerAttributes) {
            this.headerAttributes = headerAttributes;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public Integer getDestinationKey() {
            return destinationKey;
        }

        public void setDestinationKey(Integer destinationKey) {
            this.destinationKey = destinationKey;
        }

        public Integer getSenderKey() {
            return senderKey;
        }

        public void setSenderKey(Integer senderKey) {
            this.senderKey = senderKey;
        }

        public String toString() {
            return "type = ["
                    + this.type
                    + "], destinationKey = ["
                    + this.destinationKey
                    + "], senderKey = ["
                    + this.senderKey
                    + "], headerAttributes = ["
                    + this.headerAttributes
                    + "]";
        }
    }
}
