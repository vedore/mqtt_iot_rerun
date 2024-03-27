package org.iot_mqtt.cloud_app;

import org.iot_mqtt.cloud_app.processor.DataLoader;
import org.iot_mqtt.cloud_app.processor.cloud_service.RowDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainService implements CommandLineRunner {

    private final RowDataService rowDataService;

    public static void main(String[] args) {
        SpringApplication.run(MainService.class, args);
    }

    @Autowired
    public MainService(RowDataService rowDataService) {
        this.rowDataService = rowDataService;
    }

    @Override
    public void run(String... args){

        if (rowDataService.size() == 0) {
            DataLoader.loadTrainningSetIntoDatabase(rowDataService);
            System.out.println("Added " + rowDataService.size() + " Rows");

        } else {
            System.out.println("No Need To Add Data");
        }

    }
}
