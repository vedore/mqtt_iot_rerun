package org.iot_mqtt.cloud_app.processor.cloud_service;

import org.iot_mqtt.cloud_app.processor.cloud_object.RowData;
import org.iot_mqtt.cloud_app.processor.cloud_repository.RowDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RowDataService {

    private final RowDataRepository rowDataRepository;

    @Autowired
    public RowDataService(RowDataRepository rowDataRepository) {
        this.rowDataRepository = rowDataRepository;
    }

    public void add(RowData rowData) {
        rowDataRepository.insert(rowData);
    }

    public int size(){
        return (int) rowDataRepository.count();
    }
}
