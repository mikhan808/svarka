package com.example.mikhan808.svarka;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by МишаИОля on 08.01.2018.
 */

public class JSONWork {
   public static void writePreset(Preset preset)
   {
       JSONObject obj = new JSONObject();
       try {
           obj.put("name",preset.name);
           obj.put("first_level",preset.first_level);
           obj.put("second_level",preset.second_level);
           obj.put("duration",preset.duration);
           obj.put("pressure",preset.pressure);
           File fileName = new File("presets.json");
           if (!fileName.exists())
               fileName.mkdirs();
           try {
               FileWriter f = new FileWriter(fileName);
               f.write(obj.toString());
               f.flush();
               f.close();
           } catch (Exception e) {

           }
       } catch (JSONException e) {
           e.printStackTrace();
       }
   }
}
