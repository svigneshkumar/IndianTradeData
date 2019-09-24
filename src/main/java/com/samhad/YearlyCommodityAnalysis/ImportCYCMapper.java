package com.samhad.YearlyCommodityAnalysis;

import com.samhad.common.GenericMapLogic;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ImportCYCMapper extends Mapper<LongWritable, Text, CountryYearCommodityCompositeKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        GenericMapLogic genericImportMapLogic = new GenericMapLogic();
        genericImportMapLogic.importMap(value, context, true);
    }
}