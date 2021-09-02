package com.akshitbansal.assignment2;

import com.akshitbansal.assignment1.HdfsToHBase;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class WordCount {

    public static String inputUrl = "/dataDirectory/Input_Assignment2/inputText.txt";
    public static String outputUrl = "/dataDirectory/Input_Assignment2/Output";

    public static class Map extends MapReduceBase implements 
            Mapper<LongWritable, Text, Text, IntWritable> {

        @Override
        public void map(LongWritable key,
                        Text value,
                        OutputCollector<Text, IntWritable> outputCollector,
                        Reporter reporter) throws IOException {

            String singleLineData = value.toString();
            StringTokenizer st = new StringTokenizer(singleLineData, " ");
            while(st.hasMoreElements()) {
                String word = st.nextToken();
                outputCollector.collect(new Text(word), new IntWritable(1));
            }
        }
    }

    public static class Reduce extends MapReduceBase implements
            Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        public void reduce(Text key,
                           Iterator<IntWritable> value,
                           OutputCollector<Text, IntWritable> outputCollector,
                           Reporter reporter) throws IOException {

            int wordCount = 0;
            while(value.hasNext()) {
                wordCount += value.next().get();
            }
            outputCollector.collect(key, new IntWritable(wordCount));
        }
    }

    public static void main(String[] args) throws IOException {
        JobConf config = new JobConf(WordCount.class);

        config.setJobName("Word Count");

        config.setMapperClass(Map.class);
        config.setReducerClass(Reduce.class);

        config.setInputFormat(TextInputFormat.class);
        config.setOutputFormat(TextOutputFormat.class);

        config.setMapOutputKeyClass(Text.class);
        config.setMapOutputValueClass(IntWritable.class);

        config.setOutputKeyClass(Text.class);
        config.setOutputValueClass(IntWritable.class);

        //input and output file location.
        String inputPath = HdfsToHBase.getPath(inputUrl);
        String outputPath = HdfsToHBase.getPath(outputUrl);
        FileInputFormat.addInputPath(config,new Path(inputPath));
        FileOutputFormat.setOutputPath(config,new Path(outputPath));

        JobClient.runJob(config);
    }
}
