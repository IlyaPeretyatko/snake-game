package org.nsu.networks.exceptions;

import lombok.Getter;

@Getter
public class WrongSettingsException extends Exception {
    private final String header;
    private final String content;

    public WrongSettingsException(String header, String content) {
        this.header = header;
        this.content = content;
    }

}
