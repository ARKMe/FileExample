package bello.andrea.fileexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            String lineSep = System.getProperty("line.separator");
            String data = "PROVA éò! FINE" + lineSep + "sdhfhsjfbl hacbka" ;

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(getFilesDir() + "/mio_file.txt");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("UTF-8"));
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                FileInputStream fileInputStream = new FileInputStream(getFilesDir() + "/mio_file.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder stringBuilder = new StringBuilder();

                String line = bufferedReader.readLine();
                if(line != null)
                    stringBuilder.append(line);

                line = bufferedReader.readLine();
                while(line != null){
                    stringBuilder.append(lineSep).append(line);
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();

                ((TextView)findViewById(R.id.textview)).setText(stringBuilder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

}
