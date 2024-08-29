/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.antithesis.ffi.internal;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FfiWrapperJNI {



    private static final String NATIVE_LIBRARY_PATH = "/usr/lib/libvoidstar.so";

    public static boolean hasNativeLibrary() {
       return Files.exists(Paths.get(NATIVE_LIBRARY_PATH));
    }

    public static void loadLibrary() throws IOException {
        try {
            if (hasNativeLibrary()) {
                System.load(NATIVE_LIBRARY_PATH);
                File file = File.createTempFile("libFfiWrapper", ".so");
                try (InputStream link = (Thread.currentThread().getContextClassLoader().getResourceAsStream("libFfiWrapper.so"))){
                    Files.copy(
                        link,
                        file.getAbsoluteFile().toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                    System.load(file.getAbsoluteFile().toString());
                }
            } else {
                throw new RuntimeException("Failed to locate native code library");
            }
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load. \n" + e);
            throw e;
        }
    }

  public final static native long fuzz_get_random();
  public final static native void fuzz_json_data(String jarg1, long jarg2);
  public final static native void fuzz_flush();
  public final static native long init_coverage_module(long jarg1, String jarg2);
  public final static native boolean notify_coverage(long jarg1);
}
