package org.iot_mqtt.cloud_app.processor;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.iot_mqtt.cloud_app.processor.cloud_object.RowData;
import org.iot_mqtt.cloud_app.processor.cloud_service.RowDataService;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataLoader {

    private static final String TRAINNINGSETLOCATION = System.getProperty("user.dir") + "\\data\\trainning.data";

    public static Table loadTrainningSet() {

        File trainningSet = new File(TRAINNINGSETLOCATION);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy", Locale.ENGLISH);

        CsvReadOptions.Builder builder =
                CsvReadOptions.builder(trainningSet)
                        .separator(';')
                        .dateFormat(dateFormatter)
                        .header(true);

        CsvReadOptions options = builder.build();

        return Table.read().usingOptions(options);

    }

    public static void loadTrainningSetIntoDatabase(RowDataService rowDataService) {

        try (MongoClient client = MongoClients.create("mongodb://localhost:27017")) {

            Table table = loadTrainningSet();

            LocalDate date;

            String time;

            int activity;

            double acceleration_x, acceleration_y, acceleration_z, gyro_x, gyro_y, gyro_z;

            RowData rowData;

            for (Row row: table) {

                date = (LocalDate) row.getObject("date");
                time = row.getString("time");
                activity = row.getInt("activity");
                acceleration_x = row.getDouble("acceleration_x");
                acceleration_y = row.getDouble("acceleration_y");
                acceleration_z = row.getDouble("acceleration_z");
                gyro_x = row.getDouble("gyro_x");
                gyro_y = row.getDouble("gyro_y");
                gyro_z = row.getDouble("gyro_z");

                rowData = new RowData(date, time, activity, acceleration_x, acceleration_y, acceleration_z, gyro_x, gyro_y, gyro_z);

                rowDataService.add(rowData);

            }

            System.out.println("Added " + table.rowCount() + " Rows");
        }

    }
}
