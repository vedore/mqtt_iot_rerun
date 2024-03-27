package org.iot_mqtt.cloud_app.processor;

import com.opencsv.*;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MachineLearningProcess {

    private static final String TRAINNINGSETLOCATIONWITHOUTFILE = System.getProperty("user.dir") + "\\data";

    public static void main(String[] args) {

        try {

            // Load CSV File
            // CSVLoader loader = new CSVLoader();
            // loader.setSource(new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.data"));
            // Instances data = loader.getDataSet();

            /*

            if (!new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.csv").exists()) {

                List<List<String>> records = new ArrayList<List<String>>();

                CSVParser parser = new CSVParserBuilder()
                        .withSeparator(';')
                        .withIgnoreQuotations(true)
                        .build();


                try (CSVReader csvReader = new CSVReaderBuilder(
                        new FileReader(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.data"))
                        .withSkipLines(0)
                        .withCSVParser(parser)
                        .build()) {

                    String[] values = null;

                    while ((values = csvReader.readNext()) != null) {
                        records.add(Arrays.asList(values));
                    }
                }

                createCSV(records);

            }

             */

            ConverterUtils.DataSource source = new ConverterUtils.DataSource(TRAINNINGSETLOCATIONWITHOUTFILE + "\\mqtt_data.rowData.csv");
            Instances data = source.getDataSet();

            System.out.println(data);

            // Save as ARFF


            /*ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.arff"));
            saver.writeBatch();

            // Labels
            data.setClassIndex(0);

            // System.out.println(data.attribute(1));

            /*

            System.out.println(data);

            // Normalize
            Normalize normalizeFilter = new Normalize();
            normalizeFilter.setInputFormat(data);
            Instances normalizedData = Filter.useFilter(data, normalizeFilter);

            // Separate features and labels
            Instances features = new Instances(normalizedData, 1, normalizedData.numAttributes() - 1);
            Instances labels = new Instances(normalizedData, 0);

            // Train The Random Forest Classifier

            /*

            RandomForest rf = new RandomForest();
            rf.buildClassifier(normalizedData);

            // System.out.println(normalizedData);

            weka.core.SerializationHelper.write(TRAINNINGSETLOCATIONWITHOUTFILE + "\\random_forest.model", rf);

            */


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createCSV(List<List<String>> records) {

        try(CSVWriter writer = new CSVWriter(new FileWriter((TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.csv")))) {

            for (List<String> each: records) {
                String[] eachArray = each.toArray(new String[] {});
                writer.writeNext(eachArray);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
