package org.iot_mqtt.cloud_app.processor;

import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataManipulation {

    private static final String TRAININGFILELOCATION = System.getProperty("user.dir") + "\\data";

    public static void main(String[] args) {

        if(!new File(TRAININGFILELOCATION + "\\trainning.csv").exists()) {

            File file = new File(TRAININGFILELOCATION + "\\trainning.data");

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

            CsvReadOptions.Builder builder =
                    CsvReadOptions.builder(file)
                            .separator(';')
                            .dateFormat(dateFormatter)
                            .header(true);

            CsvReadOptions options = builder.build();

            Table table = Table.read().usingOptions(options);

            // System.out.println(table.structure());

        } else{
          System.out.println("Already Exists");
        }

    }

}
