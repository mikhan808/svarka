package com.example.mikhan808.svarka;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by МишаИОля on 08.01.2018.
 */

public class JSONWork {
    public static void writePreset(Preset preset) {
        JSONObject obj = new JSONObject();
        try {
            for (int i = 0; i < Preset.elements.length; i++) {
                obj.put(Preset.elements[i], preset.getObjectOfNumber(i));
            }
            File fileName = new File("presets.json");
            if (!fileName.exists())
                fileName.mkdirs();
            try {
                FileWriter f = new FileWriter(fileName);
                f.write(obj.toString());
                f.flush();
                f.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Preset readPreset() {
        Preset p = new Preset();
        try {
            StringBuilder jsonStr = new StringBuilder();
            File fileName = new File("presets.json");
            if (!fileName.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                String line;

                while ((line = br.readLine()) != null) {
                    jsonStr.append(line);
                    jsonStr.append('\n');

                }
            }
            JSONObject obj = new JSONObject(jsonStr.toString());
            for (int i = 0; i < Preset.elements.length; i++) {
                p.setObjectOfNumber(i, obj.get(Preset.elements[i]));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}
