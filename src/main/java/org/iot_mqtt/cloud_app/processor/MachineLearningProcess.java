package org.iot_mqtt.cloud_app.processor;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.math3.analysis.function.*;
import weka.classifiers.trees.RandomForest;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import org.apache.commons.math3.analysis.UnivariateFunction;

import org.apache.commons.math3.analysis.function.Min;
import org.apache.commons.math3.analysis.function.Max;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Random;

public class MachineLearningProcess {

    private static final String TRAINNINGSETLOCATIONWITHOUTFILE = System.getProperty("user.dir") + "\\data";

    public static void main(String[] args) {

        try {

            // Load CSV File
            // CSVLoader loader = new CSVLoader();
            // loader.setSource(new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.data"));
            // Instances data = loader.getDataSet();

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
}
