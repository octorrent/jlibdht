package org.sectorrent.jlibdht.messages.inter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Message {

    String method();

    MessageType type();
}
