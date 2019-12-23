package utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil
{
  public static String getPingYin(String inputString)
  {
    HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    format.setVCharType(HanyuPinyinVCharType.WITH_V);
    char[] input = inputString.trim().toCharArray();
    String output = "";
    try
    {
      char[] arrayOfChar1;
      int j = (arrayOfChar1 = input).length;
      for (int i = 0; i < j; i++)
      {
        char curchar = arrayOfChar1[i];
        if (Character.toString(curchar).matches("[\\u4E00-\\u9FA5]+"))
        {
          String[] temp = PinyinHelper.toHanyuPinyinStringArray(curchar, format);
          output = output + temp[0];
        }
        else
        {
          output = output + Character.toString(curchar);
        }
      }
    }
    catch (BadHanyuPinyinOutputFormatCombination e)
    {
      e.printStackTrace();
    }
    return output;
  }
}
