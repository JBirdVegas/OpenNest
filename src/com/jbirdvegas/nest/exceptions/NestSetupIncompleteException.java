package com.jbirdvegas.nest.exceptions;

import java.io.IOException;

/**
 * Created by jbird: 3/18/14
 */
public class NestSetupIncompleteException extends Throwable {
    public NestSetupIncompleteException(String s) {
        super(s);
        System.out.println(s);
    }

    public NestSetupIncompleteException(IOException e) {
        super(e);
    }
}
