package com.samhad.YearlyAnalysis;

import com.samhad.common.GenericMapLogic;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ExportCYMapper extends Mapper<LongWritable, Text, CountryYearCompositeKey, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        GenericMapLogic genericImportMapLogic = new GenericMapLogic();
        genericImportMapLogic.exportMap(value, context, false);
    }
}
