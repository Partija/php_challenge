package com.coin58.api.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;


public class ZipUtil {

    public static String uncompress(byte[] input) throws IOException {
        Inflat