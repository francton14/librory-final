/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcl.librory.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author franc.margallo
 */
public class DateUtils {
    
    private static final String PATTERN = "MM-dd-yyyy";
    
    public static String toString(Date date) {
	return new SimpleDateFormat(PATTERN).format(date);
    }
    
    public static Date toDate(String date) throws ParseException {
	return new SimpleDateFormat(PATTERN).parse(date);
    }
    
}
