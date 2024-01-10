/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mkl.mybatisrep.utils;

/**
 *
 * @author agung
 */
import java.util.Collection;
import java.util.Iterator;

/**
 * Useful String utilities.
 * 
 * @author BalusC
 * @link http://balusc.blogspot.com/2006/10/stringutil.html
 */
public final class StringUtil {

    // Init ---------------------------------------------------------------------------------------

    /** Argument for <tt>StringUtil#pad()</tt>, set the pad direction to LEFT. */
    public static final int PAD_LEFT = -1;

    /** Argument for <tt>StringUtil#pad()</tt>, set the pad direction to BOTH. */
    public static final int PAD_BOTH = 0;

    /** Argument for <tt>StringUtil#pad()</tt>, set the pad direction to RIGHT. */
    public static final int PAD_RIGHT = 1;

    private StringUtil() {
        // Utility class, hide the constructor.
    }

    // Actions ------------------------------------------------------------------------------------

    /**
     * Pad the given string with the given pad value to the given length in the given direction.
     * Valid directions are <tt>StringUtil.PAD_LEFT</tt>, <tt>StringUtil.PAD_BOTH</tt> and
     * <tt>StringUtil.PAD_RIGHT</tt>. When using <tt>StringUtil.PAD_BOTH</tt>, padding left
     * has precedence over padding right when difference between string's length and the given
     * length is odd.
     * @param string The string to be padded.
     * @param pad The value to pad the given string with.
     * @param length The length to pad the given string to.
     * @param direction The direction to pad the given string to.
     * @return The padded string.
     * @throws IllegalArgumentException If invalid direction is given.
     */
    public static String pad(String string, String pad, int length, int direction)
        throws IllegalArgumentException {
        StringBuilder builder = new StringBuilder(string);

        switch (direction) {
            case PAD_LEFT:
                while (builder.length() < length) {
                    builder.insert(0, pad);
                }
                break;

            case PAD_RIGHT:
                while (builder.length() < length) {
                    builder.append(pad);
                }
                break;

            case PAD_BOTH:
                int right = (length - builder.length()) / 2 + builder.length();
                while (builder.length() < right) {
                    builder.append(pad);
                }
                while (builder.length() < length) {
                    builder.insert(0, pad);
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid direction, must be one of"
                    + " StringUtil.PAD_LEFT, StringUtil.PAD_BOTH or StringUtil.PAD_RIGHT.");
        }

        return builder.toString();
    }

    /**
     * Trim the given string with the given trim value.
     * @param string The string to be trimmed.
     * @param trim The value to trim the given string off.
     * @return The trimmed string.
     */
    public static String trim(String string, String trim) {
        if (trim.length() == 0) {
            return string;
        }

        int start = 0;
        int end = string.length();
        int length = trim.length();

        while (start + length <= end && string.substring(start, start + length).equals(trim)) {
            start += length;
        }
        while (start + length <= end && string.substring(end - length, end).equals(trim)) {
            end -= length;
        }

        return string.substring(start, end);
    }

    /**
     * Join the given collection with the given join value.
     * @param collection The collection (List, Set) to be joined.
     * @param join The value to be joined between each part.
     * @return The joined collection.
     */
    public static String join(Collection<?> collection, String join) {
        StringBuilder builder = new StringBuilder();

        for (Iterator<?> iter = collection.iterator(); iter.hasNext();) {
            builder.append(iter.next());

            if (iter.hasNext()) {
                builder.append(join);
            }
        }

        return builder.toString();
    }

    /**
     * Join the given ordinary array with the given join value.
     * @param objects The ordinary array (String[], Integer[], etc) to be joined.
     * @param join The value to be joined between each part.
     * @return The joined array.
     */
    public static String join(Object[] objects, String join) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < objects.length;) {
            builder.append(objects[i]);

            if (++i < objects.length) {
                builder.append(join);
            }
        }

        return builder.toString();
    }

    /**
     * Decapitalize the given string. The first character will be lowercased.
     * @param string The string to decapitalize.
     * @return The decapitalized string.
     */
    public static String decapitalize(String string) {
        if (string.length() == 0) {
            return string;
        }
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    /**
     * Check if given string is a number. It should contain digits only.
     * @param string The string to check on.
     * @return True if string is a number. False if not.
     */
    public static boolean isNumber(String string) {
        return string.matches("^\\d+$");
    }

    /**
     * Check if given string is numeric. Positive and negative prefix and dot separators are
     * allowed.
     * @param string The string to check on.
     * @return True if string is numeric. False if not.
     */
    public static boolean isNumeric(String string) {
        return string.matches("^[-+]?\\d+(\\.\\d+)?$");
    }

    /**
     * Check if given string is a valuta. The dot separator and two decimals are required.
     * @param string The string to check on.
     * @return True if string is valuta. False if not.
     */
    public static boolean isValuta(String string) {
        return string.matches("^\\d+\\.\\d{2}$");
    }

    /**
     * Check if given string contains numbers.
     * @param string The string to check on.
     * @return True if string contains numbers. False if not.
     */
    public static boolean hasNumbers(String string) {
        return string.matches("^.*\\d.*$");
    }

    /**
     * Check if given string is a valid email address. This confirms the RFC822 & RFC1035
     * specifications.
     * @param string The string to check on.
     * @return True if string is an valid email address. False if not.
     */
    public static boolean isEmailAddress(String string) {
        return string.toLowerCase().matches(
            "^[a-z0-9-~#&\\_]+(\\.[a-z0-9-~#&\\_]+)*@([a-z0-9-]+\\.)+[a-z]{2,5}$");
    }

    /**
     * Remove any XSS (Cross Site Scripting) vulrenabilities from the given string.
     * @param string The string to remove XSS from.
     * @return The string with removed XSS, if any.
     */
    
    public static String removeXss(String string) {
        return string
            .replaceAll("(?i)<script.*?>.*?</script.*?>", "") // Remove all <script> tags.
            .replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "") // Remove tags with javascript: call.
            .replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", ""); // Remove tags with on* attributes.
    }
    
     public static String insertStr(String c, String s, int i) {
        String strpot = s.substring(i - 1);
        String strawal = s.substring(0, i - 1);
        StringBuffer gabung = new StringBuffer();
        gabung.append(strawal).append(c).append(strpot);
        return gabung.toString();
    }
    
    public static String AddThousandSeparator(String S, String c) {
        int i;
        String str = S;
        String strmin = "";
        if (str.startsWith("-") == true) {
            str = S.replace("-", "");
            strmin = "-";
        }
        i = str.length() - 2;
        while (i > 1) {
            str = insertStr(c, str, i);
            i = i - 3;
        }
        return strmin + "" + str;
    }
}