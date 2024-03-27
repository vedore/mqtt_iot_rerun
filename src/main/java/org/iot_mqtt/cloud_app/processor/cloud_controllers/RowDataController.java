package org.iot_mqtt.cloud_app.processor.cloud_controllers;

import org.iot_mqtt.cloud_app.processor.cloud_service.RowDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class RowDataController {

    private final RowDataService rowDataService;

    @Autowired
    public RowDataController(RowDataService rowDataService) {
        this.rowDataService = rowDataService;
    }

}
