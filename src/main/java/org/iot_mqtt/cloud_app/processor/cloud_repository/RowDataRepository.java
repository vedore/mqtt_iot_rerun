package org.iot_mqtt.cloud_app.processor.cloud_repository;

import org.iot_mqtt.cloud_app.processor.cloud_object.RowData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowDataRepository extends MongoRepository<RowData, String> {

}
