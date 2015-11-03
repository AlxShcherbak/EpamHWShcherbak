package com.ua.processor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AlxEx on 30.10.2015.
 */
public class Reader {
    public String readFile(String link) {
        String content = null;
        File file = new File(link); //for ex foo.txt "dataSourse/Ulukomoriya"
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);

            int charsNotNull = 0,
                    counter = 0;      //количество символов не != '\u0000'
            for (char charBuff : chars) {
                if (charBuff != '\u0000' && charBuff !='\r') {
                    charsNotNull++;
                }
            }
            char[] charsReturn = new char[charsNotNull];
            for (char charBuff : chars) {
                if (charBuff != '\u0000' && charBuff !='\r') {
                    charsReturn[counter++] = charBuff;
                }
            }
            reader.close();

            content = new String(charsReturn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
