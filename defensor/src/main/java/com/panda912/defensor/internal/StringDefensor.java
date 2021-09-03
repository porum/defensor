package com.panda912.defensor.internal;

import android.text.TextUtils;

import com.panda912.defensor.CrashDefensor;
import com.panda912.defensor.ErrorCode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.IllegalFormatException;
import java.util.Locale;

/**
 * Created by panda on 2021/8/19 13:45
 */
public class StringDefensor {

  ////////////////////////////////// CharSequence //////////////////////////////////

  public static int length(CharSequence charSequence) {
    if (charSequence != null) {
      return charSequence.length();
    }
    CrashDefensor.onCrash(ErrorCode.NullPointerException, "CharSequence.length() throw NullPointerException", new NullPointerException("CharSequence.length() throw NullPointerException"));
    return 0;
  }

  public static char charAt(CharSequence charSequence, int index) {
    if (charSequence != null && index >= 0 && index < charSequence.length()) {
      return charSequence.charAt(index);
    }
    if (charSequence == null) {
      String error = "CharSequence.charAt(index) throw NullPointerException";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    } else {
      String error = "CharSequence.charAt(index) throw IndexOutOfBoundsException";
      CrashDefensor.onCrash(ErrorCode.IndexOutOfBoundsException, error, new IndexOutOfBoundsException("CharSequence.charAt(" + index + ") length " + charSequence.length() + " throw IndexOutOfBoundsException"));
    }
    return 0;
  }

  public static CharSequence subSequence(CharSequence charSequence, int start, int end) {
    if (TextUtils.isEmpty(charSequence)) {
      onSubSequenceCrash(charSequence, start, end);
      return "";
    } else if (start < 0) {
      onSubSequenceCrash(charSequence, start, end);
      return charSequence;
    } else if (end > charSequence.length()) {
      onSubSequenceCrash(charSequence, start, end);
      return charSequence;
    } else if (end - start >= 0) {
      return charSequence.subSequence(start, end);
    } else {
      onSubSequenceCrash(charSequence, start, end);
      return charSequence;
    }
  }

  private static void onSubSequenceCrash(CharSequence charSequence, int start, int end) {
    String error = "CharSequence.subSequence() throw IndexOutOfBoundsException";
    CrashDefensor.onCrash(ErrorCode.IndexOutOfBoundsException, error, new IndexOutOfBoundsException("CharSequence.subSequence(\"" + ((Object) charSequence) + "\"," + start + "," + end + ") throw IndexOutOfBoundsException"));
  }

  public static String toString(CharSequence charSequence) {
    if (charSequence != null) {
      return charSequence.toString();
    }
    String error = "CharSequence.toString() throw NullPointerException";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return "";
  }

  ////////////////////////////////// String static method //////////////////////////////////

  public static String format(String format, Object... args) {
    if (format == null) {
      return "";
    }
    try {
      return String.format(format, args);
    } catch (IllegalFormatException e) {
      CrashDefensor.onCrash(ErrorCode.IllegalArgumentException, "String.format(format,args) throw IllegalArgumentException", e);
      return "";
    }
  }

  public static String format(Locale locale, String format, Object... args) {
    if (format == null) {
      return "";
    }
    try {
      return String.format(locale, format, args);
    } catch (IllegalFormatException e) {
      CrashDefensor.onCrash(ErrorCode.IllegalArgumentException, "String.format(locale,format,args) throw IllegalArgumentException", e);
      return "";
    }
  }

  ////////////////////////////////// String //////////////////////////////////

  public static String substring(String str, int beginIndex) {
    if (!TextUtils.isEmpty(str) && beginIndex >= 0 && beginIndex <= str.length()) {
      return str.substring(beginIndex);
    }
    String msg = "String.substring(int beginIndex) throw IndexOutOfBoundsException";
    CrashDefensor.onCrash(ErrorCode.IndexOutOfBoundsException, msg, new IndexOutOfBoundsException("\"" + str + "\".substring(" + beginIndex + ") throw IndexOutOfBoundsException"));
    return str;
  }

  public static String substring(String str, int beginIndex, int endIndex) {
    if (TextUtils.isEmpty(str)) {
      onSubstringCrash(str, beginIndex, endIndex);
      return "";
    } else if (beginIndex < 0) {
      onSubstringCrash(str, beginIndex, endIndex);
      return str;
    } else if (endIndex > str.length()) {
      onSubstringCrash(str, beginIndex, endIndex);
      return str;
    } else if (endIndex - beginIndex >= 0) {
      return str.substring(beginIndex, endIndex);
    } else {
      onSubstringCrash(str, beginIndex, endIndex);
      return str;
    }
  }

