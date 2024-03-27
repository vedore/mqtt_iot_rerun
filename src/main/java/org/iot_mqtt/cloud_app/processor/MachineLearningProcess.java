package org.iot_mqtt.cloud_app.processor;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.checkerframework.checker.units.qual.A;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.Remove;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MachineLearningProcess {

    private static final String TRAINNINGSETLOCATIONWITHOUTFILE = System.getProperty("user.dir") + "\\data";

    public static void main(String[] args) throws Exception {

        if (!new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.arff").exists()) {
            createArffFile();
        }


        ConverterUtils.DataSource source = new ConverterUtils.DataSource(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.arff");
        Instances dataSet = source.getDataSet();
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        //dataSet.deleteAttributeAt(0);
        //dataSet.deleteAttributeAt(0);

        Remove removeFilter = new Remove();
        removeFilter.setInvertSelection(true);
        removeFilter.setAttributeIndices("3");
        removeFilter.setInputFormat(dataSet);
        Instances outputs = Filter.useFilter(dataSet, removeFilter);

        removeFilter.setInvertSelection(false);
        removeFilter.setAttributeIndices("first-3");
        removeFilter.setInputFormat(dataSet);
        Instances inputs = Filter.useFilter(dataSet, removeFilter);

        System.out.println(inputs.numAttributes());
        System.out.println(outputs.numAttributes());

        // Normalize normalize = new Normalize();
        // normalize.setInputFormat(dataSet);

        RandomForest randomForest = new RandomForest();
        randomForest.setNumFeatures(1);
        randomForest.buildClassifier(inputs);

        System.out.println("ended");

        Evaluation eval = new Evaluation(inputs);
        eval.evaluateModel(randomForest, outputs);

        //Print the algorithm summary//



        // normalize.setInputFormat(dataSet);
        // Instances newdata = Filter.useFilter(dataSet, normalize);

        // System.out.println(newdata);


    }
    private static void createArffFile() {

        try {
            // Load CSV File
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.csv"));
            Instances data = loader.getDataSet();

            // Save as ARFF
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File(TRAINNINGSETLOCATIONWITHOUTFILE + "\\trainning.arff"));
            saver.writeBatch();

        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }

    private static Instances combineInstances(Instances D1, Instances D2) {

        Instances D = new Instances(D1);
        for(int i = 0; i < D2.numInstances(); i++) {
            D.add(D2.instance(i));
        }
        return D;
    }

    // HardCoded
    private static void createInstanceWithAtributes(String name, Instances dataset) {

        // ArrayList<Attribute> attributes = new ArrayList<Attribute>();

        // Attribute att = new Attribute("activity", 0);

        // attributes.add(dataset.)


    }


}