  private static void onSubstringCrash(String str, int beginIndex, int endIndex) {
    String msg = "String.substring(int beginIndex, int endIndex) throw IndexOutOfBoundsException";
    CrashDefensor.onCrash(ErrorCode.IndexOutOfBoundsException, msg, new IndexOutOfBoundsException("\"" + str + "\".substring(" + beginIndex + "," + endIndex + ") throw IndexOutOfBoundsException"));
  }

  public static String trim(String str) {
    if (str != null) {
      return str.trim();
    }
    String error = "String.trim() throw NullPointerException";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return "";
  }

  public static int length(String str) {
    if (str != null) {
      return str.length();
    }
    String error = "String.length() throw NullPointerException";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return 0;
  }

  public static int lastIndexOf(String str, int ch) {
    if (str != null) {
      return str.lastIndexOf(ch);
    }
    String error = "String.lastIndexOf(int ch) throw NullPointerException";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return -1;
  }

  public static int lastIndexOf(String source, String target) {
    if (source != null && target != null) {
      return source.lastIndexOf(target);
    }
    String error = "String.lastIndexOf(String str) throw NullPointerException, due to " + (source == null ? "source" : "target") + " is null.";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return -1;
  }

  public static char[] toCharArray(String str) {
    if (str != null) {
      return str.toCharArray();
    }
    String error = "String.toCharArray() throw NullPointerException";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return "".toCharArray();
  }

  public static boolean equals(String str, Object obj) {
    if (str == null) {
      String error = "String.equals(Object anObject) throw NullPointerException";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return false;
    } else if (obj == null) {
      return false;
    } else {
      return str.equals(obj);
    }
  }

  public static boolean equalsIgnoreCase(String str, String anotherString) {
    if (str != null) {
      return str.equalsIgnoreCase(anotherString);
    }
    String error = "String.equalsIgnoreCase(String anotherString) throw NullPointerException";
    CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
    return false;
  }

  public static boolean startsWith(String str, String prefix) {
    if (str == null || prefix == null) {
      String error = "String.startWith(String prefix) throw NullPointerException, due to " + (str == null ? "str" : "prefix") + " is null.";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return false;
    }
    return str.startsWith(prefix);
  }

  public static boolean endsWith(String str, String suffix) {
    if (str == null || suffix == null) {
      String error = "String.endsWith(String suffix) throw NullPointerException, due to " + (str == null ? "str" : "suffix") + " is null.";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return false;
    }
    return str.endsWith(suffix);
  }

  public static byte[] getBytes(String str) {
    if (str == null) {
      String error = "String.getBytes() throw NullPointerException";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return null;
    }
    return str.getBytes();
  }

  public static byte[] getBytes(String str, String charsetName) throws UnsupportedEncodingException {
    if (str == null || charsetName == null) {
      String error = "String.getBytes(String charsetName) throw NullPointerException, due to " + (str == null ? "str" : "charsetName") + " is null.";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return null;
    }
    return str.getBytes(charsetName);
  }

  public static byte[] getBytes(String str, Charset charset) {
    if (str == null || charset == null) {
      String error = "String.getBytes(Charset charset) throw NullPointerException, due to " + (str == null ? "str" : "charset") + " is null.";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return null;
    }
    return str.getBytes(charset);
  }

  public static boolean matches(String str, String regex) {
    if (str == null || regex == null) {
      String error = "String.matches(String regex) throw NullPointerException, due to " + (str == null ? "str" : "regex") + " is null.";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return false;
    }
    return str.matches(regex);
  }

  public static boolean contains(String str, CharSequence s) {
    if (str == null || s == null) {
      String error = "String.contains(CharSequence s) throw NullPointerException, due to " + (str == null ? "str" : "s") + " is null.";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return false;
    }
    return str.contains(s);
  }

  public static boolean isEmpty(String str) {
    if (str == null) {
      String error = "String.isEmpty() throw NullPointerException";
      CrashDefensor.onCrash(ErrorCode.NullPointerException, error, new NullPointerException(error));
      return false;
    }
    return str.isEmpty();
  }

}
